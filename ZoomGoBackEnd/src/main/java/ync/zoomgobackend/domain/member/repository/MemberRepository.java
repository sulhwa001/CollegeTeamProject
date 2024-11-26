package ync.zoomgobackend.domain.member.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.jpa.repository.JpaRepository;
import ync.zoomgobackend.domain.member.entity.MemberEntity;

//jpa를 통한 데이터 베이스 접근 기능


public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

}
