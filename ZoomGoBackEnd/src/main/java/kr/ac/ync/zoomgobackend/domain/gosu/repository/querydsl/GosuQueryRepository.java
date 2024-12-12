package kr.ac.ync.zoomgobackend.domain.gosu.repository.querydsl;

import kr.ac.ync.zoomgobackend.domain.gosu.dto.GosuChangeDTO;
import kr.ac.ync.zoomgobackend.domain.gosu.dto.GosuDTO;
import kr.ac.ync.zoomgobackend.domain.gosu.entity.GosuEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GosuQueryRepository {
    GosuChangeDTO findById(Long id);

    GosuDTO findGosuProfileByGosuId(Long gosuId);
}

