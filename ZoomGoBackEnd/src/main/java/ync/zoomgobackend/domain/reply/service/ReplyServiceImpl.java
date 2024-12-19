package ync.zoomgobackend.domain.reply.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ync.zoomgobackend.domain.board.entity.BoardEntity;
import ync.zoomgobackend.domain.board.repository.BoardRepository;
import ync.zoomgobackend.domain.member.entity.MemberEntity;
import ync.zoomgobackend.domain.reply.dto.ReplyDTO;
import ync.zoomgobackend.domain.reply.eneity.ReplyEntity;
import ync.zoomgobackend.domain.reply.repository.ReplyRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class ReplyServiceImpl implements ReplyService {

    private final ReplyRepository replyRepository;
    private final BoardRepository boardRepository;

    @Override
    public ReplyEntity createReply(Long postId, MemberEntity member, String contents) {
        // 게시글 확인
        BoardEntity board = boardRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));

        // 댓글 생성
        ReplyEntity replyEntity = ReplyEntity.builder()
                .contents(contents)
                .board(board)
                .member(member)
                .build();

        // 댓글 저장
        return replyRepository.save(replyEntity);
    }
}
