package ync.zoomgobackend.domain.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ync.zoomgobackend.domain.board.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    @Query("SELECT b, m, COUNT(r) " +
            "FROM BoardEntity b " +
            "LEFT JOIN b.member m " +
            "LEFT JOIN ReplyEntity r ON r.board = b " +
            "WHERE b.id = :id " +
            "GROUP BY b ")
    Object getBoardById(@Param("id") Long id); // 조회


}
