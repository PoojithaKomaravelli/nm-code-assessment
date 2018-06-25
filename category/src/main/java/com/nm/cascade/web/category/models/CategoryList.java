package com.nm.cascade.web.category.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * Created by PKomaravelli on 6/24/2018.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryList {


    @JsonProperty(value = "count", required = true)
    private Integer count;

    @JsonProperty(value = "entries", required = true)
    private List<Entry> entries;
}
