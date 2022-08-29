package co.com.sofka.usecase.team.updatebyidteam;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import co.com.sofka.model.cyclist.valuesobject.Name;
import co.com.sofka.model.team.Team;
import co.com.sofka.model.team.gateways.TeamRepository;
import co.com.sofka.usecase.cyclist.updatebyidcyclist.UpdateByIdCyclistUseCase;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class UpdateByIdTeamUseCaseTest {

    @InjectMocks
    UpdateByIdTeamUseCase updateByIdTeamUseCase;

    @Mock
    TeamRepository repository;

    @Test
    void upadteCyclistTest() {
        // ARR
        Team team1 = new Team("AB1", "Bear",  "Colombia", List.of(123,124) );

        Mono<Team> teamMono = Mono.just(team1);
        when(repository.update("AB1", team1)).thenReturn(teamMono);

        //ACT
        StepVerifier.create(updateByIdTeamUseCase.updateByIdTeam("AB1",team1))
                .expectNextMatches(team -> team.getId().equals(team1.getId()))
                .verifyComplete();
    }
}
