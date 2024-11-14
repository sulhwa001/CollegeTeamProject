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
    private Long memberNo;
    private Long commentNo;
    private String userNickname;
    private String pComment;
    private String cComment;
    private Long commentDept;
    private LocalDateTime createdDate;
}
