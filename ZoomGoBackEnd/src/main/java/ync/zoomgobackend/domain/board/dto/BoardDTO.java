package ync.zoomgobackend.domain.board.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    private Long postNo;
    private Long memberNo;
    private String communityType;
    private String title;
    private String memberNickname;
    private String post;
    private String photoURL;
    private int replyCnt;
    private LocalDateTime createdDate, modifiedDate;
    private int views;
    private int recommands;
}
