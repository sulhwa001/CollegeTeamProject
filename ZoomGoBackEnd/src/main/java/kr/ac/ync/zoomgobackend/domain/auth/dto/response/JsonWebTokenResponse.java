package kr.ac.ync.zoomgobackend.domain.auth.dto.response;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class JsonWebTokenResponse {
    private String accessToken;
    private String refreshToken;
}
