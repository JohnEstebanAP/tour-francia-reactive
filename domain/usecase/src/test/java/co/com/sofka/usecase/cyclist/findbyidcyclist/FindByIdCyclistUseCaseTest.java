package co.com.sofka.usecase.cyclist.findbyidcyclist;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import co.com.sofka.model.cyclist.valuesobject.Name;
import co.com.sofka.usecase.cyclist.updatebyidcyclist.UpdateByIdCyclistUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class FindByIdCyclistUseCaseTest {

    @InjectMocks
    FindByIdCyclistUseCase findByIdCyclistUseCase;

    @Mock
    CyclistRepository repository;

    @Test
    void findByIdCyclistTest() {
        // ARR
        Name name = new Name("John Esteban", "Alvarez Piedrahita");
        Cyclist cyclist = new Cyclist("123", name, "AB1", "Colombia" );

        Mono<Cyclist> cyclistMono = Mono.just(cyclist);
        when(repository.findById("123")).thenReturn(cyclistMono);

        //ACT
        StepVerifier.create(findByIdCyclistUseCase.findById("123"))
                .expectNextMatches(cyclist1 -> cyclist1.getCompetitorNumber().equals(cyclist.getCompetitorNumber()) && cyclist1.getName().equals(cyclist.getName()))
                .verifyComplete();
    }
}
