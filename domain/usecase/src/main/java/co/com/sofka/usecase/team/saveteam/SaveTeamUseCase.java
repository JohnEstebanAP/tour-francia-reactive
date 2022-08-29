package co.com.sofka.usecase.team.saveteam;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import co.com.sofka.model.team.Team;
import co.com.sofka.model.team.gateways.TeamRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import javax.swing.border.LineBorder;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * [class for the use case of saving a new Team]
 *
 * @author John Esteban Alvarez Piedrahita - john.alvarez@sofka.com.co
 * @version 1.0.0
 */
@RequiredArgsConstructor
public class SaveTeamUseCase {
    private final TeamRepository repository;

    /**
     * [Method to save a new Team]
     *
     * @param team Team (team class body)
     * @return Mono<Team>
     */
    public Mono<Team> addTeam(Team team) {

        String teamId = Objects.requireNonNull(team.getId());

        if (teamId.isBlank()) return Mono.error(new IllegalArgumentException("Error the teamId cannot be empty "));

        if (teamIdHasMax3Char(team))
            return Mono.error(new IllegalArgumentException("Error the teamId must be a maximum of 3 characters. "));

        team.setCyclists(team.getCyclists().stream().distinct().collect(Collectors.toList()));

        if (listCyclistMax8(team.getCyclists()))
            return Mono.error(new IllegalArgumentException("The number of cyclists in a team cannot exceed 8 cyclists. "));

        if (cyclistIdHasMax3Num(team.getCyclists()))
            return Mono.error(new IllegalArgumentException("Error Invalid competitor number, this must be fully numeric and 3 digits. "));

        return repository.save(team);
    }

    /**
     * [valid if team id is more than 3 characters long]
     *
     * @param team Team
     * @return Boolean
     */
    public Boolean teamIdHasMax3Char(Team team) {
        if (!((team.getId().length() >= 1) && (team.getId().length() <= 3))) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * [validates that the list of riders in the team does not exceed a maximum of 8 cyclists]
     *
     * @param listCyclists List<Integer>
     * @return Boolean
     */
    public Boolean listCyclistMax8(List<Integer> listCyclists) {
        if (listCyclists.stream().count() > 8) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * [valid if the cyclist ID has more than 3 digits]
     *
     * @param listCyclists List<Integer>
     * @return Boolean
     */
    public Boolean cyclistIdHasMax3Num(List<Integer> listCyclists) {

        Boolean cyclistIdmax3 = listCyclists.stream().map(cyclistId -> {
            if (!((cyclistId >= 0) && (cyclistId <= 999))) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }).collect(Collectors.toList()).contains(Boolean.TRUE);

        if (cyclistIdmax3) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
