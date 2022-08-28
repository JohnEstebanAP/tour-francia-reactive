package co.com.sofka.usecase.cyclist.savecyclist;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.Objects;

@RequiredArgsConstructor
public class SaveCyclistUseCase {

    private final CyclistRepository repository;

    public Mono<Cyclist> addCyclist(Cyclist cyclist) {
        try {
            Integer competitorNumber = Integer.parseInt(cyclist.getCompetitorNumber());

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

            return repository.save(cyclist);
        } catch (NumberFormatException exception) {
            return Mono.error(new IllegalArgumentException("Error Invalid competitor number, this must be fully numeric and 3 digits. ".concat(exception.getMessage())));
        }
    }
}
