package ync.zoomgobackend.domain.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ync.zoomgobackend.domain.comment.dto.CommentDTO;
import ync.zoomgobackend.domain.comment.entity.CommentEntity;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity,Long> {

    @Modifying
    @Query("DELETE FROM CommentEntity r WHERE r.communityEntity.postNo = :postNo")
    void deleteByBoardId(@Param("postNo")Long postNo);

    @Modifying
    @Query("DELETE FROM CommentEntity r WHERE r.commentId =:commentId")
    void deleteByCommentId(@Param("commentId")Long commentId);

    @Query("SELECT r, m, b " +
            "FROM CommentEntity r " +
            "LEFT JOIN r.memberEntity m " +
            "LEFT JOIN CommunityEntity b ON b = r.communityEntity " +
            "WHERE r.communityEntity.postNo =:postNo " +
            "ORDER BY r.commentNo ASC, r.commentDept ASC ")
    List<Object[]> getCommentByPostNo(@Param("postNo")Long postNo);
}
