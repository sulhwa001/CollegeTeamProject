package kr.ac.ync.zoomgobackend.domain.gosu.entity;

import jakarta.persistence.*;
import kr.ac.ync.zoomgobackend.domain.category.entity.CategoryEntity;
import lombok.*;

@Entity
@Table(name = "gosu_portfolio")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@ToString
public class GosuPortfolioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gosuPortfolioId;

    @ManyToOne
    @JoinColumn(name = "gosuId")
    private GosuEntity gosuId;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private CategoryEntity categoryId;

    @ManyToOne
    @JoinColumn(name = "userNo")
    private MemberEntity userNo;

    @Column
    private String title;

    @Column
    private String area;

    @Column
    private int price;

    @Column
    private int workYear;

    @Column
    private int workTime;

    @Column
    private String workArticle;
}

