package co.com.sofka.usecase.cyclist.findallcyclist.findallcyclist;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import co.com.sofka.model.team.Team;
import co.com.sofka.model.team.gateways.TeamRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

/**
 * [class to find all Cyclist]
 *
 * @author John Esteban Alvarez Piedrahita - john.alvarez@sofka.com.co
 * @version 1.0.0
 */
@RequiredArgsConstructor
public class FindAllCyclistUseCase {
    private final CyclistRepository repository;

    /**
     * [Method to find all Teams]
     *
     * @return Flux<Team>
     */
    public Flux<Cyclist> findAllCyclist() {
        return repository.findAll();
    }
}
