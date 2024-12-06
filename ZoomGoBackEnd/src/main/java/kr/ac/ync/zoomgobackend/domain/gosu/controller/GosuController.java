package kr.ac.ync.zoomgobackend.domain.gosu.controller;

import kr.ac.ync.zoomgobackend.domain.gosu.dto.GosuChangeDTO;
import kr.ac.ync.zoomgobackend.domain.gosu.dto.GosuDTO;
import kr.ac.ync.zoomgobackend.domain.gosu.entity.GosuEntity;
import kr.ac.ync.zoomgobackend.domain.gosu.service.GosuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gosu")
public class GosuController {
    private final GosuService gosuService;

    @GetMapping("/gosuProfile/{gosuId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<GosuEntity> selectProfile(@PathVariable("gosuId") Long gosuId) {
        return gosuService.getGosuByGosuId(gosuId).map(ResponseEntity::ok).orElseThrow();
    }


    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Long> insertGosu(@RequestBody GosuDTO gosuDTO) {
        Long gosuId = gosuService.insertGosu(gosuDTO);
        return ResponseEntity.ok(gosuId);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/updateName/{userNo}")
    public ResponseEntity<String> udpateName(@RequestBody GosuChangeDTO gosuChangeDTO) {

        return ResponseEntity.ok(gosuService.updateUserName(gosuChangeDTO));
    }


}
