package co.com.sofka.usecase.cyclist.deletebyidcyclist;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import co.com.sofka.model.cyclist.valuesobject.Name;
import co.com.sofka.usecase.cyclist.findallcyclist.findallcyclist.FindAllCyclistUseCase;
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
public class DeleteByIdCyclistUseCaseTest {
    @InjectMocks
    DeleteByIdCyclistUseCase deleteByIdCyclistUseCase;

    @Mock
    CyclistRepository repository;

    @Test
    void deleteByIdCyclistTest() {
        // ARR
        Name name = new Name("John Esteban", "Alvarez Piedrahita");
        Cyclist cyclist = new Cyclist("123", name, "AB1", "Colombia" );

        Mono<Void> voidMono = Mono.empty();
        when(repository.deleteById("123")).thenReturn(voidMono);

        //ACT
        StepVerifier.create(deleteByIdCyclistUseCase.deleteCyclist("123"))
                .expectNextMatches(response -> false)
                .expectNext()
                .expectComplete();
    }
}
