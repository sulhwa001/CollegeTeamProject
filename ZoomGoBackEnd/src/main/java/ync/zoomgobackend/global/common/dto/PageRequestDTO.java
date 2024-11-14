package ync.zoomgobackend.global.common.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Setter
@Getter
@ToString
public class PageRequestDTO {
    private String keyword;
    private String type;
    private int page;
    private int size;

    public PageRequestDTO(){
        page = 1;
        size = 20;
    }

    public Pageable getPageable(Sort sort){
        return PageRequest.of(page -1, size, sort);
    }
}
