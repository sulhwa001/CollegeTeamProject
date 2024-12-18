package ync.zoomgobackend.domain.community.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ync.zoomgobackend.domain.community.dto.CommunityDTO;
import ync.zoomgobackend.domain.community.entity.CommunityEntity;
import ync.zoomgobackend.domain.community.repository.CommunityRepository;
import ync.zoomgobackend.domain.comment.repository.CommentRepository;
import ync.zoomgobackend.domain.member.entity.MemberEntity;
import ync.zoomgobackend.global.common.dto.PageRequestDTO;
import ync.zoomgobackend.global.common.dto.PageResultDTO;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class CommunityServiceImpl implements CommunityService {

    private final CommunityRepository communityRepository;
    private final CommentRepository commentRepository;

    @Override
    public void register(CommunityDTO dto) {    //게시글 등록
        CommunityEntity communityEntity = dtoToEntity(dto);
        communityRepository.save(communityEntity);
    }

    @Override
    public void modify(CommunityDTO dto) {
        CommunityEntity communityEntity = dtoToEntity(dto);
        communityRepository.save(communityEntity);
    }

    @Override
    public CommunityDTO get(Long postNo) {  //postNo에 맞는 게시글 가져오기
        Object result = communityRepository.getBoardByPostNo(postNo);
        Object[] arr = (Object[]) result;
        return entityToDTO((CommunityEntity) arr[0], (MemberEntity) arr[1], (Long)arr[2]);
    }

    @Override
    public void removeWithReplies(Long postNo) {    //postNo와 맞는 게시글과 댓글 삭제하기
        commentRepository.deleteByBoardId(postNo);
        communityRepository.deleteById(postNo);
    }

    @Override
    public PageResultDTO<CommunityDTO, Object[]> getList(String communityType, PageRequestDTO pageRequestDTO) { //게시판 타입에 맞는 게시글 리스트 가져오기
        Page<Object[]> result = communityRepository.getBoardWithReplyCount(communityType,pageRequestDTO.getPageable(Sort.by("postNo").descending()));
        return new PageResultDTO<>(result,(en -> entityToDTO((CommunityEntity) en[0], (MemberEntity) en[1], (Long)en[2])));
    }

    @Override
    public PageResultDTO<CommunityDTO, Object[]> getListWithKeyword(String keyword, String communityType, PageRequestDTO pageRequestDTO) {
        Page<Object[]> result = communityRepository.getBoardContaining(keyword,communityType,pageRequestDTO.getPageable(Sort.by("postNo").descending()));
        return new PageResultDTO<>(result,(en -> entityToDTO((CommunityEntity) en[0], (MemberEntity) en[1], (Long)en[2])));
    }

    @Override
    public void updateViews(Long postNo) {
        communityRepository.updateViews(postNo);
    }


}
