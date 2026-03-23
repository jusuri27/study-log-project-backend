package com.study.study_log.problem.dto;

import lombok.Getter;

import java.util.List;

/**
 * Solved.ac 태그 API 응답 DTO
 * TagItem, DisplayName는 해당 응답에서만 사용되므로 별도 파일로 분리하지 않고 inner 클래스로 구성
 */
@Getter
public class SolvedacTagRes {
    private List<TagItem> items;

    public static class TagItem {
        private String key;
        private int bojTagId;
        private List<DisplayName> displayNames;
    }

    public static class DisplayName {
        private String language;
        private String name;
    }
}
