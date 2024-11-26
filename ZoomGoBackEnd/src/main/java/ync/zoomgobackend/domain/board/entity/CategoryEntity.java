package ync.zoomgobackend.domain.board.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
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
    @Column(name = "Category_id")
    private Long categoryId; // 카테고리 고유 ID, 자동 증가

    @Column(name = "Category_name", unique = true, nullable = false, length = 100)
    private String categoryName; // 카테고리 고유명

   @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
   private List<BoardEntity> boards; //실제 db 추가되는거 x 맵핑을 위함 실제로 추가되는건 board에 카테고리 칼럼


}
