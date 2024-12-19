package ync.zoomgobackend.domain.gosuportfolio.entity;

import jakarta.persistence.*;
import ync.zoomgobackend.domain.category.entity.CategoryEntity;
import ync.zoomgobackend.domain.gosu.entity.GosuEntity;
import ync.zoomgobackend.domain.member.entity.MemberEntity;
import lombok.*;

import java.io.File;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Table(name = "gosu_portfolio_image")
public class GosuPortfolioImageEntity {
    @Id
    @OneToOne
    @JoinColumn(name = "gosuPortfolioId")
    private GosuPortfolioEntity gosuPortfolio;

    @JoinColumn(name = "gosuId")
    @ManyToOne(fetch = FetchType.LAZY)
    private GosuEntity gosuId;

//    @JoinColumn(name = "categoryId")
//    @ManyToOne(fetch = FetchType.LAZY)
//    private CategoryEntity categoryId;

    @JoinColumn(name = "userNo")
    @ManyToOne(fetch = FetchType.LAZY)
    private MemberEntity userNo;

    @Column
    private File image;
    @Column
    private File detail_image1;
    @Column
    private File detail_image2;
    @Column
    private File detail_image3;
    @Column
    private File detail_image4;

}
