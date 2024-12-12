package kr.ac.ync.zoomgobackend.domain.member.controller;

import kr.ac.ync.zoomgobackend.domain.member.dto.MypageDTO;
import kr.ac.ync.zoomgobackend.domain.member.service.MypageService;
import kr.ac.ync.zoomgobackend.global.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mypage")
@RequiredArgsConstructor
public class MypageController {

    private final MypageService mypageService;


    @GetMapping
    public ResponseEntity<MypageDTO> getMemberByEmail(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
        String email = customUserDetails.getUsername();
        MypageDTO memberDTO = mypageService.getMemberByEmail(email);
        return  ResponseEntity.ok(memberDTO);
    }
}
