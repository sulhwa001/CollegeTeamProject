package kr.ac.ync.zoomgobackend.domain.member.service;

import kr.ac.ync.zoomgobackend.domain.member.dto.MemberDTO;

public interface MemberService {
    void register(MemberDTO memberDTO); // MemberDTO 사용
}
