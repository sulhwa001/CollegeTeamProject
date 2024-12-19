package ync.zoomgobackend.domain.board.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ync.zoomgobackend.domain.board.dto.BoardListDTO;

import java.util.List;

public interface BoardListService {
    Page<BoardListDTO> getLatestBoards(Pageable pageable); // 최신순
    Page<BoardListDTO> getMostViewedBoards(Pageable pageable); // 조회수 순
}