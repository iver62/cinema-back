package org.sid.domain.dto;

import lombok.*;
import org.sid.domain.City;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CitiesDTO extends AbstractDTO {

    private List<City> cities;
}
