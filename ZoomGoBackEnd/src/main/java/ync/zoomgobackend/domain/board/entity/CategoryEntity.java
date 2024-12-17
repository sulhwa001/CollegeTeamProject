package ync.zoomgobackend.domain.board.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "tradeCategoryEntity")
@Table(name = "USED_Categories")
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId; // 카테고리 고유 ID, 자동 증가

    @Column(name = "category_name", unique = true, nullable = false, length = 100)
    private String categoryName; // 카테고리 고유명

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BoardEntity> boards;  // BoardEntity와의 관계 설정


}
