package ync.zoomgobackend.domain.reply.eneity;

import jakarta.persistence.*;
import lombok.*;
import ync.zoomgobackend.domain.member.entity.MemberEntity;
import ync.zoomgobackend.global.common.BaseEntity;
import ync.zoomgobackend.domain.reply.entity.ReplyEntity;

@Entity
@Table(name = "USED_TRADE_REPLY_REPLY")
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
@Getter
@ToString(exclude = {"member", "reply"})
public class ReplyReplyEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Reply_Reply_Id")
    private Long replyReplyId; // 대댓글 고유 ID

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Reply_Id", nullable = false)
    private ReplyEntity reply; // 댓글 참조

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserNo", nullable = false)
    private MemberEntity member; // 작성자 정보 참조

    @Column(name = "Contents", nullable = false, columnDefinition = "TEXT")
    private String contents; // 대댓글 내용

}
