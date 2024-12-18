package ync.zoomgobackend.domain.reply.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ync.zoomgobackend.domain.reply.eneity.ReplyReplyEntity;

import java.util.List;

public interface ReplyReplyRepository extends JpaRepository<ReplyReplyEntity, Long> {
    List<ReplyReplyEntity> findByReply_ReplyId(Long replyId);
}
