package ync.zoomgobackend.domain.comment.service;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ync.zoomgobackend.domain.board.entity.BoardEntity;
import ync.zoomgobackend.domain.comment.dto.CommentDTO;
import ync.zoomgobackend.domain.comment.entity.CommentEntity;
import ync.zoomgobackend.domain.comment.repository.CommentRepository;
import ync.zoomgobackend.domain.member.entity.MemberEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;

    @Override
    public void commentRegister(CommentDTO dto) {
        CommentEntity commentEntity = dtoToEntity(dto);
        commentRepository.save(commentEntity);
    }

    @Override
    public List<CommentDTO> get(Long postNo) {
        List<Object[]> result = commentRepository.getCommentByPostNo(postNo);
        List<CommentDTO> commentDTOList = new ArrayList<>();
        for(Object[] dto : result){
            commentDTOList.add(entitiyToDTO((CommentEntity) dto[0], (BoardEntity)dto[2], (MemberEntity)dto[1]));
        }
        return commentDTOList;
    }

    @Override
    public void removerReplies(Long commentNo) {
        commentRepository.deleteByCommentId(commentNo);
    }
}
