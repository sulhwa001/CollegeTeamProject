package kr.ac.ync.zoomgobackend.domain.member.repository;

import kr.ac.ync.zoomgobackend.domain.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, String> {
    Optional<MemberEntity> findByEmail(String email);
    Optional<MemberEntity> findByUserNo(Long userNo);

}
