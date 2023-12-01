package com.goorm.articleservice.model.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListResult<T> {
    private int offset;
    private int totalPage;
    private List<T> list;
}
