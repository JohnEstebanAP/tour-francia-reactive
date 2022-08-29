package co.com.sofka.usecase.team.saveteam;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import co.com.sofka.model.cyclist.valuesobject.Name;
import co.com.sofka.model.team.Team;
import co.com.sofka.model.team.gateways.TeamRepository;
import co.com.sofka.usecase.cyclist.savecyclist.SaveCyclistUseCase;
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
public class SaveTeamUseCaseTest {

    @InjectMocks
    SaveTeamUseCase saveTeamUseCase;

    @Mock
    TeamRepository repository;

    @Test
    void addTeamTest() {
        // ARR
        Team team1 = new Team("AB1", "Bear",  "Colombia", List.of(123,124) );

        Mono<Team> teamMono = Mono.just(team1);
        when(repository.save(team1)).thenReturn(teamMono);

        //ACT
        StepVerifier.create(saveTeamUseCase.addTeam(team1)) //ASSERT
                .expectNextMatches(team -> team.getId().equals(team1.getId()))
                .verifyComplete();
    }
}
