package com.study.study_log.solve.controller;

import com.study.study_log.solve.dto.SolveCreateReq;
import com.study.study_log.solve.dto.SolveUpdateReq;
import com.study.study_log.solve.entity.Solve;
import com.study.study_log.solve.service.SolveService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/solves")
public class SolveController {
    private final SolveService solveService;

    @PostMapping
    public void createSolve(@RequestBody SolveCreateReq request) {
        solveService.createSolve(request);
    }

    @GetMapping
    public List<Solve> getSolve() {
        return solveService.getSolve();
    }

    @PatchMapping("/{solveId}")
    public void modifySolve(@PathVariable("solveId") Long solveId, @RequestBody SolveUpdateReq request) {
        solveService.modifySolve(solveId, request);
    }
}
