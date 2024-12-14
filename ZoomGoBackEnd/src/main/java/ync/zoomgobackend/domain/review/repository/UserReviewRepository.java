package ync.zoomgobackend.domain.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ync.zoomgobackend.domain.review.entity.UserReviewEntity;

public interface UserReviewRepository extends JpaRepository<UserReviewEntity, Long> {


}
