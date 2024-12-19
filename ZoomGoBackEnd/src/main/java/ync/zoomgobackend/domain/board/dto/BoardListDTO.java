package ync.zoomgobackend.domain.board.dto;

import lombok.*;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BoardListDTO {
    private Long postNo;
    private String title;
    private LocalDateTime createdAt; // 등록 시간
    private int view;
    private int price;
    private String file;
}