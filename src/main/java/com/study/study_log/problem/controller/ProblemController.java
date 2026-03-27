package com.study.study_log.problem.controller;

import com.study.study_log.common.util.SolvedAcApi;
import com.study.study_log.problem.dto.SolvedAcProblemRes;
import com.study.study_log.problem.dto.SolvedacTagRes;
import com.study.study_log.problem.service.ProblemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/problems")
public class ProblemController {
    private final ProblemService problemService;

    // solved.ac 태그 데이터를 가져와 DB에 저장하는 API
    @GetMapping("/tags")
    public void getProblemTag() throws IOException, InterruptedException {
        SolvedacTagRes response = SolvedAcApi.requestSolvedAcApi("https://solved.ac/api/v3/tag/list", SolvedacTagRes.class);
        problemService.createSolvedAcTag(response);
    }

    // solved.ac  문제 데이터를 가져와 DB에 저장하는 API
    @GetMapping()
    public void getProblem() throws IOException, InterruptedException {
        SolvedAcProblemRes response = SolvedAcApi.requestSolvedAcApi("https://solved.ac/api/v3/search/problem?query=&page=1", SolvedAcProblemRes.class);
        problemService.createSolvedAcProblem(response);
    }
}
