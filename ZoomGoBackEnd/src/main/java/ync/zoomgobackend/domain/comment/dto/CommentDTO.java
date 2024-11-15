package ync.zoomgobackend.domain.comment.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
    private Long postNo;
    private Long commentId;
    private Long memberNo;
    private Long commentNo;
    private String userNickname;
    private String commentText;
    private Long commentDept;
    private LocalDateTime createdDate;
}
