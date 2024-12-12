package kr.ac.ync.zoomgobackend.domain.member.service;

import kr.ac.ync.zoomgobackend.domain.member.dto.MypageDTO;
import kr.ac.ync.zoomgobackend.domain.member.entity.MemberEntity;
import kr.ac.ync.zoomgobackend.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MypageService {

    private final MemberRepository memberRepository;


    public MypageDTO getMemberByEmail(String email) {
        MemberEntity member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found with email: " + email));

        return new MypageDTO(member.getName(), member.getManner());
    }
}
