package ync.zoomgobackend.domain.gosuportfolio.dto;

import lombok.*;
import ync.zoomgobackend.domain.category.entity.CategoryEntity;
import ync.zoomgobackend.domain.gosu.entity.GosuEntity;
import ync.zoomgobackend.domain.gosuportfolio.entity.GosuPortfolioImageEntity;
import ync.zoomgobackend.domain.member.entity.MemberEntity;

import java.util.ArrayList;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GosuPortfolioDTO {
    private Long gosuId;
//    private Long categoryId
    private Long userNo;
    private String title;
    private String area;
    private Integer price;
    private Integer year;
    private String workTime;
    private String workArticle;


}
