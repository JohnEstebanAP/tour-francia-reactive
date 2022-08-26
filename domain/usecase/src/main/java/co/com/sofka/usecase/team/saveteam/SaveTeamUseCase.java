package co.com.sofka.usecase.team.saveteam;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import co.com.sofka.model.team.Team;
import co.com.sofka.model.team.gateways.TeamRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class SaveTeamUseCase {
    private final TeamRepository repository;

    public Mono<Team> addTeam(Team team) {
        return repository.save(team);
    }
}
