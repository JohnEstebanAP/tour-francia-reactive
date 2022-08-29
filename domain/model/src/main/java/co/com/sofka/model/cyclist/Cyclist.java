package co.com.sofka.model.cyclist;

import co.com.sofka.model.cyclist.valuesobject.Name;
import co.com.sofka.model.team.Team;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * [Class that models the basic structure of a cyclist object.]
 *
 * param competitorNumber String
 * param name Name
 * param teamId String
 * param nationality String
 *
 * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
 * @version 1.0.0
 */
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Cyclist {
 private String competitorNumber;
 private Name name;
 private String teamId;
 private String nationality;
}
