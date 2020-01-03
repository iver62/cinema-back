package org.sid.filters;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import utils.MySort;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class QueryParameters {

    private Filters filters;
    private MySort sort;
    private Integer from;
    private Integer size;
}
