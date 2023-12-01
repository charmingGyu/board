package com.goorm.articleservice.model.dto;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class ContentDto {
    private String content;
}
