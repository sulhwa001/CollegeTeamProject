package ync.zoomgobackend.domain.gosu.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;
import kr.ac.ync.zoomgobackend.domain.gosu.entity.GosuEntity;
import ync.zoomgobackend.domain.gosuportfolio.QGosuPortfolioEntity;
import ync.zoomgobackend.domain.member.entity.QMemberEntity;


/**
 * QGosuEntity is a Querydsl query type for GosuEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGosuEntity extends EntityPathBase<GosuEntity> {

    private static final long serialVersionUID = -1154823996L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGosuEntity gosuEntity = new QGosuEntity("gosuEntity");

    public final StringPath area = createString("area");

    public final StringPath career = createString("career");

    public final NumberPath<Long> gosuId = createNumber("gosuId", Long.class);

    public final StringPath graduation = createString("graduation");

    public final StringPath name = createString("name");

    public final ListPath<kr.ac.ync.zoomgobackend.domain.gosuportfolio.GosuPortfolioEntity, QGosuPortfolioEntity> portfolios = this.<kr.ac.ync.zoomgobackend.domain.gosuportfolio.GosuPortfolioEntity, QGosuPortfolioEntity>createList("portfolios", kr.ac.ync.zoomgobackend.domain.gosuportfolio.GosuPortfolioEntity.class, QGosuPortfolioEntity.class, PathInits.DIRECT2);

    public final StringPath possibleTime = createString("possibleTime");

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final StringPath profilePicture = createString("profilePicture");

    public final StringPath serviceDetail = createString("serviceDetail");

    public final QMemberEntity user;

    public QGosuEntity(String variable) {
        this(GosuEntity.class, forVariable(variable), INITS);
    }

    public QGosuEntity(Path<? extends GosuEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGosuEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGosuEntity(PathMetadata metadata, PathInits inits) {
        this(GosuEntity.class, metadata, inits);
    }

    public QGosuEntity(Class<? extends GosuEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QMemberEntity(forProperty("user")) : null;
    }

}

