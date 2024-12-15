package ync.zoomgobackend.domain.auth.service;

import ync.zoomgobackend.domain.auth.dto.request.AuthenticationRequest;
import ync.zoomgobackend.domain.auth.dto.response.JsonWebTokenResponse;


public interface AuthService {
    JsonWebTokenResponse auth(AuthenticationRequest request);
    JsonWebTokenResponse refresh(String token);
}
