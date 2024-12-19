package ync.zoomgobackend.domain.estimate.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AskEstimateDTO {
    private Long gosuId;
    private Long userNo;
    private String date;
    private String address;
    private String question;
}
