package co.com.sofka.model.cyclist.gateways;

import co.com.sofka.model.cyclist.Cyclist;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CyclistRepository {
    Mono<Cyclist> save(Cyclist cyclist);

    Mono<Cyclist> add(Cyclist cyclist);

    Flux<Cyclist> findAll();

    Flux<Cyclist> findAll2();

    Mono<Cyclist> findById(String id);

    Mono<Void> deleteById(String id);

    Mono<Cyclist> updateCyclist(String id, Cyclist cyclist);
}
