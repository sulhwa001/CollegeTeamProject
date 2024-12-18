package ync.zoomgobackend.domain.board.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ync.zoomgobackend.domain.board.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    // 최신순 정렬 Native Query
    @Query("SELECT b FROM BoardEntity b ORDER BY b.createdDate DESC")
    Page<BoardEntity> findBoardsByLatest(Pageable pageable);

    // 조회수 많은 순 정렬 JPQL
    @Query("SELECT b FROM BoardEntity b ORDER BY b.view DESC")
    Page<BoardEntity> findBoardsByMostViewed(Pageable pageable);
}
