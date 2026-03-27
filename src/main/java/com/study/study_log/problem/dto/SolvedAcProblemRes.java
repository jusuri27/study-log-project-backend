package com.study.study_log.problem.dto;

import lombok.Getter;

import java.util.List;

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
