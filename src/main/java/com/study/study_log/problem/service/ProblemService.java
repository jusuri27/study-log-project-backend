package com.study.study_log.problem.service;

import com.study.study_log.problem.dto.SolvedacTagRes;
import com.study.study_log.problem.entity.SolvedAcTag;
import com.study.study_log.problem.repository.ProblemTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProblemService {
    private final ProblemTagRepository problemTagRepository;
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