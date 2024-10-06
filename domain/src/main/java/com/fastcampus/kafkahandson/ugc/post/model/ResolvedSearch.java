package com.fastcampus.kafkahandson.ugc.post.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ResolvedSearch { // Search + 메타정보 => 조립

    private Long id;
    private String query;
    private Long userId;
    private String userName;
    private Long categoryId;
    private String categoryName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean updated;

    public static ResolvedSearch generate(Search search, String userName, String categoryName) {
        return new ResolvedSearch(
                search.getId(),
                search.getQuery(),
                search.getUserId(),
                userName,
                search.getCategoryId(),
                categoryName,
                search.getCreatedAt(),
                search.getUpdatedAt(),
                !search.getCreatedAt().equals(search.getUpdatedAt())
        );
    }
}
