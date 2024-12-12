package kr.ac.ync.zoomgobackend.domain.gosu.controller;

import kr.ac.ync.zoomgobackend.domain.gosu.dto.GosuChangeDTO;
import kr.ac.ync.zoomgobackend.domain.gosu.dto.GosuDTO;
import kr.ac.ync.zoomgobackend.domain.gosu.dto.GosuUpdateDTO;
import kr.ac.ync.zoomgobackend.domain.gosu.entity.GosuEntity;
import kr.ac.ync.zoomgobackend.domain.gosu.service.GosuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gosu")
public class GosuController {
    private final GosuService gosuService;

    @GetMapping("/gosuProfile/{gosuId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<GosuEntity> selectProfile(@PathVariable("gosuId") Long gosuId) {
        return gosuService.getProfileByGosuId(gosuId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Long> insertGosu(@RequestBody GosuDTO gosuDTO) {
        Long gosuId = gosuService.insertGosu(gosuDTO);
        return ResponseEntity.ok(gosuId);
    }

    @PutMapping("update/{gosuId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Long> updateGosu(@PathVariable("gosuId") Long gosuId, @RequestBody GosuUpdateDTO gosuUpdateDTO) {
        gosuService.updateGosu(gosuId, gosuUpdateDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(gosuId);
    }


    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/updateName/{gosuId}")
    public ResponseEntity<Long> udpateName(@PathVariable("gosuId") Long gosuId, @RequestBody GosuChangeDTO gosuChangeDTO) {
        Long gosuId1= gosuService.updateUserName(gosuId, gosuChangeDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(gosuId1);
    }


}
