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
    private String replyer; // 작성자
    private String text; // 댓글 내용
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
