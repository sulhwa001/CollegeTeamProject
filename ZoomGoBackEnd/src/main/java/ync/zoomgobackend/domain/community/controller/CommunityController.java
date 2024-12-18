package ync.zoomgobackend.domain.community.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ync.zoomgobackend.domain.community.dto.CommunityDTO;
import ync.zoomgobackend.domain.community.service.CommunityService;
import ync.zoomgobackend.global.common.dto.PageRequestDTO;
import ync.zoomgobackend.global.common.dto.PageResultDTO;

@RestController
@RequestMapping("/zoomgo/board")
@RequiredArgsConstructor
public class CommunityController {

    private final CommunityService communityService;

    @PostMapping("/regist")    //게시글 작성
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody CommunityDTO communityDTO){
        communityService.register(communityDTO);
    }

    @GetMapping("/list")       //게시글 전체 목록 가져오기
    public PageResultDTO<CommunityDTO,Object[]> list(@RequestParam("communityType")String communityType , PageRequestDTO pageRequestDTO){
        System.out.println(communityType);
        System.out.println(pageRequestDTO.getType());
        return communityService.getList(communityType,pageRequestDTO);
    }

    @GetMapping("/list/keyword")
    public PageResultDTO<CommunityDTO, Object[]> keywordList(@RequestParam("keyword")String keyword, @RequestParam("communityType")String communityType , PageRequestDTO pageRequestDTO){
        System.out.println(communityType);
        System.out.println(pageRequestDTO.getType());
        return communityService.getListWithKeyword(keyword,communityType,pageRequestDTO);
    }

    @GetMapping("/detail")  //게시글 상세
    public ResponseEntity findBoardById(@RequestParam("postNo")Long postNo){
        communityService.updateViews(postNo);
        CommunityDTO communityDTO = communityService.get(postNo);
        return ResponseEntity.ok(communityDTO);
    }

    @DeleteMapping("/detail")   //게시글 삭제
    public void remove(@RequestParam("postNo")Long postNo){
        communityService.removeWithReplies(postNo);
    }

    @PutMapping("/detail")      //게시글 수정
    public void modify(@RequestBody CommunityDTO communityDTO){
        communityService.modify(communityDTO);
    }

}
