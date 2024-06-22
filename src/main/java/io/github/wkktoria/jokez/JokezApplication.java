package io.github.wkktoria.jokez;

import io.github.wkktoria.jokez.api.JokeApiResponse;
import io.github.wkktoria.jokez.controller.JokeController;
import io.github.wkktoria.jokez.service.JokeService;

class JokezApplication {
    public static void main(String[] args) {
        JokeService jokeService = new JokeService();
        JokeController jokeController = new JokeController(jokeService);

        JokeApiResponse apiResponse = jokeController.randomJoke();
        String joke = apiResponse.getSetup() + "\n" + apiResponse.getPunchline();
        System.out.println(joke);
        jokeController.speakJoke(joke);
    }
}
