package kr.ac.ync.zoomgobackend.domain.gosu.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGosuQuestionEntity is a Querydsl query type for GosuQuestionEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGosuQuestionEntity extends EntityPathBase<GosuQuestionEntity> {

    private static final long serialVersionUID = 1662286666L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGosuQuestionEntity gosuQuestionEntity = new QGosuQuestionEntity("gosuQuestionEntity");

    public final QGosuEntity gosuId;

    public final StringPath question1 = createString("question1");

    public final StringPath question2 = createString("question2");

    public final StringPath question3 = createString("question3");

    public final StringPath question4 = createString("question4");

    public final StringPath question5 = createString("question5");

    public QGosuQuestionEntity(String variable) {
        this(GosuQuestionEntity.class, forVariable(variable), INITS);
    }

    public QGosuQuestionEntity(Path<? extends GosuQuestionEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGosuQuestionEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGosuQuestionEntity(PathMetadata metadata, PathInits inits) {
        this(GosuQuestionEntity.class, metadata, inits);
    }

    public QGosuQuestionEntity(Class<? extends GosuQuestionEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.gosuId = inits.isInitialized("gosuId") ? new QGosuEntity(forProperty("gosuId"), inits.get("gosuId")) : null;
    }

}

