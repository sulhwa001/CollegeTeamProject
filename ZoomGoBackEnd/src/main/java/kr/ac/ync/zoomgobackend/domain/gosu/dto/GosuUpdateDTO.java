package kr.ac.ync.zoomgobackend.domain.gosu.dto;

import kr.ac.ync.zoomgobackend.domain.gosu.entity.GosuQuestionEntity;
import kr.ac.ync.zoomgobackend.domain.member.entity.MemberEntity;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GosuUpdateDTO {
    private MemberEntity user;
    private String name;
    private Long gosuId;
    private String possibleTime;
    private int price;
    private String career;
    private String serviceDetail;
    private String area;
    private String graduation;
    private String profilePicture;
    private GosuQuestionEntity gosuQuestion;
}

