package io.github.wkktoria.jokez.controller;

import io.github.wkktoria.jokez.service.VoiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VoiceController {
    private static final Logger LOGGER = LoggerFactory.getLogger(VoiceController.class);

    private final VoiceService voiceService;

    public VoiceController() {
        voiceService = new VoiceService();
    }

    public VoiceController(final VoiceService voiceService) {
        this.voiceService = voiceService;
    }

    public void speak(final String text) {
        LOGGER.info("speak(text = {})", text);

        if (voiceService.speak(text)) {
            LOGGER.info("Speaking successful");
        } else {
            LOGGER.info("Speaking failed");
        }
    }
}
