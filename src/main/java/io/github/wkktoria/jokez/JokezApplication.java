package io.github.wkktoria.jokez;

import io.github.wkktoria.jokez.api.JokeApiResponse;
import io.github.wkktoria.jokez.controller.JokeController;
import io.github.wkktoria.jokez.model.Joke;
import io.github.wkktoria.jokez.service.JokeService;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JokezApplication extends Application {
    private final JokeService jokeService = new JokeService();
    private final JokeController jokeController = new JokeController(jokeService);

    public static void main(String[] args) {
        Application.launch(args);
    }

    private Joke getJoke() {
        JokeApiResponse apiResponse = jokeController.randomJoke();
        String setup = apiResponse.getSetup();
        String punchline = apiResponse.getPunchline();

        return new Joke(setup, punchline);
    }

    private void speakJoke(final String joke) {
        jokeController.speakJoke(joke);
    }

    @Override
    public void start(final Stage stage) throws Exception {
        stage.setTitle("Jokez");

        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(10);

        HBox buttons = new HBox();
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);

        Label setupLabel = new Label("Get a random joke!");
        Label punchlineLabel = new Label("");
        Button randomJokeButton = new Button("Random joke");
        Button speakJokeButton = new Button("Speak joke");

        randomJokeButton.setOnAction(actionEvent -> {
            Joke joke = getJoke();
            setupLabel.setText(joke.getSetup());
            punchlineLabel.setText(joke.getPunchline());
        });

        speakJokeButton.setOnAction(actionEvent -> {
            String setup = setupLabel.getText();
            String punchline = punchlineLabel.getText();

            if ((setup == null || setup.isEmpty()) || (punchline == null || punchline.isEmpty())) {
                return;
            }

            speakJoke(setup + "\n" + punchline);
        });

        buttons.getChildren().addAll(randomJokeButton, speakJokeButton);
        layout.getChildren().addAll(setupLabel, punchlineLabel, buttons);

        Scene scene = new Scene(layout, 600, 200);

        stage.setScene(scene);
        stage.show();
    }
}
