package com.study.study_log.solve.service;

import com.study.study_log.solve.dto.SolveCreateReq;
import com.study.study_log.solve.dto.SolveUpdateReq;
import com.study.study_log.solve.entity.Solve;
import com.study.study_log.solve.repository.SolveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SolveService {
    private final SolveRepository solveRepository;

    public void createSolve(SolveCreateReq request) {
        Solve solve = Solve.builder()
                .title(request.getTitle())
                .level(request.getLevel())
                .solvedCount(1) // 추가시 푼 횟수 +1
                .tag(request.getTag())
                .description(request.getDescription())
                .build();
        solveRepository.save(solve);
    }

    public List<Solve> getSolve() {
        List<Solve> solves = solveRepository.findAll();
        return solves;
    }

    @Transactional
    public void modifySolve(Long solveId, SolveUpdateReq request) {
        Solve solve = solveRepository.findById(solveId).orElseThrow(() -> new IllegalArgumentException("문제가 존재하지 않습니다."));
        solve.update(request.getTitle(), request.getLevel(), request.getTag(), request.getDescription());
    }
}
