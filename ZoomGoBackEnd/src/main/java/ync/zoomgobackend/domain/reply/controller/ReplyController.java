package ync.zoomgobackend.domain.reply.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ync.zoomgobackend.domain.member.entity.MemberEntity;
import ync.zoomgobackend.domain.member.repository.MemberRepository;
import ync.zoomgobackend.domain.reply.dto.ReplyDTO;
import ync.zoomgobackend.domain.reply.eneity.ReplyEntity;
import ync.zoomgobackend.domain.reply.service.ReplyService;

@RestController
@RequestMapping("/api/replies")
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;
    private final MemberRepository memberRepository;

    @PostMapping
    public ResponseEntity<ReplyDTO> createReply(@RequestBody ReplyDTO replyDTO) {
        // 로그 추가: 요청 데이터 확인
        System.out.println("Received ReplyDTO: " + replyDTO);

        // 데이터 유효성 검증
        if (replyDTO.getMemberId() == null || replyDTO.getBoardId() == null) {
            throw new IllegalArgumentException("작성자 ID와 게시글 ID는 필수입니다.");
        }

        // 작성자 확인
        MemberEntity member = memberRepository.findById(replyDTO.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("해당 작성자가 존재하지 않습니다."));

        // 댓글 생성
        ReplyEntity createdReply = replyService.createReply(replyDTO.getBoardId(), member, replyDTO.getContents());

        // 생성된 댓글을 DTO로 변환하여 반환
        ReplyDTO response = replyService.entityToDTO(createdReply);

        return ResponseEntity.ok(response);
    }

}
