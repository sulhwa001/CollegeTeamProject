package ync.zoomgobackend.domain.gosuportfolio.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ync.zoomgobackend.domain.gosu.dto.GosuDTO;
import ync.zoomgobackend.domain.gosu.service.GosuService;
import ync.zoomgobackend.domain.gosuportfolio.dto.GosuPortfolioDTO;
import ync.zoomgobackend.domain.gosuportfolio.service.GosuPortfolioService;
import ync.zoomgobackend.domain.member.dto.MemberDTO;
import ync.zoomgobackend.domain.member.entity.MemberEntity;
import ync.zoomgobackend.domain.member.service.MemberService;
import ync.zoomgobackend.domain.member.service.MemberServiceImpl;
import ync.zoomgobackend.global.security.CustomUserDetails;

@RestController
@RequestMapping("/portfolio")
@RequiredArgsConstructor
public class GosuPortfolioController {
    private final GosuPortfolioService gosuPortfolioService;
    private final MemberService memberService;
    private final GosuService gosuService;
    private final MemberServiceImpl memberService1;
    @PostMapping("")
    public ResponseEntity<Long> portfolioInput(@RequestBody GosuPortfolioDTO gosuPortfolioDTO) {

        return ResponseEntity.ok(gosuPortfolioService.insertPortfolio(gosuPortfolioDTO));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/getPortfolio")
    public GosuPortfolioDTO getPortfolio(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
        MemberDTO memberDTO = memberService.getMemberByUserNo(customUserDetails.getUsername());
        MemberEntity memberEntity = memberService1.dtoToEntity(memberDTO);
        GosuDTO gosuDTO = gosuService.getProfileByUserNo(memberEntity.getUserNo());
        return gosuPortfolioService.getPortfolioIdByGosuId(gosuDTO.getGosuId());
    }
}
