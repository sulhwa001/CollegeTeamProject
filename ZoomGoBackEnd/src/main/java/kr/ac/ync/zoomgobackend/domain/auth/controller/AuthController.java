package kr.ac.ync.zoomgobackend.domain.auth.controller;


import kr.ac.ync.zoomgobackend.domain.auth.dto.request.AuthenticationRequest;
import kr.ac.ync.zoomgobackend.domain.auth.dto.response.JsonWebTokenResponse;
import kr.ac.ync.zoomgobackend.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("") //auth
    public ResponseEntity<JsonWebTokenResponse> auth(
            @RequestBody AuthenticationRequest request
    )
    {
        return ResponseEntity.ok(authService.auth(request));
    }

}
