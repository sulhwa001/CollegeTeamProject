package ync.zoomgobackend.domain.gosuportfolio.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import ync.zoomgobackend.domain.category.entity.CategoryEntity;
import ync.zoomgobackend.domain.gosu.dto.GosuDTO;
import ync.zoomgobackend.domain.gosu.entity.GosuEntity;
import ync.zoomgobackend.domain.gosuportfolio.dto.GosuPortfolioDTO;
import ync.zoomgobackend.domain.gosuportfolio.entity.GosuPortfolioEntity;
import ync.zoomgobackend.domain.member.entity.MemberEntity;

import java.lang.reflect.Member;
import java.util.Optional;

@Service
public interface GosuPortfolioService {

    Long insertPortfolio(GosuPortfolioDTO gosuPortfolioDTO);

    GosuPortfolioDTO getPortfolioIdByGosuId(Long gosuId);

    Long updatePortfolio(GosuPortfolioDTO gosuPortfolioDTO);
    default GosuPortfolioEntity insertDtoToEntity(GosuPortfolioDTO gosuDTO) {
        GosuEntity gosu = GosuEntity.builder().gosuId(gosuDTO.getGosuId()).build();
        MemberEntity member = MemberEntity.builder().userNo(gosuDTO.getUserNo()).build();
        CategoryEntity categoryEntity = CategoryEntity.builder().categoryId(gosuDTO.getCategoryId()).build();
        return GosuPortfolioEntity
                .builder()
                .gosuId(gosu)
                .categoryId(categoryEntity)
                .userNo(member)
                .area(gosuDTO.getArea())
                .price(gosuDTO.getPrice())
                .title(gosuDTO.getTitle())
                .workArticle(gosuDTO.getWorkArticle())
               .workTime(gosuDTO.getWorkTime())
                .workYear(gosuDTO.getWorkYear())
                .build();
    }
    default GosuPortfolioDTO portfolioEntityToDTO(Optional<GosuPortfolioEntity> gosuPortfolioEntityOptional) {
        GosuPortfolioEntity gosuEntity = gosuPortfolioEntityOptional
                .orElseThrow(() -> new EntityNotFoundException("GosuEntity not found"));


        return GosuPortfolioDTO
                .builder()
                .categoryId(gosuEntity.getCategoryId().getCategoryId())
                .gosuId(gosuEntity.getGosuId().getGosuId())
                .userNo(gosuEntity.getGosuId().getUser().getUserNo())
                .area(gosuEntity.getArea())
                .price(gosuEntity.getPrice())
                .title(gosuEntity.getTitle())
                .workArticle(gosuEntity.getWorkArticle())
                .workTime(gosuEntity.getWorkTime())
                .workYear(gosuEntity.getWorkYear())
                .build();
    }
}
