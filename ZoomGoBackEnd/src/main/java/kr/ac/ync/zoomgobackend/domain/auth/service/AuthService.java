package kr.ac.ync.zoomgobackend.domain.auth.service;

import kr.ac.ync.zoomgobackend.domain.auth.dto.request.AuthenticationRequest;
import kr.ac.ync.zoomgobackend.domain.auth.dto.response.JsonWebTokenResponse;


public interface AuthService {
    JsonWebTokenResponse auth(AuthenticationRequest request);
    JsonWebTokenResponse refresh(String token);
}
