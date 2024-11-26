package ync.zoomgobackend.global.common;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
@Getter
//여러 곳에 공통적으로 적용될 클래스이기때문에 추상클래스임
public abstract class BaseEntity { //맵핑x 속성을 부여할 엔티티 자동으로 변경이나 저장돌때 특정 로직수행
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

}
