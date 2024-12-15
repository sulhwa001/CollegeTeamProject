package ync.zoomgobackend.domain.review.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GosuReviewDTO {
    private Long userNo;
    private String nickname;
    private Long gosuId;
    private String name;
    private String title;
    private String workArticle;
    private String review;
    private double recommend;
    private String photoURL;
    private String tag;
    private LocalDateTime createdDate;
}
