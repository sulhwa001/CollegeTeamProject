package ync.zoomgobackend.domain.comment.service;

import ync.zoomgobackend.domain.community.entity.CommunityEntity;
import ync.zoomgobackend.domain.comment.dto.CommentDTO;
import ync.zoomgobackend.domain.comment.entity.CommentEntity;
import ync.zoomgobackend.domain.member.entity.MemberEntity;

import java.util.List;

public interface CommentService {

    void commentRegister(CommentDTO dto);   //댓글 등록

    List<CommentDTO> get(Long postNo);    //게시글에 맞는 댓글 가져오기

    void removerReplies(Long commentNo);

    default CommentDTO entitiyToDTO(CommentEntity commentEntity, CommunityEntity communityEntity, MemberEntity memberEntity){
        return CommentDTO.builder()
                .postNo(communityEntity.getPostNo())
                .commentId(commentEntity.getCommentId())
                .userNickname(memberEntity.getNickName())
                .memberNo(memberEntity.getUserNo())
                .commentText(commentEntity.getCommentText())
                .commentNo(commentEntity.getCommentNo())
                .commentDept(commentEntity.getCommentDept())
                .createdDate(commentEntity.getCreatedDate())
                .build();
    }

    default CommentEntity dtoToEntity(CommentDTO commentDTO){
        CommunityEntity communityEntity = CommunityEntity.builder().postNo(commentDTO.getPostNo()).build();
        MemberEntity member = MemberEntity.builder().nickName(commentDTO.getUserNickname()).userNo(commentDTO.getMemberNo()).build();
        return CommentEntity.builder()
                .communityEntity(communityEntity)
                .memberEntity(member)
                .commentNo(commentDTO.getCommentNo())
                .commentText(commentDTO.getCommentText())
                .commentDept(commentDTO.getCommentDept())
                .build();
    }
}
