package co.com.sofka.usecase.cyclist.updatebyidcyclist;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import co.com.sofka.model.cyclist.valuesobject.Name;
import co.com.sofka.usecase.cyclist.savecyclist.SaveCyclistUseCase;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UpdateByIdCyclistUseCaseTest {

    @InjectMocks
    UpdateByIdCyclistUseCase updateByIdCyclistUseCase;

    @Mock
    CyclistRepository repository;

    @Test
    void upadteCyclistTest() {
        // ARR
        Name name = new Name("John Esteban", "Alvarez Piedrahita");
        Cyclist cyclist = new Cyclist("123", name, "AB1", "Colombia" );

        Mono<Cyclist> cyclistMono = Mono.just(cyclist);
        when(repository.updateCyclist("123", cyclist)).thenReturn(cyclistMono);

        //ACT
        StepVerifier.create(updateByIdCyclistUseCase.updateCyclist("123",cyclist))
                .expectNextMatches(cyclist1 -> cyclist1.getCompetitorNumber().equals(cyclist.getCompetitorNumber()))
                .verifyComplete();
    }
}
