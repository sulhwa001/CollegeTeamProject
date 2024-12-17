package ync.zoomgobackend.domain.community.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ync.zoomgobackend.domain.community.entity.CommunityEntity;

public interface CommunityRepository extends JpaRepository<CommunityEntity, Long> {

    @Query(value = "SELECT b, m, COUNT(r) " +
            "FROM CommunityEntity b " +
            "LEFT JOIN b.member m " +
            "LEFT JOIN CommentEntity r ON r.communityEntity = b " +
            "WHERE b.communityType =:communityType " +
            "GROUP BY b " +
            "ORDER BY b.postNo DESC",
            countQuery = "SELECT COUNT(b) FROM CommunityEntity b")
    Page<Object[]> getBoardWithReplyCount(@Param("communityType")String communityType, Pageable pageable);

    @Query("SELECT b, m, COUNT(r) " +
            "FROM CommunityEntity b " +
            "LEFT JOIN b.member m " +
            "LEFT JOIN CommentEntity r ON r.communityEntity = b " +
            "WHERE b.postNo =:postNo " +
            "GROUP BY b")
    Object getBoardByPostNo(@Param("postNo") Long postNo);

    @Query("SELECT b, m, COUNT(r) " +
            "FROM CommunityEntity b " +
            "LEFT JOIN b.member m " +
            "LEFT JOIN CommentEntity r ON r.communityEntity = b " +
            "WHERE b.communityType =:communityType AND (b.title LIKE CONCAT('%', :keyword, '%') OR b.post LIKE CONCAT('%', :keyword, '%'))" +
            "GROUP BY b " +
            "ORDER BY b.postNo DESC")
    Page<Object[]> getBoardContaining(@Param("keyword")String keyword, @Param("communityType")String communityType, Pageable pageable);

    @Modifying
    @Transactional
    @Query("UPDATE CommunityEntity b " +
            "SET b.views = b.views + 1 " +
            "WHERE b.postNo =:postNo")
    void updateViews(@Param("postNo") Long postNo);
}
