package ync.zoomgobackend.domain.board.entity;

import jakarta.persistence.*;
import lombok.*;
import ync.zoomgobackend.domain.member.entity.MemberEntity;
import ync.zoomgobackend.global.common.entity.BaseEntity;

@Entity
@Table(name = "community")
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class BoardEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postNo;

    @Column(nullable = false, length = 200)
    private String communityType;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, length = 5000)
    private String post;

    @Column
    private String photoURL;

    @Column
    private int views;

    @Column
    private int recommand;

    @ManyToOne(fetch = FetchType.LAZY)
    private MemberEntity member;
}
