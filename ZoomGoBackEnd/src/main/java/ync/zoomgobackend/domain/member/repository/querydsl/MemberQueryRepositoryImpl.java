package ync.zoomgobackend.domain.member.repository.querydsl;

import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import ync.zoomgobackend.domain.member.dto.MemberListDTO;
import ync.zoomgobackend.domain.member.exception.NotFoundMemberException;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static ync.zoomgobackend.domain.member.entity.QMemberEntity.memberEntity;

@RequiredArgsConstructor
public class MemberQueryRepositoryImpl implements MemberQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;



    public ConstructorExpression<MemberListDTO> memberProjection() {
        return Projections.constructor(
                MemberListDTO.class,
                memberEntity.userNo,
                memberEntity.email,
                memberEntity.name
        );
    }

    @Override
    public MemberListDTO findMemberByUserNo(Long userNo) {
        return Optional
                .ofNullable(
                        jpaQueryFactory.select(memberProjection())
                                .from(memberEntity)
                                .where(memberEntity.userNo.eq(userNo))
                                .groupBy(memberEntity)
                                .fetchOne()
                )
                .orElseThrow(
                        () -> NotFoundMemberException.EXCEPTION
                );
    }
}
