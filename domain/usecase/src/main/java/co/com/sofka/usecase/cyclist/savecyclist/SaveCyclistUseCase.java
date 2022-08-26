package co.com.sofka.usecase.cyclist.savecyclist;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class SaveCyclistUseCase {

    private final CyclistRepository repository;

    public Mono<Cyclist> addCyclist(Cyclist cyclist) {
        return repository.save(cyclist);
    }
}
