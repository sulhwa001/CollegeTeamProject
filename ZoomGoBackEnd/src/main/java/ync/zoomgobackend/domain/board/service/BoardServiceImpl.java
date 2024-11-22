package ync.zoomgobackend.domain.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ync.zoomgobackend.domain.board.dto.BoardDTO;
import ync.zoomgobackend.domain.board.entity.BoardEntity;
import ync.zoomgobackend.domain.board.repository.BoardRepository;
import ync.zoomgobackend.domain.comment.repository.CommentRepository;
import ync.zoomgobackend.domain.member.entity.MemberEntity;
import ync.zoomgobackend.global.common.dto.PageRequestDTO;
import ync.zoomgobackend.global.common.dto.PageResultDTO;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    @Override
    public void register(BoardDTO dto) {    //게시글 등록
        BoardEntity boardEntity = dtoToEntity(dto);
        boardRepository.save(boardEntity);
    }

    @Override
    public void modify(BoardDTO dto) {
        BoardEntity boardEntity = dtoToEntity(dto);
        boardRepository.save(boardEntity);
    }

    @Override
    public BoardDTO get(Long postNo) {  //postNo에 맞는 게시글 가져오기
        Object result = boardRepository.getBoardByPostNo(postNo);
        Object[] arr = (Object[]) result;
        return entityToDTO((BoardEntity) arr[0], (MemberEntity) arr[1], (Long)arr[2]);
    }

    @Override
    public void removeWithReplies(Long postNo) {    //postNo와 맞는 게시글과 댓글 삭제하기
        commentRepository.deleteByBoardId(postNo);
        boardRepository.deleteById(postNo);
    }

    @Override
    public PageResultDTO<BoardDTO, Object[]> getList(String communityType, PageRequestDTO pageRequestDTO) { //게시판 타입에 맞는 게시글 리스트 가져오기
        Page<Object[]> result = boardRepository.getBoardWithReplyCount(communityType,pageRequestDTO.getPageable(Sort.by("postNo").descending()));
        return new PageResultDTO<>(result,(en -> entityToDTO((BoardEntity) en[0], (MemberEntity) en[1], (Long)en[2])));
    }


}
