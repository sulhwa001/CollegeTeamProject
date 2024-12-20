package ync.zoomgobackend.domain.gosu.dto;

import ync.zoomgobackend.domain.gosu.entity.GosuQuestionEntity;
import ync.zoomgobackend.domain.member.entity.MemberEntity;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GosuDTO {
    private String name;
    private Long userNo;
    private Long categoryId;
    private String possibleTime;
    private int price;
    private String career;
    private String serviceDetail;
    private String area;
    private String graduation;
    private String profilePicture;
    private GosuQuestionEntity gosuQuestion;
}
