package com.study.study_log.solve.entity;

import com.study.study_log.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Solve extends BaseEntity {
    @Id
    @Column(name = "id")
    @Comment("푼 문제 ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("문제 이름")
    @Column(name = "title", nullable = false)
    private String title;

    @Comment("난이도")
    @Column(name = "level", nullable = false)
    private int level;

    @Comment("푼 횟수")
    @Column(name = "solved_count", nullable = false)
    private int solvedCount;

    @Comment("문제 유형")
    @Column(name = "tag")
    private String tag;

    @Comment("설명")
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Builder
    private Solve(String title, int level, int solvedCount, String tag, String description) {
        this.title = title;
        this.level = level;
        this.solvedCount = solvedCount;
        this.tag = tag;
        this.description = description;
    }

    public void update(String title, int level, String tag, String description) {
        this.title = title;
        this.level = level;
        this.tag = tag;
        this.description = description;
    }
}
