package ync.zoomgobackend.domain.gosu.dto;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GosuChangeDTO {
    private Long userNo;
    private String name;
}
