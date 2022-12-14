package co.com.sofka.mongo.team;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamMongoDBRepository extends ReactiveMongoRepository<TeamDocument/* change for adapter model */, String>, ReactiveQueryByExampleExecutor<TeamDocument/* change for adapter model */> {
}
