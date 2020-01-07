package org.sid.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class City {

    private Long id;
    @NotNull
    @Size(min = 1, max = 256)
    private String label;
    private State state;
    private Country country;
    @NotNull
    private Date creationDate;
    @NotNull
    private Date lastUpdate;

}
