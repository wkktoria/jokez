package io.github.wkktoria.jokez.service;

import com.google.gson.Gson;
import io.github.wkktoria.jokez.api.JokeApiResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class JokeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(JokeService.class);
    private static final String API_URL = "https://official-joke-api.appspot.com/jokes/random";

    private final OkHttpClient client = new OkHttpClient();

    public JokeApiResponse randomJoke() {
        LOGGER.info("randomJoke()");

        try {
            String responseBody = getResponseBody(API_URL);
            JokeApiResponse apiResponse = convert(responseBody);
            LOGGER.info("randomJoke(...) = {}", apiResponse);
            return apiResponse;
        } catch (IOException e) {
            LOGGER.error("Unable to connect to external API.", e);
        }

        LOGGER.info("randomJoke(...) = null");
        return null;
    }

    public String getResponseBody(final String url) throws IOException {
        LOGGER.info("getResponseBody(url = {})", url);
        Request request = new Request.Builder().url(url).build();

        try (Response response = client.newCall(request).execute()) {
            String body = response.body() != null ? response.body().string() : null;
            LOGGER.info("getResponseBody(...) = {}", body);
            return body;
        }
    }

    public JokeApiResponse convert(final String body) {
        LOGGER.info("convert(body = {})", body);
        Gson gson = new Gson();
        JokeApiResponse apiResponse = gson.fromJson(body, JokeApiResponse.class);
        LOGGER.info("convert(...) = {}", apiResponse);
        return apiResponse;
    }
}
