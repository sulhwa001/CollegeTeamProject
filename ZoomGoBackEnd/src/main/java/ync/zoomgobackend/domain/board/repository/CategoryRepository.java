package ync.zoomgobackend.domain.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ync.zoomgobackend.domain.board.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
