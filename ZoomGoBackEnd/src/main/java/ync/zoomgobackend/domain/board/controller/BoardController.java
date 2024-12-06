package ync.zoomgobackend.domain.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ync.zoomgobackend.domain.board.dto.BoardDTO;
import ync.zoomgobackend.domain.board.service.BoardService;
import ync.zoomgobackend.global.dto.ResponseDTO;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;


    @PostMapping
    public ResponseEntity<ResponseDTO<?>> register(
            @RequestPart("boardDTO") String boardDTOJson,
            @RequestPart("image") MultipartFile imageFile
    ) {
        try {
            // JSON 데이터를 DTO로 변환
            ObjectMapper objectMapper = new ObjectMapper();
            BoardDTO boardDTO = objectMapper.readValue(boardDTOJson, BoardDTO.class);

            // DTO가 제대로 생성되었는지 확인
            System.out.println(boardDTO);

            // 게시글 등록 후 게시글 ID 반환
            Long postId = boardService.register(boardDTO);

            // 성공 응답
            ResponseDTO<Long> response = ResponseDTO.<Long>builder()
                    .status("success")
                    .message("게시글이 성공적으로 등록되었습니다.")
                    .postid(postId)
                    .build();

            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("등록 중 오류가 발생했습니다.", e);
        }
    }


    @DeleteMapping("/{id}") //삭제
    public ResponseEntity<String> delete(@PathVariable("id") Long id) { //@pathvariable 쓸때 id를 명시 해줘야함
        boardService.delete(id); // 게시글 삭제 처리
        return ResponseEntity.noContent().build(); // 성공 시 204 No Content 반환
    }

//    @GetMapping("/{id}") //조회
//    public ResponseEntity findBoardById(@PathVariable("id") Long id){
//        BoardDTO boardDTO = boardService.get(id);
//        return ResponseEntity.ok(boardDTO);
//        //상태코드 + 결과데이터
//
//    }
}