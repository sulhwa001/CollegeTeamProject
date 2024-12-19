package ync.zoomgobackend.domain.estimate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ync.zoomgobackend.domain.estimate.entity.EstimateEntity;

@Repository
public interface ExportEstimateRepository extends JpaRepository<EstimateEntity, Long> {

}
