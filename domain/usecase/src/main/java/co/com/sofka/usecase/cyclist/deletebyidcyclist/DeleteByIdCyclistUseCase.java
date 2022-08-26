package co.com.sofka.usecase.cyclist.deletebyidcyclist;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DeleteByIdCyclistUseCase {
    private final CyclistRepository repository;

    public Mono<Void> deleteCyclist(String id) {
        return repository.deleteById(id);
    }
}
