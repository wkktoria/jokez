package io.github.wkktoria.jokez.controller;

import io.github.wkktoria.jokez.api.JokeApiResponse;
import io.github.wkktoria.jokez.service.JokeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JokeControllerTest {
    @Test
    void randomJoke() {
        // given
        JokeService jokeService = new JokeService();
        JokeController jokeController = new JokeController(jokeService);

        // when
        JokeApiResponse apiResponse = jokeController.randomJoke();

        // then
        Assertions.assertNotNull(apiResponse, "API response is null");
    }
}