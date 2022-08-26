package co.com.sofka.usecase.team.findbyidteam;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import co.com.sofka.model.team.Team;
import co.com.sofka.model.team.gateways.TeamRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class FindByIdTeamUseCase {
    private final TeamRepository repository;

    public Mono<Team> findByIdTeam(String id) {
        return repository.findById(id);
    }
}
