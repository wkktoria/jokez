package io.github.wkktoria.jokez.service;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VoiceService {
    private static final Logger LOGGER = LoggerFactory.getLogger(VoiceService.class);

    public boolean speak(final String text) {
        LOGGER.info("speak(text = {})", text);

        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        Voice voice = VoiceManager.getInstance().getVoice("kevin");
        voice.allocate();

        try {
            voice.speak(text);
            LOGGER.info("speak(...) = true");
            return true;
        } catch (Exception e) {
            LOGGER.error("Unable to speak", e);
        }

        LOGGER.info("speak(...) = false");
        return false;
    }
}
