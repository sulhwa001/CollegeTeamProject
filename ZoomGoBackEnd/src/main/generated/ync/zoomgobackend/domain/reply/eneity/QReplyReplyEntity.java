package ync.zoomgobackend.domain.reply.eneity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReplyReplyEntity is a Querydsl query type for ReplyReplyEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReplyReplyEntity extends EntityPathBase<ReplyReplyEntity> {

    private static final long serialVersionUID = 1665669190L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReplyReplyEntity replyReplyEntity = new QReplyReplyEntity("replyReplyEntity");

    public final ync.zoomgobackend.global.common.QBaseEntity _super = new ync.zoomgobackend.global.common.QBaseEntity(this);

    public final StringPath contents = createString("contents");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final ync.zoomgobackend.domain.member.entity.QMemberEntity member;

    public final ync.zoomgobackend.domain.reply.entity.QReplyEntity reply;

    public final NumberPath<Long> replyReplyId = createNumber("replyReplyId", Long.class);

    public QReplyReplyEntity(String variable) {
        this(ReplyReplyEntity.class, forVariable(variable), INITS);
    }

    public QReplyReplyEntity(Path<? extends ReplyReplyEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReplyReplyEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReplyReplyEntity(PathMetadata metadata, PathInits inits) {
        this(ReplyReplyEntity.class, metadata, inits);
    }

    public QReplyReplyEntity(Class<? extends ReplyReplyEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new ync.zoomgobackend.domain.member.entity.QMemberEntity(forProperty("member")) : null;
        this.reply = inits.isInitialized("reply") ? new ync.zoomgobackend.domain.reply.entity.QReplyEntity(forProperty("reply"), inits.get("reply")) : null;
    }

}

