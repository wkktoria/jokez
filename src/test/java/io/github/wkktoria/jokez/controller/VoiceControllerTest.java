package io.github.wkktoria.jokez.controller;

import org.junit.jupiter.api.Test;

class VoiceControllerTest {
    @Test
    void speak() {
        // given
        final VoiceController voiceController = new VoiceController();

        // when
        voiceController.speak("This is a test.");

        // then
    }
}