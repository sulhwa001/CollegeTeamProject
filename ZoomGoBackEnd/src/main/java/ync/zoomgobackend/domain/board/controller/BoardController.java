package ync.zoomgobackend.domain.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public PageResultDTO<BoardDTO,Object[]> list(PageRequestDTO pageRequestDTO){
        System.out.println(pageRequestDTO.getType());
        return boardService.getList(pageRequestDTO);
    }


}
