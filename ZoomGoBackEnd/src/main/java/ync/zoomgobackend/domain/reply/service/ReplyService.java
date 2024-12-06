package ync.zoomgobackend.domain.reply.service;

import ync.zoomgobackend.domain.board.entity.BoardEntity;
import ync.zoomgobackend.domain.member.entity.MemberEntity;
import ync.zoomgobackend.domain.reply.dto.ReplyDTO;
import ync.zoomgobackend.domain.reply.entity.ReplyEntity;

import java.util.List;

public interface ReplyService {
    ReplyEntity createReply(Long postId, MemberEntity member, String contents);
    List<ReplyEntity> getRepliesByPostId(Long postId);

    // DTO → Entity 변환
    default ReplyEntity dtoToEntity(ReplyDTO replyDTO, BoardEntity boardEntity, MemberEntity memberEntity) {
        return ReplyEntity.builder()
                .replyId(replyDTO.getReplyId()) // 새 댓글 작성 시 null 처리 가능
                .contents(replyDTO.getText())
                .board(boardEntity)
                .member(memberEntity)
                .build();
    }

    // Entity → DTO 변환
    default ReplyDTO entityToDTO(ReplyEntity replyEntity) {
        return ReplyDTO.builder()
                .replyId(replyEntity.getReplyId())
                .boardId(replyEntity.getBoard().getPostId())
                .replyer(replyEntity.getMember().getNickName()) // MemberEntity에서 사용자 이름 가져오기
                .text(replyEntity.getContents())
                .createdDate(replyEntity.getCreatedDate())
                .build();
    }
}
