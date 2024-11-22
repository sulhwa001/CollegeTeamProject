package ync.zoomgobackend.domain.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ync.zoomgobackend.domain.review.entity.GosuReviewEntity;

public interface GosuReviewRepository extends JpaRepository<GosuReviewEntity,Long> {

    @Query(value = "SELECT g, e, m, c " +
            "FROM EstimateEntity e " +
            "LEFT JOIN e.GosuEntity g " +
            "LEFT JOIN e.MemberEntity m " +
            "LEFT JOIN e.CategoryEntity c " +
            "WHERE e.estimateId =:estimateId")
    Object getGosuReviewByEstimateId(@Param("estimateId")Long estimateId);
}
