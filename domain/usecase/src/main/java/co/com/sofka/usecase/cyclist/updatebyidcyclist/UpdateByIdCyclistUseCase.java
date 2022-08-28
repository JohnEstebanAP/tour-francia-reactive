package co.com.sofka.usecase.cyclist.updatebyidcyclist;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import co.com.sofka.model.team.Team;
import co.com.sofka.model.team.gateways.TeamRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.Objects;

@RequiredArgsConstructor
public class UpdateByIdCyclistUseCase {
    private final CyclistRepository repository;

    public Mono<Cyclist> updateCyclist(String id, Cyclist cyclist) {
        try {
            Integer competitorNumber = Integer.parseInt(id);

            String teamId = Objects.requireNonNull(cyclist.getTeamId());
            if(teamId.isBlank()){
                return Mono.error(new IllegalArgumentException("Error the teamId cannot be empty "));
            }

            if(!((cyclist.getTeamId().length() >= 1) && (cyclist.getTeamId().length() <= 3))){
                return Mono.error(new IllegalArgumentException("Error the teamId must be a maximum of 3 characters. "));
            }

            if (!((competitorNumber >= 0) && (competitorNumber <= 999))) {
                return Mono.error(new IllegalArgumentException("Error Invalid competitor number, this must be fully numeric and 3 digits. "));
            }

            return repository.updateCyclist(id, cyclist);
        } catch (NumberFormatException exception) {
            return Mono.error(new IllegalArgumentException("Error Invalid competitor number, this must be fully numeric and 3 digits. ".concat(exception.getMessage())));
        }
    }
}
