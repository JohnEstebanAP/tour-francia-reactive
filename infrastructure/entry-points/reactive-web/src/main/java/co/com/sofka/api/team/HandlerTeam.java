package co.com.sofka.api.team;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.team.Team;
import co.com.sofka.usecase.cyclist.deletebyidcyclist.DeleteByIdCyclistUseCase;
import co.com.sofka.usecase.cyclist.findallcyclist.findallcyclist.FindAllCyclistUseCase;
import co.com.sofka.usecase.cyclist.findbyidcyclist.FindByIdCyclistUseCase;
import co.com.sofka.usecase.cyclist.savecyclist.SaveCyclistUseCase;
import co.com.sofka.usecase.cyclist.updatebyidcyclist.UpdateByIdCyclistUseCase;
import co.com.sofka.usecase.team.deletebyidteam.DeleteByIdTeamUseCase;
import co.com.sofka.usecase.team.findallteam.FindAllTeamUseCase;
import co.com.sofka.usecase.team.findbyidteam.FindByIdTeamUseCase;
import co.com.sofka.usecase.team.saveteam.SaveTeamUseCase;
import co.com.sofka.usecase.team.updatebyidteam.UpdateByIdTeamUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class HandlerTeam {
    private final SaveTeamUseCase saveTeamUseCase;
    private final FindAllTeamUseCase findAllTeamUseCase;
    private final FindByIdTeamUseCase findByIdTeamUseCase;
    private final UpdateByIdTeamUseCase updateByIdTeamUseCase;
    private final DeleteByIdTeamUseCase deleteByIdTeamUseCase;

    public Mono<ServerResponse> listenPostAddTeamUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Team.class)
                .flatMap(team -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(saveTeamUseCase.addTeam(team), Team.class));
    }

    public Mono<ServerResponse> listenFindAllTeamUseCase(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(findAllTeamUseCase.findAllTeam(), Team.class);
    }

    public Mono<ServerResponse> listenFindTeamUseCase(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(findByIdTeamUseCase.findByIdTeam(id), Team.class);
    }

    public Mono<ServerResponse> listenUpdateTeamUseCase(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");
        return serverRequest.bodyToMono(Team.class)
                .flatMap(team -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(updateByIdTeamUseCase.updateByIdTeam(id, team),
                                Team.class));
    }

    public Mono<ServerResponse> listenDeleteTeamUseCase(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(deleteByIdTeamUseCase.deleteTeam(id), Team.class);
    }
}
