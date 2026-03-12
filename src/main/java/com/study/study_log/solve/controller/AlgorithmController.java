package com.study.study_log.solve.controller;

import com.study.study_log.solve.dto.AlgorithmCreateReq;
import com.study.study_log.solve.dto.AlgorithmUpdateReq;
import com.study.study_log.solve.entity.Algorithm;
import com.study.study_log.solve.service.AlgorithmService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/algorithms")
public class AlgorithmController {
    private final AlgorithmService algorithmService;
    @PostMapping
    public void createAlgorithm(@RequestBody AlgorithmCreateReq request) {
        algorithmService.createAlgorithm(request);
    }
    @GetMapping
    public List<Algorithm> getAlgorithm() {
        return algorithmService.getAlgorithm();
    }

    @PatchMapping("/{algorithmId}")
    public void modifyAlgorithm(@PathVariable("algorithmId") Long algorithmId, @RequestBody AlgorithmUpdateReq request) { algorithmService.modifyAlgorithm(algorithmId, request);}

    @DeleteMapping("/{algorithmId}")
    public void removeAlgorithm(@PathVariable("algorithmId") Long algorithmId) {
        algorithmService.removeAlgorithm(algorithmId);
    }
}
