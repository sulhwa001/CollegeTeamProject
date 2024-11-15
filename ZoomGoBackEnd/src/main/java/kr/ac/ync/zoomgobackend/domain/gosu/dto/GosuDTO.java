package kr.ac.ync.zoomgobackend.domain.gosu.dto;

import kr.ac.ync.zoomgobackend.domain.member.entity.MemberEntity;
import lombok.*;

import java.io.File;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GosuDTO {
    private String name;
    private Long userNo;
    private String possibleTime;
    private int price;
    private String career;
    private String serviceDetail;
    private String area;
    private String graduation;
    private String profilePicture;
}
