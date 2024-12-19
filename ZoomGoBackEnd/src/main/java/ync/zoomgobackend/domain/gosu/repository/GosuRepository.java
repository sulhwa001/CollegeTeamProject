package ync.zoomgobackend.domain.gosu.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ync.zoomgobackend.domain.gosu.dto.GosuDTO;
import ync.zoomgobackend.domain.gosu.entity.GosuEntity;
import org.springframework.data.jpa.repository.JpaRepository;


import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;

public interface GosuRepository extends JpaRepository<GosuEntity, Long> {
    Optional<GosuEntity> findByUser_UserNo(Long userNo);

}
