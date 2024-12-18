package ync.zoomgobackend.domain.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ync.zoomgobackend.domain.board.entity.ZCategoryEntity;

public interface ZCategoryRepository extends JpaRepository<ZCategoryEntity, Long> {
}
