package ync.zoomgobackend.domain.category.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private Long categoryId;

    @Column(nullable = false)
    private String categoryName;
}
