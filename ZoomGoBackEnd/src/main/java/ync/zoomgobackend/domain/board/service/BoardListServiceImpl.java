package ync.zoomgobackend.domain.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ync.zoomgobackend.domain.board.dto.BoardListDTO;
import ync.zoomgobackend.domain.board.entity.BoardEntity;
import ync.zoomgobackend.domain.board.repository.BoardRepository;
import ync.zoomgobackend.domain.board.service.BoardListService;

@Service
@RequiredArgsConstructor
public class BoardListServiceImpl implements BoardListService {

    private final BoardRepository boardRepository;

    @Override
    public Page<BoardListDTO> getLatestBoards(Pageable pageable) {
        return boardRepository.findBoardsByLatest(pageable)
                .map(this::convertToDTO);
    }

    @Override
    public Page<BoardListDTO> getMostViewedBoards(Pageable pageable) {
        return boardRepository.findBoardsByMostViewed(pageable)
                .map(this::convertToDTO);
    }

    private BoardListDTO convertToDTO(BoardEntity entity) {
        return BoardListDTO.builder()
                .id(entity.getPostId())
                .title(entity.getTitle())
                .price(entity.getPrice())
                .file(entity.getFile())
                .view(entity.getView())
                .createdAt(entity.getCreatedDate())
                .build();
    }
}
