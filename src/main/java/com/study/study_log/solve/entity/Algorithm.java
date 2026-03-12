package com.study.study_log.solve.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Algorithm {
    @Comment("식별자")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Comment("난이도")
    @Column(name = "lv", nullable = false)
    private int lv;

    @Comment("문제 이름")
    @Column(name = "name", nullable = false)
    private String name;

    @Comment("시도 횟수")
    @Column(name = "try_count", nullable = false)
    private int tryCount;

    @Builder
    private Algorithm(int lv, String name, int tryCount) {
        this.lv = lv;
        this.name = name;
        this.tryCount = tryCount;
    }

    public void update(int lv, String name, int tryCount) {
        this.lv = lv;
        this.name = name;
        this.tryCount = tryCount;
    }
}
