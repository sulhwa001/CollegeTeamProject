package ync.zoomgobackend.domain.gosu.controller;

import ync.zoomgobackend.domain.gosu.dto.GosuChangeDTO;
import ync.zoomgobackend.domain.gosu.dto.GosuDTO;
import ync.zoomgobackend.domain.gosu.dto.GosuUpdateDTO;
import ync.zoomgobackend.domain.gosu.entity.GosuEntity;
import ync.zoomgobackend.domain.gosu.service.GosuService;
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

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Long> updateGosu(@RequestBody GosuUpdateDTO gosuUpdateDTO) {
        Long gosuId = gosuService.updateGosu(gosuUpdateDTO);
        return ResponseEntity.status(HttpStatus.OK).body(gosuId);
    }


    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/updateName/{gosuId}")
    public ResponseEntity<Long> udpateName(@PathVariable("gosuId") Long gosuId, @RequestBody GosuChangeDTO gosuChangeDTO) {
        Long gosuId1= gosuService.updateUserName(gosuId, gosuChangeDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(gosuId1);
    }


}
