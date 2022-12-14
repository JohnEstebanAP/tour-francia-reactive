package co.com.sofka.mongo.cyclist;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CyclistMongoDBRepository extends ReactiveMongoRepository<CyclistDocument/* change for adapter model */, String>, ReactiveQueryByExampleExecutor<CyclistDocument/* change for adapter model */> {
}
