package co.com.sofka.usecase.team.saveteam;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import co.com.sofka.model.team.Team;
import co.com.sofka.model.team.gateways.TeamRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class SaveTeamUseCase {
    private final TeamRepository repository;

    public Mono<Team> addTeam(Team team) {

        String teamId = Objects.requireNonNull(team.getId());
        if(teamId.isBlank()){
            return Mono.error(new IllegalArgumentException("Error the teamId cannot be empty "));
        }

        if(!((team.getId().length() >= 1) && (team.getId().length() <= 3))){
            return Mono.error(new IllegalArgumentException("Error the teamId must be a maximum of 3 characters. "));
        }

        var listCyclists = team.getCyclists().stream().distinct().collect(Collectors.toList());
        team.setCyclists(listCyclists);

        if(listCyclists.stream().count() > 8){
            return Mono.error(new IllegalArgumentException("The number of cyclists in a team cannot exceed 8 cyclists. "));
        }

        Boolean cyclistIdmax8 =listCyclists.stream().map( cyclistId -> {
            if (!((cyclistId >= 0) && (cyclistId <= 999))) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }).collect(Collectors.toList()).contains(Boolean.TRUE);

        if(cyclistIdmax8){
            return Mono.error(new IllegalArgumentException("Error Invalid competitor number, this must be fully numeric and 3 digits. "));
        }

        return repository.save(team);
    }
}
