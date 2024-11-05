package kr.ac.ync.zoomgobackend.global.security;


import kr.ac.ync.zoomgobackend.domain.member.dto.MemberDTO;
import kr.ac.ync.zoomgobackend.domain.member.exception.NotFoundMemberException;
import kr.ac.ync.zoomgobackend.domain.member.mapper.MemberMapper;
import kr.ac.ync.zoomgobackend.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberDTO memberDTO=memberRepository.
                findByEmail(username)
                .map(MemberMapper::createDTO)
                .orElseThrow(()-> NotFoundMemberException.EXCEPTION);
        return CustomUserDetails.create(memberDTO);
    }
}



//another one
//        Optional<MemberEntity> result= memberRepository.findByEmail(username);
//        if(result.isPresent())
//        {
//            MemberEntity memberEntity=result.get();
//            MemberDTO memberDTO1= MemberMapper.createDTO(memberEntity);
//        }else{
//            throw NotFoundMemberException.EXCEPTION;
//        }
