package ync.zoomgobackend.domain.member.controller;

import ync.zoomgobackend.domain.member.dto.MemberDTO;
import ync.zoomgobackend.domain.member.entity.MemberEntity;
import ync.zoomgobackend.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody MemberDTO memberDTO) {
        memberService.register(memberDTO);
        return ResponseEntity.ok("회원가입 성공");
    }

    @GetMapping("/profile/{userNo}")
    public ResponseEntity<MemberEntity> getMemberByUserNo(@PathVariable("userNo") Long userNo) {
        return memberService.getMemberByUserNo(userNo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
