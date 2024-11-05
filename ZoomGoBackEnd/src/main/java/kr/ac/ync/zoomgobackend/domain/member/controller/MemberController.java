package kr.ac.ync.zoomgobackend.domain.member.controller;

import kr.ac.ync.zoomgobackend.domain.member.dto.MemberDTO;
import kr.ac.ync.zoomgobackend.domain.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody MemberDTO memberDTO) {
        memberService.register(memberDTO);
        return ResponseEntity.ok("회원가입 성공");


    }
}
