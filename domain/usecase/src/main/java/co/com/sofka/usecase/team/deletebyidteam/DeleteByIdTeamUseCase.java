package co.com.sofka.usecase.team.deletebyidteam;

import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import co.com.sofka.model.team.gateways.TeamRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

/**
 * [Use case for deleting a Team with its Id]
 *
 * @author John Esteban Alvarez Piedrahita - john.alvarez@sofka.com.co
 * @version 1.0.0
 */
@RequiredArgsConstructor
public class DeleteByIdTeamUseCase {
    private final TeamRepository repository;

    /**
     * [Method for deleting a Device with its Id]
     * @param id String
     * @return Mono<Void>
     */
    public Mono<Void> deleteTeam(String id) {
        return repository.deleteById(id);
    }
}
