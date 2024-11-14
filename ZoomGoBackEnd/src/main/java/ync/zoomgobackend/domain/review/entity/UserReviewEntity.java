package ync.zoomgobackend.domain.review.entity;

import jakarta.persistence.*;
import lombok.*;
import ync.zoomgobackend.domain.member.entity.MemberEntity;
import ync.zoomgobackend.global.common.entity.BaseEntity;

@Entity
@Table(name = "userReview")
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserReviewEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reviewer", nullable = false)
    private MemberEntity reviewer;  //리뷰를 작성하는 유저

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userNo", nullable = false)
    private MemberEntity user;    //리뷰를 받는 유저의 번호

    @Column(nullable = false)
    private double recommand;

}
