package kr.ac.ync.zoomgobackend.domain.category.repository;

import kr.ac.ync.zoomgobackend.domain.category.entity.CategoryEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

@SpringBootTest
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;


    @Test
    void insertData() {
        List<String> categoryName = new ArrayList<>();
        categoryName.add("음악/연주");
        categoryName.add("공부/과외");
        categoryName.add("수리");
        categoryName.add("제조");
        categoryName.add("엔지니어");
        categoryName.add("예술");
        categoryName.add("사회복지");
        categoryName.add("법률");
        categoryName.add("금융");
        categoryName.add("변호사");
        categoryName.add("마케팅");
        categoryName.add("미술/디자인");
        categoryName.add("인테리어");

        LongStream.rangeClosed(0, 12).forEach(i -> {
            CategoryEntity categoryEntity = CategoryEntity.builder()
                    .categoryId(i+1)
                    .categoryName(categoryName.get((int) i))
                    .build();

            categoryRepository.save(categoryEntity);

        });
    }
}