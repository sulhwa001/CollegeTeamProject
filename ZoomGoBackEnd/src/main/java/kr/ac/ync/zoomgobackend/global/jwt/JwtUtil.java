package kr.ac.ync.zoomgobackend.global.jwt;


import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import kr.ac.ync.zoomgobackend.domain.member.dto.MemberDTO;
import kr.ac.ync.zoomgobackend.domain.member.exception.NotFoundMemberException;
import kr.ac.ync.zoomgobackend.domain.member.mapper.MemberMapper;
import kr.ac.ync.zoomgobackend.domain.member.repository.MemberRepository;
import kr.ac.ync.zoomgobackend.global.jwt.properties.JwtProperties;
import kr.ac.ync.zoomgobackend.global.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtUtil {
    private final JwtProperties jwtProperties;
    private final MemberRepository memberRepository;
    //access token

    public String generateAccessToken(String email){
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(
                        new Date(System.currentTimeMillis())
                )// 발행
                .setExpiration(
                        new Date(System.currentTimeMillis()+jwtProperties.getExpiration())
                )//만료
                .signWith(SignatureAlgorithm.HS256,jwtProperties.getSecretKey())
                .compact();

    }
    public String generateRefreshToken(String email){
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(
                        new Date(System.currentTimeMillis())
                )// 발행
                .setExpiration(
                        new Date(System.currentTimeMillis()+jwtProperties.getRefreshExpiration())
                )//만료
                .signWith(SignatureAlgorithm.HS256,jwtProperties.getSecretKey())
                .compact();
    }
    //토큰 복호화 및 클레임 확인
    public Claims getClaims(String token)
    {
        try{
            return Jwts.parserBuilder()
                    .setSigningKey(jwtProperties.getSecretKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e){
            throw new JwtException("Expired JWT");
        } catch (UnsupportedJwtException e){
            throw new JwtException("Unsupported JWT");
        }catch (MalformedJwtException e){
            throw new JwtException("Invalid JWT"); //서명예외
        }catch (SignatureException e){
            throw new JwtException("Unsupported JWT");
        } catch (IllegalArgumentException e){
            throw new JwtException("JWT claims string is empty");
        }
    }

    //사용자 인증
    public Authentication getAuthentication(String token)
    {
        Claims claims = getClaims(token);
        String email=claims.getSubject();

        MemberDTO memberDTO= memberRepository.
                findByEmail(email).
                map(memberEntity -> MemberMapper.createDTO(memberEntity)
                        ).orElseThrow(()-> NotFoundMemberException.EXCEPTION
                );


        //사용자 인증 객체
        CustomUserDetails customUserDetails = CustomUserDetails.create(memberDTO);

        return new UsernamePasswordAuthenticationToken
                (customUserDetails, null, customUserDetails.getAuthorities());
    }


}
