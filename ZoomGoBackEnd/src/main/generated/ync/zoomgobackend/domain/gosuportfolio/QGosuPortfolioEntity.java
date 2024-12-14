package ync.zoomgobackend.domain.gosuportfolio;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;
import kr.ac.ync.zoomgobackend.domain.gosuportfolio.GosuPortfolioEntity;
import ync.zoomgobackend.domain.category.entity.QCategoryEntity;
import ync.zoomgobackend.domain.gosu.entity.QGosuEntity;
import ync.zoomgobackend.domain.member.entity.QMemberEntity;


/**
 * QGosuPortfolioEntity is a Querydsl query type for GosuPortfolioEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGosuPortfolioEntity extends EntityPathBase<GosuPortfolioEntity> {

    private static final long serialVersionUID = 1074143297L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGosuPortfolioEntity gosuPortfolioEntity = new QGosuPortfolioEntity("gosuPortfolioEntity");

    public final StringPath area = createString("area");

    public final QCategoryEntity categoryId;

    public final QGosuEntity gosuId;

    public final NumberPath<Long> gosuPortfolioId = createNumber("gosuPortfolioId", Long.class);

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final StringPath title = createString("title");

    public final QMemberEntity userNo;

    public final StringPath workArticle = createString("workArticle");

    public final NumberPath<Integer> workTime = createNumber("workTime", Integer.class);

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
        this.categoryId = inits.isInitialized("categoryId") ? new QCategoryEntity(forProperty("categoryId")) : null;
        this.gosuId = inits.isInitialized("gosuId") ? new QGosuEntity(forProperty("gosuId"), inits.get("gosuId")) : null;
        this.userNo = inits.isInitialized("userNo") ? new QMemberEntity(forProperty("userNo")) : null;
    }

}

