package co.com.sofka.model.team.gateways;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.team.Team;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TeamRepository {
    Mono<Team> save(Team team);

    Flux<Team> findAll();

    Mono<Team> findById(String id);

    Mono<Void> deleteById(String id);

    Mono<Team> update(String id, Team team);
}
