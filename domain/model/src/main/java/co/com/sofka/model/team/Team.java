package co.com.sofka.model.team;
import co.com.sofka.model.cyclist.Cyclist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    private String id;
    private String name;
    private String country;
    private List<Cyclist> cyclists;
}
