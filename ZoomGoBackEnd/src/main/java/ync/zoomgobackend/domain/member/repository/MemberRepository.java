package ync.zoomgobackend.domain.member.repository;

<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.jpa.repository.JpaRepository;
import ync.zoomgobackend.domain.member.entity.MemberEntity;

//jpa를 통한 데이터 베이스 접근 기능


public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
=======
import ync.zoomgobackend.domain.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, String> {
    Optional<MemberEntity> findByEmail(String email);
    Optional<MemberEntity> findByUserNo(Long userNo);

>>>>>>> main

}
