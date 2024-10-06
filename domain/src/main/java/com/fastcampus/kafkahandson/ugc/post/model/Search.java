package com.fastcampus.kafkahandson.ugc.post.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Search {

    private Long id;
    private String query;
    private Long userId;
    private Long categoryId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public Search update(String query, Long categoryId) {
        this.query = query;
        this.categoryId = categoryId;
        this.updatedAt = LocalDateTime.now();
        return this;
    }

    public Search delete() {
        LocalDateTime now = LocalDateTime.now();
        this.deletedAt = now;
        this.updatedAt = now;
        return this;
    }
    public Search Undelete() {
        this.deletedAt = null;
        this.updatedAt = LocalDateTime.now();
        return this;
    }

    public static Search generate(
            Long userId,
            String query,
            Long categoryId
    ){
        LocalDateTime now = LocalDateTime.now();
        return new Search(null, query, userId, categoryId, now, now, null);
    }
}
