package ync.zoomgobackend.domain.board.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ync.zoomgobackend.domain.board.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

    @Query(value = "SELECT b, m, COUNT(r) FROM BoardEntity b LEFT JOIN b.member m LEFT JOIN CommentEntity r ON r.boardEntity = b GROUP BY b",
            countQuery = "SELECT COUNT(b) FROM BoardEntity b")
    Page<Object[]> getBoardWithReplyCount(Pageable pageable);
}
