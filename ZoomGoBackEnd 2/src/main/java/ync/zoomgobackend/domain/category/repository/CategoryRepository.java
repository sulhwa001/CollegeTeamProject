package ync.zoomgobackend.domain.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ync.zoomgobackend.domain.category.entity.CategoryEntity;

@Repository("gcategoryRepository")
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

}
