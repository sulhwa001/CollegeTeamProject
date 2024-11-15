package ync.zoomgobackend.domain.board.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ync.zoomgobackend.domain.board.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

    @Query(value = "SELECT b, m, COUNT(r) " +
            "FROM BoardEntity b " +
            "LEFT JOIN b.member m " +
            "LEFT JOIN CommentEntity r ON r.boardEntity = b " +
            "WHERE b.communityType =:communityType " +
            "GROUP BY b",
            countQuery = "SELECT COUNT(b) FROM BoardEntity b")
    Page<Object[]> getBoardWithReplyCount(@Param("communityType")String communityType, Pageable pageable);

    @Query("SELECT b, m, COUNT(r) " +
            "FROM BoardEntity b " +
            "LEFT JOIN b.member m " +
            "LEFT JOIN CommentEntity r ON r.boardEntity = b " +
            "WHERE b.postNo =:postNo " +
            "GROUP BY b")
    Object getBoardByPostNo(@Param("postNo") Long postNo);
}
