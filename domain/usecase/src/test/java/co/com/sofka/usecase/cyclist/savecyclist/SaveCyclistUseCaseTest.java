package co.com.sofka.usecase.cyclist.savecyclist;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import co.com.sofka.model.cyclist.valuesobject.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SaveCyclistUseCaseTest {

    @InjectMocks
    SaveCyclistUseCase saveCyclistUseCase;

    @Mock
    CyclistRepository repository;

    @Test
    void addCyclistTest() {
        // ARR
        Name name = new Name("John Esteban", "Alvarez Piedrahita");
        Cyclist cyclist = new Cyclist("123", name, "AB1", "Colombia");

        Mono<Cyclist> cyclistMono = Mono.just(cyclist);
        when(repository.save(cyclist)).thenReturn(cyclistMono);

        //ACT
        StepVerifier.create(saveCyclistUseCase.addCyclist(cyclist)) //ASSERT
                .expectNextMatches(cyclist1 -> cyclist1.getCompetitorNumber().equals(cyclist.getCompetitorNumber()))
                .verifyComplete();

        //prueba para el metodo publico cyclistIdHasMax3Num
        Assertions.assertTrue(saveCyclistUseCase.cyclistIdHasMax3Num(-10));
        Assertions.assertTrue(saveCyclistUseCase.cyclistIdHasMax3Num(100000));


        //prueba para el metodo publico teamIdHasMax3Char
        Assertions.assertTrue(saveCyclistUseCase.teamIdHasMax3Char("Hola"));
        //prueba para el metodo publico cyclistIdHasMax3Num
        Assertions.assertFalse(saveCyclistUseCase.cyclistIdHasMax3Num(10));

        //prueba para el metodo publico teamIdHasMax3Char
        Assertions.assertFalse(saveCyclistUseCase.teamIdHasMax3Char("ABC"));

    }

    @Test
    void errorAddCyclistTest() {
        // ARR
        Name name = new Name("John Esteban", "Alvarez Piedrahita");
        Cyclist cyclist = new Cyclist("123", name, "AB1C", "Colombia");

        StepVerifier.create(saveCyclistUseCase.addCyclist(cyclist))
                .expectErrorMatches(throwable ->
                        throwable instanceof IllegalArgumentException &&
                                throwable.getMessage().equals("Error the teamId must be a maximum of 3 characters. ")
                ).verify();


        cyclist = new Cyclist("123", name, "", "Colombia");
        StepVerifier.create(saveCyclistUseCase.addCyclist(cyclist))
                .expectErrorMatches(throwable ->
                        throwable instanceof IllegalArgumentException &&
                                throwable.getMessage().equals("Error the teamId cannot be empty ")
                ).verify();


        cyclist = new Cyclist("12734", name, "AB1", "Colombia");
        StepVerifier.create(saveCyclistUseCase.addCyclist(cyclist))
                .expectErrorMatches(throwable ->
                        throwable instanceof IllegalArgumentException &&
                                throwable.getMessage().equals("Error Invalid competitor number, this must be fully numeric and 3 digits. ")
                ).verify();


        cyclist = new Cyclist("12734", name, "AB1", "Colombia");
        StepVerifier.create(saveCyclistUseCase.addCyclist(cyclist))
                .expectErrorMatches(throwable ->
                        throwable instanceof IllegalArgumentException &&
                                throwable.getMessage().equals("Error Invalid competitor number, this must be fully numeric and 3 digits. ")
                ).verify();


        cyclist = new Cyclist("1A4", name, "AB1", "Colombia");
        StepVerifier.create(saveCyclistUseCase.addCyclist(cyclist))
                .expectErrorMatches(throwable ->
                        throwable instanceof NumberFormatException &&
                                throwable.getMessage().equals("Error Invalid competitor number, this must be fully numeric and 3 digits. ")
                ).verify();
    }
}
