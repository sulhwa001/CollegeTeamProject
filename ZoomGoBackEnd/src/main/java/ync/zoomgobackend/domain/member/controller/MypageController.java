package ync.zoomgobackend.domain.member.controller;

import ync.zoomgobackend.domain.member.dto.MemberDTO;
import ync.zoomgobackend.domain.member.dto.MypageDTO;
import ync.zoomgobackend.domain.member.service.MypageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ync.zoomgobackend.global.security.CustomUserDetails;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MypageController {

    private final MypageService mypageService;


    @GetMapping("/getmember")
    public ResponseEntity<MemberDTO> getMemberByEmail(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
        String email = customUserDetails.getUsername();
        MemberDTO memberDTO = mypageService.getMemberByEmail(email);
        return  ResponseEntity.ok(memberDTO);
    }
}
