package ync.zoomgobackend.domain.board.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QZCategoryEntity is a Querydsl query type for ZCategoryEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QZCategoryEntity extends EntityPathBase<ZCategoryEntity> {

    private static final long serialVersionUID = 865132333L;

    public static final QZCategoryEntity zCategoryEntity = new QZCategoryEntity("zCategoryEntity");

    public final ListPath<BoardEntity, QBoardEntity> boards = this.<BoardEntity, QBoardEntity>createList("boards", BoardEntity.class, QBoardEntity.class, PathInits.DIRECT2);

    public final NumberPath<Long> categoryId = createNumber("categoryId", Long.class);

    public final StringPath categoryName = createString("categoryName");

    public QZCategoryEntity(String variable) {
        super(ZCategoryEntity.class, forVariable(variable));
    }

    public QZCategoryEntity(Path<? extends ZCategoryEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QZCategoryEntity(PathMetadata metadata) {
        super(ZCategoryEntity.class, metadata);
    }

}

