package ync.zoomgobackend.domain.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ync.zoomgobackend.domain.review.entity.GosuReviewEntity;

public interface GosuReviewRepository extends JpaRepository<GosuReviewEntity,Long> {


}
