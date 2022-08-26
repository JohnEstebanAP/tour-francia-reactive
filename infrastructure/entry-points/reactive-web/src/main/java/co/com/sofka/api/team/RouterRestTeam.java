package co.com.sofka.api.team;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class RouterRestTeam {
@Bean
public RouterFunction<ServerResponse> routerFunctionTeam(HandlerTeam handler) {
    return route(POST("/api/team"), handler::listenPostAddTeamUseCase)
            .andRoute(GET("/api/team"), handler::listenFindAllTeamUseCase)
            .andRoute(GET("/api/team/{id}"), handler::listenFindTeamUseCase)
            .andRoute(PUT("/api/team/{id}"), handler::listenUpdateTeamUseCase)
            .andRoute(DELETE("/api/team/{id}"), handler::listenDeleteTeamUseCase);
    }
}
