package ync.zoomgobackend.domain.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ync.zoomgobackend.domain.board.dto.BoardDTO;
import ync.zoomgobackend.domain.board.entity.BoardEntity;
import ync.zoomgobackend.domain.board.repository.BoardRepository;
import ync.zoomgobackend.domain.member.entity.MemberEntity;
import ync.zoomgobackend.global.common.dto.PageRequestDTO;
import ync.zoomgobackend.global.common.dto.PageResultDTO;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    @Override
    public void findById(Long postNo) {

    }

    @Override
    public void register(BoardDTO dto) {
        BoardEntity boardEntity = dtoToEntity(dto);
        boardRepository.save(boardEntity);
    }

    @Override
    public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO) {
        Page<Object[]> result = boardRepository.getBoardWithReplyCount(pageRequestDTO.getPageable(Sort.by("postNo").descending()));
        return new PageResultDTO<>(result,(en -> entityToDTO((BoardEntity) en[0], (MemberEntity) en[1], (Long)en[2])));
    }


}
