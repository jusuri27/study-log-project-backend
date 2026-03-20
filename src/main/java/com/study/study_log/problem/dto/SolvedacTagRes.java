package com.study.study_log.problem.dto;

import lombok.Getter;

import java.util.List;

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
