package co.com.sofka.usecase.cyclist.findallcyclist.findallcyclist;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import co.com.sofka.model.cyclist.valuesobject.Name;
import co.com.sofka.usecase.cyclist.findbyidcyclist.FindByIdCyclistUseCase;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindAllCyclistUseCaseTest {

    @InjectMocks
    FindAllCyclistUseCase findAllCyclistUseCase;

    @Mock
    CyclistRepository repository;

    @Test
    void findAllCyclistTest() {
        // ARR
        Name name = new Name("John Esteban", "Alvarez Piedrahita");
        Cyclist cyclist = new Cyclist("123", name, "AB1", "Colombia" );
        Name name2 = new Name("Juan", "Alvarez");
        Cyclist cyclist2 = new Cyclist("124", name, "AB1", "Colombia" );


        Flux<Cyclist> cyclistFlux = Flux.fromIterable(List.of(cyclist, cyclist2));
        when(repository.findAll()).thenReturn(cyclistFlux);

        //ACT
        StepVerifier.create(findAllCyclistUseCase.findAllCyclist())
                .expectNextMatches(cyclist1 -> cyclist1.getCompetitorNumber().equals(cyclist.getCompetitorNumber()))
                .expectNextMatches(cyclist1 -> cyclist1.getCompetitorNumber().equals(cyclist2.getCompetitorNumber()))
                .verifyComplete();
    }
}
