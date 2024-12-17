package ync.zoomgobackend.domain.auth.service;

import ync.zoomgobackend.domain.auth.dto.request.AuthenticationRequest;
import ync.zoomgobackend.domain.auth.dto.response.JsonWebTokenResponse;
import ync.zoomgobackend.domain.member.dto.MemberDTO;
import ync.zoomgobackend.global.jwt.JwtUtil;
import ync.zoomgobackend.global.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    @Override
    public JsonWebTokenResponse auth(AuthenticationRequest request) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken
                        (request.getEmail(),
                                request.getPassword()
                        )
        );
        MemberDTO memberDTO = ((CustomUserDetails) authenticate.getPrincipal()).getMemberDTO();
        //방금 로그인한 멤버의 DTO

        return JsonWebTokenResponse.builder().
                accessToken(
                        jwtUtil.generateRefreshToken(memberDTO.getEmail())
                ).
                refreshToken(jwtUtil.generateRefreshToken(memberDTO.getEmail())).
                build();

    }

    @Override
    public JsonWebTokenResponse refresh(String token) {
        return null;
    }
}
