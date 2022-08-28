package co.com.sofka.api.cyclist;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class RouterRestCyclist {
@Bean
public RouterFunction<ServerResponse> routerFunctionCyclist(HandlerCyclist handler) {
    return route(POST("/api/cyclist"), handler::listenPostAddCyclistUseCase)
            .andRoute(GET("/api/cyclist"), handler::listenFindAllCyclistUseCase)
            .andRoute(GET("/api/cyclist/{id}"), handler::listenFindCyclistUseCase)
            .andRoute(PUT("/api/cyclist/{id}"), handler::listenUpdateCyclistUseCase)
            .andRoute(DELETE("/api/cyclist/{id}"), handler::listenDeleteCyclistUseCase);
    }
}
