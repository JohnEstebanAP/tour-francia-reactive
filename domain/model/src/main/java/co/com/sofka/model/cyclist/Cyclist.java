package co.com.sofka.model.cyclist;

import co.com.sofka.model.cyclist.valuesobject.Name;
import co.com.sofka.model.team.Team;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Cyclist {
 private String id;
 private Name name;
 private Integer competitorNumber;
 private String teamId;
 private String nationality;
}
