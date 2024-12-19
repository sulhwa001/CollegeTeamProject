package ync.zoomgobackend.domain.member.service;

import ync.zoomgobackend.domain.member.dto.MemberDTO;
import ync.zoomgobackend.domain.member.entity.MemberEntity;

import java.util.Optional;

public interface MemberService {
    void register(MemberDTO memberDTO); // MemberDTO 사용
    Optional<MemberEntity> getMemberByUserNo(Long userNo);


}
