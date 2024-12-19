package ync.zoomgobackend.domain.gosu.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ync.zoomgobackend.domain.gosu.entity.GosuEntity;
import ync.zoomgobackend.domain.gosu.entity.GosuQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
@Repository
public interface GosuQuestionRepository extends JpaRepository<GosuQuestionEntity, Long> {
    @Query("SELECT q FROM GosuQuestionEntity q " +
            "WHERE q.gosu.gosuId = (SELECT g.gosuId FROM GosuEntity g JOIN g.user u WHERE u.userNo = :userNo)")
    Optional<GosuQuestionEntity> findByGosuId(@Param("userNo") Long userNo);


}
