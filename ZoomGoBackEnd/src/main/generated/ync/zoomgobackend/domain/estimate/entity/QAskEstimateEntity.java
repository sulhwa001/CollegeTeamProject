package ync.zoomgobackend.domain.estimate.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;
import kr.ac.ync.zoomgobackend.domain.estimate.entity.AskEstimateEntity;
import ync.zoomgobackend.domain.category.entity.QCategoryEntity;
import ync.zoomgobackend.domain.gosu.entity.QGosuEntity;
import ync.zoomgobackend.domain.member.entity.QMemberEntity;


/**
 * QAskEstimateEntity is a Querydsl query type for AskEstimateEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAskEstimateEntity extends EntityPathBase<AskEstimateEntity> {

    private static final long serialVersionUID = -1163524849L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAskEstimateEntity askEstimateEntity = new QAskEstimateEntity("askEstimateEntity");

    public final StringPath address = createString("address");

    public final NumberPath<Long> askEstimateId = createNumber("askEstimateId", Long.class);

    public final QCategoryEntity categoryEntity;

    public final DateTimePath<java.util.Date> date = createDateTime("date", java.util.Date.class);

    public final QEstimateEntity estimateId;

    public final QGosuEntity gosuId;

    public final ComparablePath<java.io.File> images = createComparable("images", java.io.File.class);

    public final StringPath question = createString("question");

    public final QMemberEntity userNo;

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
        this.categoryEntity = inits.isInitialized("categoryEntity") ? new QCategoryEntity(forProperty("categoryEntity")) : null;
        this.estimateId = inits.isInitialized("estimateId") ? new QEstimateEntity(forProperty("estimateId"), inits.get("estimateId")) : null;
        this.gosuId = inits.isInitialized("gosuId") ? new QGosuEntity(forProperty("gosuId"), inits.get("gosuId")) : null;
        this.userNo = inits.isInitialized("userNo") ? new QMemberEntity(forProperty("userNo")) : null;
    }

}

