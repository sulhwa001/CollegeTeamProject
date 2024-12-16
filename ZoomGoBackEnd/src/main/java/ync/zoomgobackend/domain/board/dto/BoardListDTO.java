package ync.zoomgobackend.domain.board.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardListDTO {
    private Long id;
    private String title;
    private int price;
    private LocalDateTime createdAt;
    private int view;
    private String file;


}