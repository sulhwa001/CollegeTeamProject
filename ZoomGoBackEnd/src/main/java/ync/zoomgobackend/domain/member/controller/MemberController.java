package ync.zoomgobackend.domain.member.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import ync.zoomgobackend.domain.member.dto.MemberDTO;
import ync.zoomgobackend.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ync.zoomgobackend.global.security.CustomUserDetails;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;


    @PostMapping("")
    public ResponseEntity<String> register(@RequestBody MemberDTO memberDTO) {
        memberService.register(memberDTO);
        return ResponseEntity.ok("회원가입 성공");
    }

    @GetMapping("/profile")
    public MemberDTO getMemberByUserNo(@AuthenticationPrincipal CustomUserDetails customUserDetails) {

        return memberService.getMemberByUserNo(customUserDetails.getUsername());
    }
}
