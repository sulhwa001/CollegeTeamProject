package ync.zoomgobackend.domain.gosuportfolio;

import jakarta.persistence.*;
import ync.zoomgobackend.domain.category.entity.CategoryEntity;
import ync.zoomgobackend.domain.gosu.entity.GosuEntity;
import ync.zoomgobackend.domain.member.entity.MemberEntity;
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

