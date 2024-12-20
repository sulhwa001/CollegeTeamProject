package ync.zoomgobackend.domain.gosu.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import ync.zoomgobackend.domain.gosu.dto.GosuChangeDTO;
import ync.zoomgobackend.domain.gosu.dto.GosuDTO;
import ync.zoomgobackend.domain.gosu.dto.GosuUpdateDTO;
import ync.zoomgobackend.domain.gosu.entity.GosuEntity;
import ync.zoomgobackend.domain.gosu.entity.GosuQuestionEntity;
import ync.zoomgobackend.domain.gosu.service.GosuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ync.zoomgobackend.domain.gosuportfolio.dto.GosuPortfolioDTO;
import ync.zoomgobackend.domain.gosuportfolio.service.GosuPortfolioService;
import ync.zoomgobackend.domain.member.dto.MemberDTO;
import ync.zoomgobackend.domain.member.entity.MemberEntity;
import ync.zoomgobackend.domain.member.service.MemberService;
import ync.zoomgobackend.domain.member.service.MemberServiceImpl;
import ync.zoomgobackend.global.security.CustomUserDetails;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gosu")
public class GosuController {
    private final GosuService gosuService;
    private final MemberService memberService;
    private final MemberServiceImpl memberService1;
    @GetMapping("/gosuProfile")
    @ResponseStatus(HttpStatus.OK)
    public GosuDTO selectProfile(@AuthenticationPrincipal CustomUserDetails customUserDetails) {

        MemberDTO memberDTO = memberService.getMemberByUserNo(customUserDetails.getUsername());

        MemberEntity memberEntity = memberService1.dtoToEntity(memberDTO);

        return gosuService.getProfileByUserNo(memberEntity.getUserNo());

    }
    @GetMapping("/selectGosuId")
    @ResponseStatus(HttpStatus.OK)
    public GosuDTO selectGosuId(@AuthenticationPrincipal CustomUserDetails customUserDetails){
        MemberDTO memberDTO = memberService.getMemberByUserNo(customUserDetails.getUsername());
        MemberEntity memberEntity = memberService1.dtoToEntity(memberDTO);
        GosuDTO gosuDTO = gosuService.getProfileByUserNo(memberEntity.getUserNo());
        return gosuDTO;
    }


    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Long> insertGosu(@RequestBody GosuDTO gosuDTO) {
        Long gosuId = gosuService.insertGosu(gosuDTO);
        return ResponseEntity.ok(gosuId);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Long> updateGosu(@RequestBody GosuUpdateDTO gosuUpdateDTO) {
        Long gosuId = gosuService.updateGosu(gosuUpdateDTO);
        return ResponseEntity.status(HttpStatus.OK).body(gosuId);
    }

    @GetMapping("/gosuQuestion/{userNo}")
    public ResponseEntity<GosuQuestionEntity> selectGosuQuestion(@PathVariable("userNo") Long userNo) {
        return gosuService.getQuestionByUserNo(userNo).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/updateName/{gosuId}")
    public ResponseEntity<Long> udpateName(@PathVariable("gosuId") Long gosuId, @RequestBody GosuChangeDTO gosuChangeDTO) {
        Long gosuId1 = gosuService.updateUserName(gosuId, gosuChangeDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(gosuId1);
    }

}
