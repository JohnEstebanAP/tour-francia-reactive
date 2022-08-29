package co.com.sofka.usecase.cyclist.updatebyidcyclist;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import co.com.sofka.model.team.Team;
import co.com.sofka.model.team.gateways.TeamRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * [class for the use case of Update Cyclist]
 *
 * @author John Esteban Alvarez Piedrahita - john.alvarez@sofka.com.co
 * @version 1.0.0
 */
@RequiredArgsConstructor
public class UpdateByIdCyclistUseCase {
    private final CyclistRepository repository;

    /**
     * [Method to save a new Cyclist]
     *
     * @param cyclist Cyclist (team class body)
     * @return Mono<Cyclist>
     */
    public Mono<Cyclist> updateCyclist(String id, Cyclist cyclist) {
        try {
            Integer competitorNumber = Integer.parseInt(id);

            String teamId = Objects.requireNonNull(cyclist.getTeamId());
            if (teamId.isBlank()) return Mono.error(new IllegalArgumentException("Error the teamId cannot be empty "));

            if (teamIdHasMax3Char(cyclist.getTeamId()))
                return Mono.error(new IllegalArgumentException("Error the teamId must be a maximum of 3 characters. "));

            if (cyclistIdHasMax3Num(competitorNumber))
                return Mono.error(new IllegalArgumentException("Error Invalid competitor number, this must be fully numeric and 3 digits. "));

            return repository.updateCyclist(id, cyclist);
        } catch (NumberFormatException exception) {
            return Mono.error(new IllegalArgumentException("Error Invalid competitor number, this must be fully numeric and 3 digits. ".concat(exception.getMessage())));
        }
    }

    /**
     * [valid if the cyclist ID has more than 3 digits]
     *
     * @param competitorNumber Integer
     * @return Boolean
     */
    public Boolean cyclistIdHasMax3Num(Integer competitorNumber) {

        if (!((competitorNumber >= 0) && (competitorNumber <= 999))) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * [valid if team id is more than 3 characters long]
     *
     * @param teamId String
     * @return Boolean
     */
    public Boolean teamIdHasMax3Char(String teamId) {

        if (!((teamId.length() >= 1) && (teamId.length() <= 3))) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
