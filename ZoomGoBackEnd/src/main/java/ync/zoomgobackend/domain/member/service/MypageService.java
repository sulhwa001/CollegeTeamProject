package ync.zoomgobackend.domain.member.service;

import ync.zoomgobackend.domain.member.dto.MypageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ync.zoomgobackend.domain.member.entity.MemberEntity;
import ync.zoomgobackend.domain.member.repository.MemberRepository;

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
