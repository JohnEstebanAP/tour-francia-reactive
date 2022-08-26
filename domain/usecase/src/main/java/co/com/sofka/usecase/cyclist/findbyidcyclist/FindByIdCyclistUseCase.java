package co.com.sofka.usecase.cyclist.findbyidcyclist;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class FindByIdCyclistUseCase {
    private final CyclistRepository repository;

    public Mono<Cyclist> findById(String id) {
        return repository.findById(id);
    }
}
