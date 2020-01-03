package utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MySort {

    private String column;
    private Sort.Direction direction;

}
