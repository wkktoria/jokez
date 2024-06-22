package io.github.wkktoria.jokez.model;

public class Joke {
    private String setup;
    private String punchline;

    public Joke(final String setup, final String punchline) {
        this.setup = setup;
        this.punchline = punchline;
    }

    public String getSetup() {
        return setup;
    }

    public String getPunchline() {
        return punchline;
    }
}
