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

    default GosuPortfolioEntity insertDtoToEntity(GosuPortfolioDTO gosuDTO) {
        GosuEntity gosu = GosuEntity.builder().gosuId(gosuDTO.getGosuId()).build();
        MemberEntity member = MemberEntity.builder().userNo(gosuDTO.getUserNo()).build();
        return GosuPortfolioEntity
                .builder()
                .gosu(gosu)
                .userNo(member)
                .area(gosuDTO.getArea())
                .price(gosuDTO.getPrice())
                .title(gosuDTO.getTitle())
                .workArticle(gosuDTO.getWorkArticle())
               .workTime(gosuDTO.getWorkTime())
                .workYear(gosuDTO.getYear())
                .build();
    }
    default GosuPortfolioDTO portfolioEntityToDTO(Optional<GosuPortfolioEntity> gosuPortfolioEntityOptional) {
        GosuPortfolioEntity gosuEntity = gosuPortfolioEntityOptional
                .orElseThrow(() -> new EntityNotFoundException("GosuEntity not found"));


        return GosuPortfolioDTO
                .builder()
                .gosuId(gosuEntity.getGosu().getGosuId())
                .userNo(gosuEntity.getGosu().getUser().getUserNo())
                .area(gosuEntity.getArea())
                .price(gosuEntity.getPrice())
                .title(gosuEntity.getTitle())
                .workArticle(gosuEntity.getWorkArticle())
                .workTime(gosuEntity.getWorkTime())
                .year(gosuEntity.getWorkYear())
                .build();
    }
}
