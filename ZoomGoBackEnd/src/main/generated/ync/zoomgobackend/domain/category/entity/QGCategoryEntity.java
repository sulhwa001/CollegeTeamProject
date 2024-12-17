package ync.zoomgobackend.domain.category.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QGCategoryEntity is a Querydsl query type for GCategoryEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGCategoryEntity extends EntityPathBase<GCategoryEntity> {

    private static final long serialVersionUID = 1490673592L;

    public static final QGCategoryEntity gCategoryEntity = new QGCategoryEntity("gCategoryEntity");

    public final NumberPath<Long> categoryId = createNumber("categoryId", Long.class);

    public final StringPath categoryName = createString("categoryName");

    public QGCategoryEntity(String variable) {
        super(GCategoryEntity.class, forVariable(variable));
    }

    public QGCategoryEntity(Path<? extends GCategoryEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGCategoryEntity(PathMetadata metadata) {
        super(GCategoryEntity.class, metadata);
    }

}

