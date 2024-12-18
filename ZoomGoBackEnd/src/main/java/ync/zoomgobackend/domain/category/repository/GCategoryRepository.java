package ync.zoomgobackend.domain.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ync.zoomgobackend.domain.category.entity.GCategoryEntity;

@Repository("gcategoryRepository")
public interface GCategoryRepository extends JpaRepository<GCategoryEntity, Long> {

}
