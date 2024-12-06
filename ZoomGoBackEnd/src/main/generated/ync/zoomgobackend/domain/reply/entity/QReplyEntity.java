package ync.zoomgobackend.domain.reply.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReplyEntity is a Querydsl query type for ReplyEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReplyEntity extends EntityPathBase<ReplyEntity> {

    private static final long serialVersionUID = 1755771771L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReplyEntity replyEntity = new QReplyEntity("replyEntity");

    public final ync.zoomgobackend.global.common.QBaseEntity _super = new ync.zoomgobackend.global.common.QBaseEntity(this);

    public final ync.zoomgobackend.domain.board.entity.QBoardEntity board;

    public final StringPath contents = createString("contents");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final ync.zoomgobackend.domain.member.entity.QMemberEntity member;

    public final NumberPath<Long> replyId = createNumber("replyId", Long.class);

    public QReplyEntity(String variable) {
        this(ReplyEntity.class, forVariable(variable), INITS);
    }

    public QReplyEntity(Path<? extends ReplyEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReplyEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReplyEntity(PathMetadata metadata, PathInits inits) {
        this(ReplyEntity.class, metadata, inits);
    }

    public QReplyEntity(Class<? extends ReplyEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.board = inits.isInitialized("board") ? new ync.zoomgobackend.domain.board.entity.QBoardEntity(forProperty("board"), inits.get("board")) : null;
        this.member = inits.isInitialized("member") ? new ync.zoomgobackend.domain.member.entity.QMemberEntity(forProperty("member")) : null;
    }

}

