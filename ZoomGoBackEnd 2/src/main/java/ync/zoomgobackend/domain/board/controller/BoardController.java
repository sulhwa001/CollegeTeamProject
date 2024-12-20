package ync.zoomgobackend.domain.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ync.zoomgobackend.domain.board.dto.BoardDTO;
import ync.zoomgobackend.domain.board.dto.BoardListDTO;
import ync.zoomgobackend.domain.board.service.BoardListService;
import ync.zoomgobackend.domain.board.service.BoardService;
import ync.zoomgobackend.global.dto.ResponseDTO;

import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class BoardController {

    private final BoardListService boardListService;
    private final BoardService boardService;

    @Value("${upload.path}") // 파일 저장 경로
    private String uploadDir;

    @PostMapping //글쓰기
    public ResponseEntity<ResponseDTO<?>> register(
            @RequestPart("boardDTO") String boardDTOJson,
            @RequestPart("image") MultipartFile imageFile
    ) {
        try {
            // JSON 데이터를 DTO로 변환
            ObjectMapper objectMapper = new ObjectMapper();
            BoardDTO boardDTO = objectMapper.readValue(boardDTOJson, BoardDTO.class);

            // 파일 이름과 저장 경로 설정
            String fileName = imageFile.getOriginalFilename();
            String filePath = uploadDir + fileName;

            // 디렉토리 생성 및 파일 저장
            File file = new File(filePath);
            file.getParentFile().mkdirs(); // 디렉토리가 없으면 생성
            imageFile.transferTo(file);

            // 클라이언트가 접근 가능한 URL 설정
            String fileUrl = "http://localhost:8080/files/" + fileName; // HTTP URL로 반환
            boardDTO.setFile(fileUrl);

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

    @GetMapping("/{id}") // 단건 조회
    public ResponseEntity<BoardDTO> getBoardWithImage(@PathVariable("id") Long id,
                                                      @RequestParam(value = "incrementView", defaultValue = "true") boolean incrementView) {
        try {
            // 조건적으로 조회수 증가
            if (incrementView) {
                boardService.incrementView(id); // 조회수 증가
            }

            // 게시글 정보 가져오기
            BoardDTO boardDTO = boardService.get(id);

            return ResponseEntity.ok(boardDTO);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null); // 에러 발생 시 null 반환
        }
    }

    @PutMapping("/{id}") // 글 수정
    public ResponseEntity<ResponseDTO<?>> update(
            @PathVariable("id") Long postId,
            @RequestPart("boardDTO") String boardDTOJson,
            @RequestPart(value = "image", required = false) MultipartFile imageFile
    ) {
        try {
            // JSON 데이터를 DTO로 변환
            ObjectMapper objectMapper = new ObjectMapper();
            BoardDTO boardDTO = objectMapper.readValue(boardDTOJson, BoardDTO.class);

            // 파일 업데이트 로직
            if (imageFile != null && !imageFile.isEmpty()) {
                // 기존 파일 삭제
                BoardDTO existingBoard = boardService.get(postId);
                if (existingBoard.getFile() != null) {
                    String existingFilePath = existingBoard.getFile().replace("http://localhost:8080/files/", uploadDir);
                    File oldFile = new File(existingFilePath);
                    if (oldFile.exists()) {
                        oldFile.delete();
                    }
                }

                // 새 파일 저장
                String fileName = System.currentTimeMillis() + "_" + imageFile.getOriginalFilename(); // 중복 방지
                String filePath = uploadDir + fileName;

                File file = new File(filePath);
                file.getParentFile().mkdirs(); // 디렉토리 생성
                imageFile.transferTo(file);

                // URL 설정
                String fileUrl = "http://localhost:8080/files/" + fileName;
                boardDTO.setFile(fileUrl);
            }

            // 게시글 수정
            boardService.update(postId, boardDTO);

            // 성공 응답
            ResponseDTO<Long> response = ResponseDTO.<Long>builder()
                    .status("success")
                    .message("게시글이 성공적으로 수정되었습니다.")
                    .postid(postId)
                    .build();

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("수정 중 오류가 발생했습니다.", e);
        }
    }

    //최신순
    @GetMapping("/latest")
    public Page<BoardListDTO> getLatestBoards(Pageable pageable) {
        return boardListService.getLatestBoards(pageable);
    }

    // 조회수
    @GetMapping("/most")
    public Page<BoardListDTO> getMostViewedBoards(Pageable pageable) {
        return boardListService.getMostViewedBoards(pageable);
    }
}

