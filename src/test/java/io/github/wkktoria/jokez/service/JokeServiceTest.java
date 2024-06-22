package io.github.wkktoria.jokez.service;

import io.github.wkktoria.jokez.api.JokeApiResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class JokeServiceTest {
    @Test
    void getResponseBody() throws IOException {
        // given
        JokeService jokeService = new JokeService();
        String url = "https://official-joke-api.appspot.com/jokes/random";

        // when
        String responseBody = jokeService.getResponseBody(url);

        // then
        Assertions.assertNotNull(responseBody, "Response body is null");
    }

    @Test
    void convert() {
        // given
        JokeService jokeService = new JokeService();

        // when
        JokeApiResponse apiResponse = jokeService.convert("{\"type\":\"general\"," +
                "\"setup\":\"How do you tell the difference between a crocodile and an alligator?\"," +
                "\"punchline\":\"You will see one later and one in a while.\",\"id\":132}");

        // then
        Assertions.assertNotNull(apiResponse, "API response is null");
    }

    @Test
    void randomJoke() {
        // given
        JokeService jokeService = new JokeService();

        // when
        JokeApiResponse apiResponse = jokeService.randomJoke();

        // then
        Assertions.assertNotNull(apiResponse, "API response is null");
    }

    @Test
    void speakJoke() {
        // given
        JokeService jokeService = new JokeService();

        // when
        boolean jokeSpoken = jokeService.speakJoke("This is a joke!");

        // then
        Assertions.assertTrue(jokeSpoken, "Joke has not be spoken");
    }
}