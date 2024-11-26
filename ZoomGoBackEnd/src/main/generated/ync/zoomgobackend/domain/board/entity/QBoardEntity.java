package ync.zoomgobackend.domain.board.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBoardEntity is a Querydsl query type for BoardEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoardEntity extends EntityPathBase<BoardEntity> {

    private static final long serialVersionUID = -1662243589L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBoardEntity boardEntity = new QBoardEntity("boardEntity");

    public final StringPath address = createString("address");

    public final QCategoryEntity category;

    public final StringPath contents = createString("contents");

    public final NumberPath<Integer> cost = createNumber("cost", Integer.class);

    public final ArrayPath<byte[], Byte> file = createArray("file", byte[].class);

    public final ync.zoomgobackend.domain.member.entity.QMemberEntity member;

    public final NumberPath<Long> postId = createNumber("postId", Long.class);

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final StringPath title = createString("title");

    public final StringPath transStatus = createString("transStatus");

    public final StringPath transType = createString("transType");

    public final NumberPath<Integer> view = createNumber("view", Integer.class);

    public QBoardEntity(String variable) {
        this(BoardEntity.class, forVariable(variable), INITS);
    }

    public QBoardEntity(Path<? extends BoardEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBoardEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBoardEntity(PathMetadata metadata, PathInits inits) {
        this(BoardEntity.class, metadata, inits);
    }

    public QBoardEntity(Class<? extends BoardEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new QCategoryEntity(forProperty("category")) : null;
        this.member = inits.isInitialized("member") ? new ync.zoomgobackend.domain.member.entity.QMemberEntity(forProperty("member")) : null;
    }

}

