package kr.ac.ync.zoomgobackend.domain.member.repository.querydsl;

import kr.ac.ync.zoomgobackend.domain.member.dto.MemberDTO;
import kr.ac.ync.zoomgobackend.domain.member.dto.MemberListDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface MemberQueryRepository {

    MemberListDTO findMemberByUserNo(Long userNo);
}
