package ync.zoomgobackend.domain.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ync.zoomgobackend.domain.review.entity.GosuReviewEntity;

import java.util.List;

public interface GosuReviewRepository extends JpaRepository<GosuReviewEntity,Long> {

    @Query("SELECT r, g, m, p " +
            "FROM GosuReviewEntity r " +
            "LEFT JOIN r.member m " +
            "LEFT JOIN r.gosu g " +
            "LEFT JOIN r.gosuPortfolio p " +
            "WHERE g.gosuId = :gosuId " +
            "ORDER BY r.reviewNo DESC")
    List<Object[]> getByGosuId(@Param("gosuId")Long gosuId);

}
