package co.com.sofka.usecase.team.findbyidteam;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import co.com.sofka.model.team.Team;
import co.com.sofka.model.team.gateways.TeamRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

/**
 * [Class to find a Team by its id]
 * @author John Esteban Alvarez Piedrahita - john.alvarez@sofka.com.co
 * @version 1.0.0
 */
@RequiredArgsConstructor
public class FindByIdTeamUseCase {
    private final TeamRepository repository;

    /**
     * [Method to find a Team by its id]
     * @param id String (id of the equipment to be searched)
     * @return Mono<Team>
     */
    public Mono<Team> findByIdTeam(String id) {
        return repository.findById(id);
    }
}
