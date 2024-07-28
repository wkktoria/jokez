package io.github.wkktoria.jokez.controller;

import io.github.wkktoria.jokez.api.JokeApiResponse;
import io.github.wkktoria.jokez.service.JokeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JokeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(JokeController.class);

    private final JokeService jokeService;

    public JokeController(final JokeService jokeService) {
        this.jokeService = jokeService;
    }

    public JokeApiResponse randomJoke() {
        LOGGER.info("randomJoke()");
        JokeApiResponse apiResponse = jokeService.randomJoke();
        LOGGER.info("randomJoke(...) = {}", apiResponse);
        return apiResponse;
    }
}
