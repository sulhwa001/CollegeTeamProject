package kr.ac.ync.zoomgo.back.domain.board.repository;

import kr.ac.ync.zoomgo.back.domain.board.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.jpa.repository.JpaRepository;

//jpa를 통한 데이터 베이스 접근 기능


public interface MemberRepository extends JpaRepository<MemberEntity, String> {

}
