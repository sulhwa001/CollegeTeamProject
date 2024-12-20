package ync.zoomgobackend.domain.category.service;

import org.springframework.stereotype.Service;
import ync.zoomgobackend.domain.category.entity.CategoryEntity;
import java.util.List;
@Service
public interface CategoryService {
    List<CategoryEntity> getAllCategories();
}
