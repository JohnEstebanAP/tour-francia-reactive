package co.com.sofka.usecase.cyclist.findallcyclist.findallcyclist;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import co.com.sofka.model.team.Team;
import co.com.sofka.model.team.gateways.TeamRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class FindAllCyclistUseCase {
    private final CyclistRepository repository;

    public Flux<Cyclist> findAllCyclist() {
        return repository.findAll();
    }
}
