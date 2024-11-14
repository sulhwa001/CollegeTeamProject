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
    private String review;
    private double recommand;
    private String photoURL;
    private String tag;
    private LocalDateTime createdDate;
}
