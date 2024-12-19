package ync.zoomgobackend.domain.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ync.zoomgobackend.domain.review.entity.UserReviewEntity;

import java.util.List;

public interface UserReviewRepository extends JpaRepository<UserReviewEntity, Long> {

    @Query("SELECT u, r " +
            "FROM UserReviewEntity u " +
            "LEFT JOIN u.reviewer r " +
            "WHERE r.userNo = :userNo ")
    List<Object[]> getByUserNo(@Param("userNo")Long userNo);

}
