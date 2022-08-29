package co.com.sofka.usecase.team.findallteam;

import co.com.sofka.model.team.Team;
import co.com.sofka.model.team.gateways.TeamRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

/**
 * [class to find all Teams]
 *
 * @author John Esteban Alvarez Piedrahita - john.alvarez@sofka.com.co
 * @version 1.0.0
 */
@RequiredArgsConstructor
public class FindAllTeamUseCase {
    private final TeamRepository repository;

    /**
     * [Method to find all Teams]
     * @return Flux<Team>
     */
    public Flux<Team> findAllTeam() {
        return repository.findAll();
    }
}
