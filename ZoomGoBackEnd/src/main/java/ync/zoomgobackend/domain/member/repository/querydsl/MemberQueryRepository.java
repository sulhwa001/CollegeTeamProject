package ync.zoomgobackend.domain.member.repository.querydsl;

import ync.zoomgobackend.domain.member.dto.MemberDTO;
import ync.zoomgobackend.domain.member.dto.MemberListDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface MemberQueryRepository {

    MemberListDTO findMemberByUserNo(Long userNo);
}
