package ync.zoomgobackend.domain.gosu.repository;

import ync.zoomgobackend.domain.gosu.dto.GosuChangeDTO;
import ync.zoomgobackend.domain.gosu.entity.GosuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;

public interface GosuRepository extends JpaRepository<GosuEntity, Long> {
    Optional<GosuEntity> findByGosuId(Long id);
}
