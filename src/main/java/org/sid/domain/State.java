package org.sid.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class State {

    private Long id;
    @NotNull
    private String label;
    @NotNull
    private Country country;
    @NotNull
    private Date creationDate;
    @NotNull
    private Date lastUpdate;
    private String flag;

}
