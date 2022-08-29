package co.com.sofka.usecase.team.findallteam;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import co.com.sofka.model.cyclist.valuesobject.Name;
import co.com.sofka.model.team.Team;
import co.com.sofka.model.team.gateways.TeamRepository;
import co.com.sofka.usecase.cyclist.findallcyclist.findallcyclist.FindAllCyclistUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindAllTeamUseCaseTest {
    @InjectMocks
    FindAllTeamUseCase findAllTeamUseCase;

    @Mock
    TeamRepository repository;

    @Test
    void findAllCyclistTest() {
        // ARR
        Team team1 = new Team("AB1", "Bear",  "Colombia", List.of(123,124) );
        Team team2 = new Team("AB2", "Lotu",  "Canada", List.of(123,124) );


        Flux<Team> TeamFlux = Flux.fromIterable(List.of(team1, team2));
        when(repository.findAll()).thenReturn(TeamFlux);

        //ACT
        StepVerifier.create(findAllTeamUseCase.findAllTeam())
                .expectNextMatches(team -> team.getId().equals(team1.getId()))
                .expectNextMatches(team -> team.getId().equals(team2.getId()))
                .verifyComplete();
    }
}
