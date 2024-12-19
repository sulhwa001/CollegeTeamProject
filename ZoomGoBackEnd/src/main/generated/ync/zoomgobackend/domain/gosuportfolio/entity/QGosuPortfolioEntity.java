package ync.zoomgobackend.domain.gosuportfolio.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGosuPortfolioEntity is a Querydsl query type for GosuPortfolioEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGosuPortfolioEntity extends EntityPathBase<GosuPortfolioEntity> {

    private static final long serialVersionUID = -1737222949L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGosuPortfolioEntity gosuPortfolioEntity = new QGosuPortfolioEntity("gosuPortfolioEntity");

    public final StringPath area = createString("area");

    public final ync.zoomgobackend.domain.gosu.entity.QGosuEntity gosu;

    public final NumberPath<Long> gosuPortfolioId = createNumber("gosuPortfolioId", Long.class);

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final StringPath title = createString("title");

    public final ync.zoomgobackend.domain.member.entity.QMemberEntity userNo;

    public final StringPath workArticle = createString("workArticle");

    public final StringPath workTime = createString("workTime");

    public final NumberPath<Integer> workYear = createNumber("workYear", Integer.class);

    public QGosuPortfolioEntity(String variable) {
        this(GosuPortfolioEntity.class, forVariable(variable), INITS);
    }

    public QGosuPortfolioEntity(Path<? extends GosuPortfolioEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGosuPortfolioEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGosuPortfolioEntity(PathMetadata metadata, PathInits inits) {
        this(GosuPortfolioEntity.class, metadata, inits);
    }

    public QGosuPortfolioEntity(Class<? extends GosuPortfolioEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.gosu = inits.isInitialized("gosu") ? new ync.zoomgobackend.domain.gosu.entity.QGosuEntity(forProperty("gosu"), inits.get("gosu")) : null;
        this.userNo = inits.isInitialized("userNo") ? new ync.zoomgobackend.domain.member.entity.QMemberEntity(forProperty("userNo")) : null;
    }

}

