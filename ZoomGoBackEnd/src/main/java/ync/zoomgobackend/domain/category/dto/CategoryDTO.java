package ync.zoomgobackend.domain.category.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class CategoryDTO {
    @Id
    private Long categoryId;
    @Column(nullable = false)
    private String categoryName;
}
