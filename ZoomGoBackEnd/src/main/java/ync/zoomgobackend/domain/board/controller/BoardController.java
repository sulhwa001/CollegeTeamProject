package ync.zoomgobackend.domain.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ync.zoomgobackend.domain.board.dto.BoardDTO;
import ync.zoomgobackend.domain.board.service.BoardService;
import ync.zoomgobackend.global.common.dto.PageRequestDTO;
import ync.zoomgobackend.global.common.dto.PageResultDTO;

@RestController
@RequestMapping("/zoomgo/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/regist")    //게시글 작성
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody BoardDTO boardDTO){
        boardService.register(boardDTO);
    }

    @GetMapping("/list")       //게시글 전체 목록 가져오기
    public PageResultDTO<BoardDTO,Object[]> list(@RequestParam("communityType")String communityType ,PageRequestDTO pageRequestDTO){
        System.out.println(communityType);
        System.out.println(pageRequestDTO.getType());
        return boardService.getList(communityType,pageRequestDTO);
    }

    @GetMapping("/list/keyword")
    public PageResultDTO<BoardDTO, Object[]> keywordList(@RequestParam("keyword")String keyword, @RequestParam("communityType")String communityType ,PageRequestDTO pageRequestDTO){
        System.out.println(communityType);
        System.out.println(pageRequestDTO.getType());
        return boardService.getListWithKeyword(keyword,communityType,pageRequestDTO);
    }

    @GetMapping("/detail")  //게시글 상세
    public ResponseEntity findBoardById(@RequestParam("postNo")Long postNo){
        boardService.updateViews(postNo);
        BoardDTO boardDTO = boardService.get(postNo);
        return ResponseEntity.ok(boardDTO);
    }

    @DeleteMapping("/detail")   //게시글 삭제
    public void remove(@RequestParam("postNo")Long postNo){
        boardService.removeWithReplies(postNo);
    }

    @PutMapping("/detail")      //게시글 수정
    public void modify(@RequestBody BoardDTO boardDTO){
        boardService.modify(boardDTO);
    }

}
