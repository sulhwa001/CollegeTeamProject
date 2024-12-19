package ync.zoomgobackend.domain.comment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ync.zoomgobackend.domain.comment.dto.CommentDTO;
import ync.zoomgobackend.domain.comment.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/zoomgo/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping    //댓글 작성
    public void commentRegister(@RequestBody CommentDTO commentDTO){
        commentService.commentRegister(commentDTO);
    }

    @GetMapping("/commentList") //댓글 목록 출력
    public ResponseEntity findCommentByPostNo(@RequestParam("postNo")Long postNo){
        List<CommentDTO> commentDTO = commentService.get(postNo);
        return ResponseEntity.ok(commentDTO);
    }

    @DeleteMapping  //댓글 삭제
    public void deleteCommentByCommentId(@RequestParam("commentId")Long commentId){
        commentService.removerReplies(commentId);
    }

}
