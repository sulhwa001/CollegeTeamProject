package ync.zoomgobackend.domain.board.dto;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BoardListDTO {
    private Long postNo;
    private String title;
    private int replyCnt;
    private LocalDateTime createdDate;
    private int views;
    private int recommands;
}
