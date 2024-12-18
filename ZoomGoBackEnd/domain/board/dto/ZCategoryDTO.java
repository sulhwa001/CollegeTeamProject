package ync.zoomgobackend.domain.board.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDTO {
    private Long categoryId;     // 카테고리 ID
    private String categoryName; // 카테고리 이름
}
