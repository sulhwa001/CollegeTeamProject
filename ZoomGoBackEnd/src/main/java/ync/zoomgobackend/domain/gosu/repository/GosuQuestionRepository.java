package ync.zoomgobackend.domain.gosu.repository;

import ync.zoomgobackend.domain.gosu.entity.GosuEntity;
import ync.zoomgobackend.domain.gosu.entity.GosuQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GosuQuestionRepository extends JpaRepository<GosuQuestionEntity, Long> {

}
