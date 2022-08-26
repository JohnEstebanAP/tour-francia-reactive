package co.com.sofka.mongo.team;

import co.com.sofka.model.team.Team;
import co.com.sofka.model.team.gateways.TeamRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class TeamMongoRepositoryAdapter extends  AdapterOperations<Team/* change for domain model */, TeamDocument/* change for adapter model */, String, TeamMongoDBRepository>
        implements TeamRepository{

    public TeamMongoRepositoryAdapter(TeamMongoDBRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Team.class/* change for domain model */));
    }

    @Override
    public Mono<Team> update(String id, Team team) {
        return repository.save(
                new TeamDocument(
                        id,
                        team.getName(),
                        team.getCountry(),
                        team.getCyclists()
                        )
        ).flatMap(element -> Mono.just(team));
    }
}
