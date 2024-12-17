package ync.zoomgobackend.domain.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ync.zoomgobackend.domain.board.entity.ZCategoryEntity;

@Repository("ZCategoryRepository")
public interface ZCategoryRepository extends JpaRepository<ZCategoryEntity, Long> {
}
