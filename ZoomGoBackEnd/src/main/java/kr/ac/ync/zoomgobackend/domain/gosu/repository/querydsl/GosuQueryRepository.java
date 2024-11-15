package kr.ac.ync.zoomgobackend.domain.gosu.repository.querydsl;

import kr.ac.ync.zoomgobackend.domain.gosu.dto.GosuChangeDTO;
import kr.ac.ync.zoomgobackend.domain.gosu.dto.GosuDTO;

public interface GosuQueryRepository {
    GosuChangeDTO findById(Long id);
    GosuDTO findGosuProfileByGosuId(Long gosuId);
}

