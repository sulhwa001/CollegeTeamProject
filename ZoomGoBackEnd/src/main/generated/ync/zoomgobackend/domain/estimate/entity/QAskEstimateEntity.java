package ync.zoomgobackend.domain.estimate.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAskEstimateEntity is a Querydsl query type for AskEstimateEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAskEstimateEntity extends EntityPathBase<AskEstimateEntity> {

    private static final long serialVersionUID = -733728246L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAskEstimateEntity askEstimateEntity = new QAskEstimateEntity("askEstimateEntity");

    public final StringPath address = createString("address");

    public final NumberPath<Long> askEstimateId = createNumber("askEstimateId", Long.class);

    public final DateTimePath<java.util.Date> date = createDateTime("date", java.util.Date.class);

    public final QEstimateEntity estimateId;

    public final ync.zoomgobackend.domain.gosu.entity.QGosuEntity gosuId;

    public final ComparablePath<java.io.File> images = createComparable("images", java.io.File.class);

    public final StringPath question = createString("question");

    public final ync.zoomgobackend.domain.member.entity.QMemberEntity userNo;

    public final ync.zoomgobackend.domain.board.entity.QZCategoryEntity zcategoryEntity;

    public QAskEstimateEntity(String variable) {
        this(AskEstimateEntity.class, forVariable(variable), INITS);
    }

    public QAskEstimateEntity(Path<? extends AskEstimateEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAskEstimateEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAskEstimateEntity(PathMetadata metadata, PathInits inits) {
        this(AskEstimateEntity.class, metadata, inits);
    }

    public QAskEstimateEntity(Class<? extends AskEstimateEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.estimateId = inits.isInitialized("estimateId") ? new QEstimateEntity(forProperty("estimateId"), inits.get("estimateId")) : null;
        this.gosuId = inits.isInitialized("gosuId") ? new ync.zoomgobackend.domain.gosu.entity.QGosuEntity(forProperty("gosuId"), inits.get("gosuId")) : null;
        this.userNo = inits.isInitialized("userNo") ? new ync.zoomgobackend.domain.member.entity.QMemberEntity(forProperty("userNo")) : null;
        this.zcategoryEntity = inits.isInitialized("zcategoryEntity") ? new ync.zoomgobackend.domain.board.entity.QZCategoryEntity(forProperty("zcategoryEntity")) : null;
    }

}

