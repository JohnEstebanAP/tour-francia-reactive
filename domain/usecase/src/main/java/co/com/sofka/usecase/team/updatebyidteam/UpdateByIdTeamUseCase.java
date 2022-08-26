package co.com.sofka.usecase.team.updatebyidteam;

import co.com.sofka.model.team.Team;
import co.com.sofka.model.team.gateways.TeamRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UpdateByIdTeamUseCase {
    private final TeamRepository repository;

    public Mono<Team> updateTrainingLeague(String id, Team team) {

        return repository.update(id, team);

    }
}
