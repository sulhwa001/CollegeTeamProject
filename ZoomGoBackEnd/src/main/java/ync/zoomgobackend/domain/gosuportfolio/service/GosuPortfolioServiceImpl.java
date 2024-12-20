package ync.zoomgobackend.domain.gosuportfolio.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ync.zoomgobackend.domain.category.entity.CategoryEntity;
import ync.zoomgobackend.domain.gosu.entity.GosuEntity;
import ync.zoomgobackend.domain.gosuportfolio.dto.GosuPortfolioDTO;
import ync.zoomgobackend.domain.gosuportfolio.entity.GosuPortfolioEntity;
import ync.zoomgobackend.domain.gosuportfolio.repository.GosuPortfolioRepository;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class GosuPortfolioServiceImpl implements GosuPortfolioService{
    private final GosuPortfolioRepository gosuPortfolioRepository;
    @Override
    public Long insertPortfolio(GosuPortfolioDTO gosuPortfolioDTO) {
        GosuPortfolioEntity gosuPortfolioEntity = insertDtoToEntity(gosuPortfolioDTO);
        Long id1 = gosuPortfolioRepository.save(gosuPortfolioEntity).getGosu().getGosuId();
       return id1;
    }

    @Override
    public GosuPortfolioDTO getPortfolioIdByGosuId(Long gosuId) {
        Optional<GosuPortfolioEntity> gosuPortfolioEntity = gosuPortfolioRepository.findByGosu_gosuId(gosuId);
        return portfolioEntityToDTO(gosuPortfolioEntity);
    }

    @Override
    public Long updatePortfolio(GosuPortfolioDTO gosuPortfolioDTO) {
        GosuPortfolioEntity gosuPortfolio = gosuPortfolioRepository.findByGosu_gosuId((gosuPortfolioDTO.getGosuId())).orElse(null);
        CategoryEntity categoryEntity = CategoryEntity.builder().categoryId(gosuPortfolioDTO.getCategoryId()).build();
        gosuPortfolio.updateCategoryId(categoryEntity);
        gosuPortfolio.updateArea(gosuPortfolioDTO.getArea());
        gosuPortfolio.updateTitle(gosuPortfolioDTO.getTitle());
        gosuPortfolio.updateWorkYear(gosuPortfolioDTO.getWorkYear());
        gosuPortfolio.updatePrice(gosuPortfolioDTO.getPrice());
        gosuPortfolio.updateWorkTime(gosuPortfolioDTO.getWorkTime());
        gosuPortfolio.updateWorkArticle(gosuPortfolioDTO.getWorkArticle());

        return gosuPortfolio.getGosuPortfolioId();
    }
}
