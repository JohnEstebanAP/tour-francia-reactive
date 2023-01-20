package co.com.sofka.api.cyclist;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.usecase.cyclist.deletebyidcyclist.DeleteByIdCyclistUseCase;
import co.com.sofka.usecase.cyclist.findallcyclist.findallcyclist.FindAllCyclistUseCase;
import co.com.sofka.usecase.cyclist.findbyidcyclist.FindByIdCyclistUseCase;
import co.com.sofka.usecase.cyclist.savecyclist.SaveCyclistUseCase;
import co.com.sofka.usecase.cyclist.updatebyidcyclist.UpdateByIdCyclistUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

@Component
@RequiredArgsConstructor
public class HandlerCyclist {
    private final SaveCyclistUseCase saveCyclistUseCase;
    private final FindAllCyclistUseCase findAllCyclistUseCase;
    private final FindByIdCyclistUseCase findByIdCyclistUseCase;
    private final UpdateByIdCyclistUseCase updateByIdCyclistUseCase;
    private final DeleteByIdCyclistUseCase deleteByIdCyclistUseCase;

    public Mono<ServerResponse> listenPostAddCyclistUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Cyclist.class).flatMap(cyclist -> {
            Logger.getLogger(HandlerCyclist.class.getName()).info("Los dotos del ciclista son: " + "/" + cyclist.getName() + "/" + cyclist.getTeamId() + "/" + cyclist.getCompetitorNumber());
            return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(saveCyclistUseCase.addCyclist(cyclist), Cyclist.class);
        });
    }

    public Mono<ServerResponse> listenFindAllCyclistUseCase(ServerRequest serverRequest) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(findAllCyclistUseCase.findAllCyclist(), Cyclist.class);
    }

    public Mono<ServerResponse> listenFindCyclistUseCase(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(findByIdCyclistUseCase.findById(id), Cyclist.class);
    }

    public Mono<ServerResponse> listenUpdateCyclistUseCase(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");
        return serverRequest.bodyToMono(Cyclist.class).flatMap(cyclist -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(updateByIdCyclistUseCase.updateCyclist(id, cyclist), Cyclist.class));
    }

    public Mono<ServerResponse> listenDeleteCyclistUseCase(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(deleteByIdCyclistUseCase.deleteCyclist(id), Cyclist.class);
    }
}
