package ync.zoomgobackend.domain.category.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ync.zoomgobackend.domain.category.entity.CategoryEntity;
import ync.zoomgobackend.domain.category.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/gosu")
@RequiredArgsConstructor
public class CategoryController {
    final private CategoryService categoryService;
    @GetMapping("/getCategory")
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryEntity> getCategoryList() {
        return categoryService.getAllCategories();
    }
}
