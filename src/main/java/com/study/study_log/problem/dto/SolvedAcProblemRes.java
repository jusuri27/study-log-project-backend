package com.study.study_log.problem.dto;

import lombok.Getter;

import java.util.List;

/**
 * Solved.ac 문제 API 응답 DTO
 * ProblemItem, Tag는 해당 응답에서만 사용되므로 별도 파일로 분리하지 않고 inner 클래스로 구성
 */
@Getter
public class SolvedAcProblemRes {
    private List<ProblemItem> items;

    @Getter
    public static class ProblemItem {
        private Long problemId;
        private int acceptedUserCount;
        private String titleKo;
        private int level;
        private List<Tag> tags;
    }

    @Getter
    public static class Tag {
        private int bojTagId;
    }
}
