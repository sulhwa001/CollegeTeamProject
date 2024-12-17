package ync.zoomgobackend.domain.gosuportfolio;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGosuPortfolioImageEntity is a Querydsl query type for GosuPortfolioImageEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGosuPortfolioImageEntity extends EntityPathBase<GosuPortfolioImageEntity> {

    private static final long serialVersionUID = -85700763L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGosuPortfolioImageEntity gosuPortfolioImageEntity = new QGosuPortfolioImageEntity("gosuPortfolioImageEntity");

    public final ync.zoomgobackend.domain.board.entity.QCategoryEntity categoryId;

    public final ComparablePath<java.io.File> detail_image1 = createComparable("detail_image1", java.io.File.class);

    public final ComparablePath<java.io.File> detail_image2 = createComparable("detail_image2", java.io.File.class);

    public final ComparablePath<java.io.File> detail_image3 = createComparable("detail_image3", java.io.File.class);

    public final ComparablePath<java.io.File> detail_image4 = createComparable("detail_image4", java.io.File.class);

    public final ync.zoomgobackend.domain.gosu.entity.QGosuEntity gosuId;

    public final QGosuPortfolioEntity gosuPortfolio;

    public final ComparablePath<java.io.File> image = createComparable("image", java.io.File.class);

    public final ync.zoomgobackend.domain.member.entity.QMemberEntity userNo;

    public QGosuPortfolioImageEntity(String variable) {
        this(GosuPortfolioImageEntity.class, forVariable(variable), INITS);
    }

    public QGosuPortfolioImageEntity(Path<? extends GosuPortfolioImageEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGosuPortfolioImageEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGosuPortfolioImageEntity(PathMetadata metadata, PathInits inits) {
        this(GosuPortfolioImageEntity.class, metadata, inits);
    }

    public QGosuPortfolioImageEntity(Class<? extends GosuPortfolioImageEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.categoryId = inits.isInitialized("categoryId") ? new ync.zoomgobackend.domain.board.entity.QCategoryEntity(forProperty("categoryId")) : null;
        this.gosuId = inits.isInitialized("gosuId") ? new ync.zoomgobackend.domain.gosu.entity.QGosuEntity(forProperty("gosuId"), inits.get("gosuId")) : null;
        this.gosuPortfolio = inits.isInitialized("gosuPortfolio") ? new QGosuPortfolioEntity(forProperty("gosuPortfolio"), inits.get("gosuPortfolio")) : null;
        this.userNo = inits.isInitialized("userNo") ? new ync.zoomgobackend.domain.member.entity.QMemberEntity(forProperty("userNo")) : null;
    }

}

