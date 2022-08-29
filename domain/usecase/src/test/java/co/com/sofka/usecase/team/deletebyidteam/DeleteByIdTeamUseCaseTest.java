package co.com.sofka.usecase.team.deletebyidteam;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.valuesobject.Name;
import co.com.sofka.model.team.Team;
import co.com.sofka.model.team.gateways.TeamRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DeleteByIdTeamUseCaseTest {
    @InjectMocks
    DeleteByIdTeamUseCase deleteByIdTeamUseCase;

    @Mock
    TeamRepository repository;

    @Test
    void deleteByIdTeamTest() {
        // ARR
        Team team = new Team("AB1", "Bear",  "Colombia", List.of(123,124) );

        Mono<Void> voidMono = Mono.empty();
        when(repository.deleteById("AB1")).thenReturn(voidMono);

        //ACT
        StepVerifier.create(deleteByIdTeamUseCase.deleteTeam("AB1"))
                .expectNextMatches(response -> false)
                .expectNext()
                .expectComplete();
    }
}
