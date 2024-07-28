package io.github.wkktoria.jokez.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class VoiceServiceTest {
    @Test
    void speak() {
        // given
        final VoiceService voiceService = new VoiceService();

        // when
        boolean result = voiceService.speak("This is a test.");

        // then
        Assertions.assertTrue(result, "Text has not been spoken");
    }
}