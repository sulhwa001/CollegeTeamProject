package ync.zoomgobackend.domain.review.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ync.zoomgobackend.domain.member.entity.MemberEntity;
import ync.zoomgobackend.domain.review.dto.UserReviewDTO;
import ync.zoomgobackend.domain.review.entity.UserReviewEntity;
import ync.zoomgobackend.domain.review.repository.UserReviewRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class UserReviewServiceImpl implements UserReviewService{

    private final UserReviewRepository userReviewRepository;

    @Override
    public void register(UserReviewDTO userReviewDTO) {
        UserReviewEntity userReviewEntity = dtoToEntity(userReviewDTO);
        userReviewRepository.save(userReviewEntity);
    }

    @Override
    public List<UserReviewDTO> getAll(Long userNo) {
        List<Object[]> result = userReviewRepository.getByUserNo(userNo);
        List<UserReviewDTO> userReviewDTOList = new ArrayList<>();
        for(Object[] dto : result){
            userReviewDTOList.add(entityToDTO((UserReviewEntity) dto[0], (MemberEntity) dto[1]));
        }
        return userReviewDTOList;
    }

}
