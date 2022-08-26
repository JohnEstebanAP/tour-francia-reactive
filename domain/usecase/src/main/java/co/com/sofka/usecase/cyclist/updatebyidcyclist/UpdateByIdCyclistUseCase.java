package co.com.sofka.usecase.cyclist.updatebyidcyclist;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import co.com.sofka.model.team.Team;
import co.com.sofka.model.team.gateways.TeamRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UpdateByIdCyclistUseCase {
    private final CyclistRepository repository;

    public Mono<Cyclist> updateCyclist(Integer id, Cyclist cyclist) {

        return repository.updateCyclist(id, cyclist);

    }
}
