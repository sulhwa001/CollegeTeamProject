package ync.zoomgobackend.domain.review.entity;

import jakarta.persistence.*;
import lombok.*;
import ync.zoomgobackend.domain.estimate.entity.EstimateEntity;
import ync.zoomgobackend.domain.gosu.entity.GosuEntity;

import ync.zoomgobackend.domain.gosuportfolio.entity.GosuPortfolioEntity;
import ync.zoomgobackend.domain.member.entity.MemberEntity;
import ync.zoomgobackend.global.common.entity.BaseEntity;

@Entity
@Table(name = "gosuReview")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class GosuReviewEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewNo;

    @ManyToOne(fetch = FetchType.LAZY)
    private MemberEntity member;

    @ManyToOne(fetch = FetchType.LAZY)
    private GosuEntity gosu;

    @ManyToOne(fetch = FetchType.LAZY)
    private EstimateEntity estimate;

    @ManyToOne(fetch = FetchType.LAZY)
    private GosuPortfolioEntity gosuPortfolio;

    @Column(length = 500, nullable = false)
    private String review;

    @Column(nullable = false)
    private double recommend;

    @Column
    private String photoURL;

    @Column
    private String tag;

}
