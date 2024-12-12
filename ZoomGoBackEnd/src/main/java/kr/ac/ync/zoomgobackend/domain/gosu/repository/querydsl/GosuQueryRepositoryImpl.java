package kr.ac.ync.zoomgobackend.domain.gosu.repository.querydsl;

import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.ac.ync.zoomgobackend.domain.gosu.dto.GosuChangeDTO;
import kr.ac.ync.zoomgobackend.domain.gosu.dto.GosuDTO;
import kr.ac.ync.zoomgobackend.domain.gosu.entity.GosuEntity;
import kr.ac.ync.zoomgobackend.domain.member.dto.MemberListDTO;
import kr.ac.ync.zoomgobackend.domain.member.exception.NotFoundMemberException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static kr.ac.ync.zoomgobackend.domain.gosu.entity.QGosuEntity.gosuEntity;
import static kr.ac.ync.zoomgobackend.domain.member.entity.QMemberEntity.memberEntity;
@RequiredArgsConstructor
@Repository
public class GosuQueryRepositoryImpl implements GosuQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;


    public ConstructorExpression<GosuChangeDTO> gosuChangeNameProjection() {
        return Projections.constructor(
                GosuChangeDTO.class,
                gosuEntity.gosuId,
                gosuEntity.name,
                gosuEntity.area,
                gosuEntity.career,
                gosuEntity.graduation,
                gosuEntity.price,
                gosuEntity.possibleTime,
                gosuEntity.serviceDetail,
                gosuEntity.user
        );
    }
    @Override
    public GosuChangeDTO findById(Long id) {
        return Optional.ofNullable(
                jpaQueryFactory.select(gosuChangeNameProjection())
                        .from(gosuEntity)
                        .where(gosuEntity.gosuId.eq(id))
                        .fetchOne()
        )
                .orElseThrow(
                        () -> NotFoundMemberException.EXCEPTION
                );
    }

    public ConstructorExpression<GosuDTO> selectProfileProjection() {
       return Projections.constructor(
               GosuDTO.class,
               gosuEntity.gosuId,
               gosuEntity.name,
               gosuEntity.area,
               gosuEntity.career,
               gosuEntity.graduation,
               gosuEntity.price,
               gosuEntity.possibleTime,
               gosuEntity.serviceDetail,
               gosuEntity.user
       );
    }
    public GosuDTO findGosuProfileByGosuId(Long gosuId) {
        return Optional.ofNullable(
                jpaQueryFactory.select(selectProfileProjection())
                        .from(gosuEntity)
                        .where(gosuEntity.gosuId.eq(gosuId))
                        .fetchOne()
        )
                .orElseThrow(
                        () -> NotFoundMemberException.EXCEPTION
                );
    }

}