package kr.ac.ync.zoomgobackend.domain.gosu.dto;

import kr.ac.ync.zoomgobackend.domain.member.entity.MemberEntity;
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
