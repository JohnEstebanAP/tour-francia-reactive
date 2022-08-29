package co.com.sofka.usecase.cyclist.deletebyidcyclist;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

/**
 * [Use case for deleting a Cyclist with its Id]
 *
 * @author John Esteban Alvarez Piedrahita - john.alvarez@sofka.com.co
 * @version 1.0.0
 */
@RequiredArgsConstructor
public class DeleteByIdCyclistUseCase {
    private final CyclistRepository repository;

    /**
     * [Method for deleting a Device with its Id]
     *
     * @param id String
     * @return Mono<Void>
     */
    public Mono<Void> deleteCyclist(String id) {
        return repository.deleteById(id);
    }
}
