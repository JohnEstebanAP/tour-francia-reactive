package co.com.sofka.usecase.cyclist.findbyidcyclist;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

/**
 * [Class to find a Cyclist by its id]
 *
 * @author John Esteban Alvarez Piedrahita - john.alvarez@sofka.com.co
 * @version 1.0.0
 */
@RequiredArgsConstructor
public class FindByIdCyclistUseCase {
    private final CyclistRepository repository;

    /**
     * [Method to find a Team by its id]
     *
     * @param id String (id of the equipment to be searched)
     * @return Mono<Team>
     */
    public Mono<Cyclist> findById(String id) {
        return repository.findById(id);
    }
}
