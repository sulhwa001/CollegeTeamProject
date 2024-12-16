package ync.zoomgobackend.domain.review.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserReviewDTO {
    private Long userNo;
    private String nickname;
    private Long reviewer;
    private double recommend;
    private LocalDateTime createdDate;
}
