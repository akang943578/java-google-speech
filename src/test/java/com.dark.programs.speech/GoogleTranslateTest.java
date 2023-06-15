package com.dark.programs.speech;

import com.dark.programs.speech.translator.GoogleTranslate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class GoogleTranslateTest {

    @Test
    public void testDetect() throws IOException {
        String sourceLang = GoogleTranslate.detectLanguage("How are you today?");
        Assertions.assertEquals("en", sourceLang);

        sourceLang = GoogleTranslate.detectLanguage("あなたの名前は何ですか");
        Assertions.assertEquals("ja", sourceLang);

        sourceLang = GoogleTranslate.detectLanguage("누구세요");
        Assertions.assertEquals("ko", sourceLang);

        sourceLang = GoogleTranslate.detectLanguage("今天吃啥饭");
        Assertions.assertEquals("zh-CN", sourceLang);
    }

    @Test
    public void testTranslate() throws IOException {
        String rawInput = "你好啊";
        String sourceLang = GoogleTranslate.detectLanguage(rawInput);
        Assertions.assertEquals("zh-CN", sourceLang);
        String translatedInput = GoogleTranslate.translate(sourceLang, "en", "你好啊");
        Assertions.assertEquals("hello", translatedInput);

        String rawResponse = "Hi, how are you?";
        String translatedResponse = GoogleTranslate.translate("en", sourceLang, rawResponse);
        Assertions.assertEquals("你好你好吗？", translatedResponse);
    }
}
