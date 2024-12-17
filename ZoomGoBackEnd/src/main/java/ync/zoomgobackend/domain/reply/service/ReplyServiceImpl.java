package ync.zoomgobackend.domain.reply.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ync.zoomgobackend.domain.board.entity.BoardEntity;
import ync.zoomgobackend.domain.board.repository.BoardRepository;
import ync.zoomgobackend.domain.member.entity.MemberEntity;
import ync.zoomgobackend.domain.reply.entity.ReplyEntity;
import ync.zoomgobackend.domain.reply.repository.ReplyRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

    private final ReplyRepository replyRepository;
    private final BoardRepository boardRepository;

    @Override
    @Transactional
    public ReplyEntity createReply(Long postId, MemberEntity member, String contents) {
        BoardEntity boardEntity = boardRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));

        ReplyEntity reply = ReplyEntity.builder()
                .board(boardEntity)
                .member(member)
                .contents(contents)
                .build();
    return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReplyEntity> getRepliesByPostId(Long postId) {
        return null; //임시로 잠시 null 반환
    }
}
