package co.com.sofka.usecase.team.deletebyidteam;

import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import co.com.sofka.model.team.gateways.TeamRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DeleteByIdTeamUseCase {
    private final TeamRepository repository;

    public Mono<Void> deleteTeam(String id) {
        return repository.deleteById(id);
    }
}
