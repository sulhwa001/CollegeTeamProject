package ync.zoomgobackend.domain.gosu.repository.querydsl;

import org.springframework.data.jpa.repository.JpaRepository;
import ync.zoomgobackend.domain.gosu.dto.GosuChangeDTO;
import ync.zoomgobackend.domain.gosu.dto.GosuDTO;
import ync.zoomgobackend.domain.gosu.entity.GosuEntity;
import org.springframework.stereotype.Repository;
import ync.zoomgobackend.domain.gosu.entity.GosuQuestionEntity;

import java.util.Optional;

@Repository
public interface GosuQueryRepository {
    GosuChangeDTO findById(Long id);

    GosuDTO findGosuProfileByGosuId(Long gosuId);
}

