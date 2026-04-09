package com.study.study_log.problem.service;

import com.study.study_log.problem.dto.SolvedAcProblemRes;
import com.study.study_log.problem.dto.SolvedacTagRes;
import com.study.study_log.problem.entity.SolvedAcProblem;
import com.study.study_log.problem.entity.SolvedAcTag;
import com.study.study_log.problem.repository.ProblemRepository;
import com.study.study_log.problem.repository.ProblemTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProblemService {
    private final ProblemTagRepository problemTagRepository;
    private final ProblemRepository problemRepository;
    private static final String DEFAULT_LANGUAGE = "ko";

    // solved.ac 태그 API 응답 데이터를 db에 저장
    public void createSolvedAcTag(SolvedacTagRes response) {
        List<SolvedAcTag> list = new ArrayList<>();

        // 태그 목록 순회
        for(SolvedacTagRes.TagItem item : response.getItems()) {
            // 한국어 이름 추출(DEFAULT_LANGUAGE = "ko")
            String koName = extractNameByLanguage(item, DEFAULT_LANGUAGE);

            SolvedAcTag solvedAcTag = SolvedAcTag.builder()
                    .key(item.getKey())
                    .bojTagId(item.getBojTagId())
                    .name(koName)
                    .build();

            list.add(solvedAcTag);
        }

        problemTagRepository.saveAll(list);
    }

    // solved.ac 문제 API 응답 데이터를 db에 저장
    public void createSolvedAcProblem(SolvedAcProblemRes response) {
        List<SolvedAcProblem> problems = new ArrayList<>();

        // 문제 목록 순회
        for(SolvedAcProblemRes.ProblemItem item : response.getItems()) {
            SolvedAcProblem solvedAcProblem = SolvedAcProblem.builder()
                    .problemId(item.getProblemId())
                    .acceptedUserCount(item.getAcceptedUserCount())
                    .koTitle(item.getTitleKo())
                    .level(item.getLevel())
                    .build();

            // 해당 문제의 태그 목록 순회
            for(SolvedAcProblemRes.Tag tagItem : item.getTags()) {
                // DB에서 실제로 태그가 존재하는지 조회 (bojTagId 기준)
                SolvedAcTag tag = problemTagRepository.findByBojTagId(tagItem.getBojTagId());

                // 문제 엔티티에 태그 연관관계 추가
                solvedAcProblem.addTag(tag);
            }

            problems.add(solvedAcProblem);
        }
        problemRepository.saveAll(problems);
    }

    // 특정 언어에 해당하는 태그 이름 찾는 메서드
    private String extractNameByLanguage(SolvedacTagRes.TagItem item, String defaultLanguage) {
        for(SolvedacTagRes.DisplayName displayName : item.getDisplayNames()) {
            if(defaultLanguage.equals(displayName.getLanguage())) {
                return displayName.getName();
            }
        }
        return "unKnown"; // todo: 어떻게 처리 하는게 좋을지...??
    }
}