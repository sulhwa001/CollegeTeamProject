package kr.ac.ync.zoomgobackend.domain.gosu.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Builder
@Getter
@Setter
@Table(name = "category")
@ToString
public class CategoryEntity {
    @Id
    private int categoryId;
    @Column(nullable = false)
    private String categoryName;
}
