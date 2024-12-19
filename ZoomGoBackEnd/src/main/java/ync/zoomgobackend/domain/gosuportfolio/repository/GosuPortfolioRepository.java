package ync.zoomgobackend.domain.gosuportfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ync.zoomgobackend.domain.gosuportfolio.entity.GosuPortfolioEntity;

import java.util.Optional;

public interface GosuPortfolioRepository extends JpaRepository<GosuPortfolioEntity, Long> {

    Optional<GosuPortfolioEntity> findByGosu_gosuId(Long gosuId);

}
