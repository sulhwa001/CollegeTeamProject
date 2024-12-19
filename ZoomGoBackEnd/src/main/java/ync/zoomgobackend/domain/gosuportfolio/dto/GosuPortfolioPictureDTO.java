package ync.zoomgobackend.domain.gosuportfolio.dto;

import lombok.*;

import java.util.ArrayList;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GosuPortfolioPictureDTO {
    private Long gosuPortfolioId;
    private String mainImage;
    private ArrayList<String> detailImage;
}
