package ync.zoomgobackend.domain.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ync.zoomgobackend.domain.board.dto.BoardDTO;
import ync.zoomgobackend.domain.board.service.BoardService;
import ync.zoomgobackend.global.dto.ResponseDTO;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<ResponseDTO<?>> register(
            @RequestPart BoardDTO boardDTO,
            @RequestPart("image") MultipartFile imageFile  // 이미지 파일


    ) {
            // 게시글 등록 후 게시글 ID 반환
            Long postId = boardService.register(boardDTO);


            // 성공 응답
            ResponseDTO<Long> response = ResponseDTO.<Long>builder()
                    .status("success")
                    .message("게시글이 성공적으로 등록되었습니다.")
                    .postid(postId)
                    .build();
            return ResponseEntity.status(HttpStatus.CREATED).body(response);


    }
}
