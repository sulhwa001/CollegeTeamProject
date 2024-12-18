package ync.zoomgobackend.domain.reply.eneity;

import jakarta.persistence.*;
import lombok.*;
import ync.zoomgobackend.domain.board.entity.BoardEntity;
import ync.zoomgobackend.domain.member.entity.MemberEntity;
import ync.zoomgobackend.global.common.BaseEntity;

@Table(name = "USED_TRADE_REPLY")
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
@Getter
@ToString(exclude = {"member", "board"})
public class ReplyEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Reply_Id")
    private Long replyId; // 댓글 고유 ID

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Post_Id", nullable = false)
    private BoardEntity board; // 게시글 참조

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserNo", nullable = false)
    private MemberEntity member; // 작성자 정보 참조

    @Column(name = "Contents", nullable = false)
    private String contents; // 댓글 내용

}
