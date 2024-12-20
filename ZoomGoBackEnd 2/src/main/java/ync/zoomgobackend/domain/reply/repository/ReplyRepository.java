package ync.zoomgobackend.domain.reply.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ync.zoomgobackend.domain.reply.eneity.ReplyEntity;

import java.util.List;

public interface ReplyRepository extends JpaRepository<ReplyEntity, Long> {
    List<ReplyEntity> findByBoard_PostId(Long postId);
}
