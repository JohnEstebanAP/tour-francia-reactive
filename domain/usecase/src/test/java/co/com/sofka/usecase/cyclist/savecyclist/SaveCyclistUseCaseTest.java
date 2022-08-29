package co.com.sofka.usecase.cyclist.savecyclist;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import co.com.sofka.model.cyclist.valuesobject.Name;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Objects;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SaveCyclistUseCaseTest {

    @InjectMocks
    SaveCyclistUseCase saveCyclistUseCase;

    @Mock
    CyclistRepository repository;

    @Test
    void addCyclistTest() {
        // ARR
        Name name = new Name("John Esteban", "Alvarez Piedrahita");
        Cyclist cyclist = new Cyclist("123", name, "AB1", "Colombia" );

        Mono<Cyclist> cyclistMono = Mono.just(cyclist);
        when(repository.save(cyclist)).thenReturn(cyclistMono);

        //ACT
        StepVerifier.create(saveCyclistUseCase.addCyclist(cyclist)) //ASSERT
                .expectNextMatches(cyclist1 -> cyclist1.getCompetitorNumber().equals(cyclist.getCompetitorNumber()))
                .verifyComplete();
    }

}
