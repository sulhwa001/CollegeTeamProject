package ync.zoomgobackend.domain.estimate.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;
import kr.ac.ync.zoomgobackend.domain.estimate.entity.EstimateEntity;
import ync.zoomgobackend.domain.category.entity.QCategoryEntity;
import ync.zoomgobackend.domain.gosu.entity.QGosuEntity;
import ync.zoomgobackend.domain.member.entity.QMemberEntity;


/**
 * QEstimateEntity is a Querydsl query type for EstimateEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEstimateEntity extends EntityPathBase<EstimateEntity> {

    private static final long serialVersionUID = -601015296L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEstimateEntity estimateEntity = new QEstimateEntity("estimateEntity");

    public final QCategoryEntity categoryId;

    public final StringPath estimateArticle = createString("estimateArticle");

    public final NumberPath<Long> estimateId = createNumber("estimateId", Long.class);

    public final NumberPath<Integer> fee = createNumber("fee", Integer.class);

    public final BooleanPath fee_setting = createBoolean("fee_setting");

    public final StringPath field = createString("field");

    public final QGosuEntity gosuId;

    public final QMemberEntity userNo;

    public QEstimateEntity(String variable) {
        this(EstimateEntity.class, forVariable(variable), INITS);
    }

    public QEstimateEntity(Path<? extends EstimateEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEstimateEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEstimateEntity(PathMetadata metadata, PathInits inits) {
        this(EstimateEntity.class, metadata, inits);
    }

    public QEstimateEntity(Class<? extends EstimateEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.categoryId = inits.isInitialized("categoryId") ? new QCategoryEntity(forProperty("categoryId")) : null;
        this.gosuId = inits.isInitialized("gosuId") ? new QGosuEntity(forProperty("gosuId"), inits.get("gosuId")) : null;
        this.userNo = inits.isInitialized("userNo") ? new QMemberEntity(forProperty("userNo")) : null;
    }

}

