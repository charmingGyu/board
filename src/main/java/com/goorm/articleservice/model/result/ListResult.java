package com.goorm.articleservice.model.result;

import lombok.*;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class ListResult<T> {
    private int offset;
    private int totalPage;
    private List<T> list;
}
