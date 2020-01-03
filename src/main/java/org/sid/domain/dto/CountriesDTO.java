package org.sid.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.domain.Country;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CountriesDTO extends AbstractDTO {

    private List<Country> countries;

}
