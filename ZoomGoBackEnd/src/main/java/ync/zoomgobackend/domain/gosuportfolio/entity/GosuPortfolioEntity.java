package ync.zoomgobackend.domain.gosuportfolio.entity;

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
@Builder
@Setter
@ToString
public class GosuPortfolioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gosuPortfolioId;
    @ManyToOne
    @JoinColumn(name = "gosu_id")
    private GosuEntity gosu;
//    @ManyToOne
//    @JoinColumn(name = "categoryId")
//    private CategoryEntity categoryId;
    @ManyToOne
    @JoinColumn(name = "user_no")
    private MemberEntity userNo;
    @Column
    private String title;
    @Column
    private String area;
    @Column
    private Integer price;
    @Column
    private Integer workYear;
    @Column
    private String workTime;
    @Column
    private String workArticle;
}

