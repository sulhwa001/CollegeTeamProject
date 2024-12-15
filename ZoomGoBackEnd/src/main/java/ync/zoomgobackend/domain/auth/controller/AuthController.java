package ync.zoomgobackend.domain.auth.controller;

import ync.zoomgobackend.domain.auth.dto.request.AuthenticationRequest;
import ync.zoomgobackend.domain.auth.dto.response.JsonWebTokenResponse;
import ync.zoomgobackend.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

//    // 백엔드 연결 테스트용 GetMapping
//    @GetMapping("")
//    public String test01() {
//        return "백엔드 연결 성공!!";
//    }

    // 인증 요청 처리용 PostMapping
    @PostMapping("")
    public ResponseEntity<JsonWebTokenResponse> auth(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(authService.auth(request));
    }
}
