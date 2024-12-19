package ync.zoomgobackend.domain.member.service;

import ync.zoomgobackend.domain.member.dto.MemberDTO;

public interface MemberService {
    void register(MemberDTO memberDTO); // MemberDTO 사용
    MemberDTO getMemberByUserNo(String email);


}
