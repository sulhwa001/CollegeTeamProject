package ync.zoomgobackend.domain.comment.service;

import ync.zoomgobackend.domain.board.entity.BoardEntity;
import ync.zoomgobackend.domain.comment.dto.CommentDTO;
import ync.zoomgobackend.domain.comment.entity.CommentEntity;
import ync.zoomgobackend.domain.member.entity.MemberEntity;

public interface CommentService {

    default CommentDTO entitiyToDTO(CommentEntity commentEntity, BoardEntity boardEntity, MemberEntity memberEntity){
        return CommentDTO.builder()
                .postNo(boardEntity.getPostNo())
                .userNickname(memberEntity.getNickName())
                .memberNo(memberEntity.getUserNo())
                .pComment(commentEntity.getPComment())
                .commentNo(commentEntity.getCommentNo())
                .cComment(commentEntity.getCComment())
                .commentDept(commentEntity.getCommentDept())
                .createdDate(commentEntity.getCreatedDate())
                .build();
    }

    default CommentEntity dtoToEntity(CommentDTO commentDTO){
        BoardEntity boardEntity = BoardEntity.builder().postNo(commentDTO.getPostNo()).build();
        MemberEntity member = MemberEntity.builder().nickName(commentDTO.getUserNickname()).userNo(commentDTO.getMemberNo()).build();
        return CommentEntity.builder()
                .boardEntity(boardEntity)
                .memberEntity(member)
                .commentNo(commentDTO.getCommentNo())
                .pComment(commentDTO.getPComment())
                .cComment(commentDTO.getCComment())
                .commentDept(commentDTO.getCommentDept())
                .build();
    }
}
