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
public class State {

    private Long id;
    @NotNull
    @Size(min = 1, max = 256)
    private String label;
    @NotNull
    private Country country;
    private Date creationDate;
    private Date lastUpdate;
    private String flag;

}
