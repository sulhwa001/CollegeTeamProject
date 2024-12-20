package ync.zoomgobackend.domain.reply.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ReplyDTO {
    private Long replyId;
    private Long boardId; // 게시글 ID
    private Long memberId; // 작성자 ID
    private String contents; // 댓글 내용
}
