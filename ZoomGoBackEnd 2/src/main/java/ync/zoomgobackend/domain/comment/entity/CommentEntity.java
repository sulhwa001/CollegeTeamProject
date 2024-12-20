package ync.zoomgobackend.domain.comment.entity;

import jakarta.persistence.*;
import lombok.*;
import ync.zoomgobackend.domain.community.entity.CommunityEntity;
import ync.zoomgobackend.domain.member.entity.MemberEntity;
import ync.zoomgobackend.global.common.entity.BaseEntity;

@Entity
@Table(name = "Community_Comment")
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class CommentEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(nullable = false)
    private Long commentNo;

    @Column(length = 500, nullable = false)
    private String commentText;

    @Column(nullable = false)
    private Long commentDept;

    @ManyToOne(fetch = FetchType.LAZY)
    private CommunityEntity communityEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    private MemberEntity memberEntity;

}
