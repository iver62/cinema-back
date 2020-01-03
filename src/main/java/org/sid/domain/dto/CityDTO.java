package org.sid.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.sid.domain.State;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CityDTO {

    private Long id;
    @NotNull
    @Size(min = 1, max = 256)
    private String name;
    private State state;
    private Date creationDate;
    private Date lastUpdate;
}
