package ync.zoomgobackend.domain.category.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ync.zoomgobackend.domain.category.entity.CategoryEntity;
import ync.zoomgobackend.domain.category.repository.CategoryRepository;

import java.util.List;
@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService{


    final private CategoryRepository categoryRepository;
    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }
}
