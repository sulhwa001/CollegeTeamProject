package ync.zoomgobackend.domain.estimate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ync.zoomgobackend.domain.estimate.entity.AskEstimateEntity;

import java.util.Optional;
@Repository
public interface AskEstimateRepository extends JpaRepository<AskEstimateEntity, Long> {
    @Query("SELECT a FROM AskEstimateEntity a WHERE a.userNo.id = :userNo and a.gosuId.id = :gosuId")
    Optional<AskEstimateEntity> findByUserNoAndGosuId(@Param("userNo") Long userNo, @Param("gosuId") Long gosuId);
}
