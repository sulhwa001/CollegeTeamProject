package ync.zoomgobackend.domain.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ync.zoomgobackend.domain.board.entity.CategoryEntity;

@Repository("boardCategoryRepository")
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
