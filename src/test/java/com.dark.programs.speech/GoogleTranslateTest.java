package com.dark.programs.speech;

import com.dark.programs.speech.translator.GoogleTranslate;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class GoogleTranslateTest {

    @Test
    public void testDetect() throws IOException {
        String sourceLang = GoogleTranslate.detectLanguage("How are you today?");
        System.out.println("sourceLang: " + sourceLang);

        sourceLang = GoogleTranslate.detectLanguage("あなたの名前は何ですか");
        System.out.println("sourceLang: " + sourceLang);

        sourceLang = GoogleTranslate.detectLanguage("누구세요");
        System.out.println("sourceLang: " + sourceLang);

        sourceLang = GoogleTranslate.detectLanguage("今天吃啥饭");
        System.out.println("sourceLang: " + sourceLang);
    }

    @Test
    public void test() throws IOException {
        String rawInput = "你好啊";
        System.out.println("rawInput: " + rawInput);
        String sourceLang = GoogleTranslate.detectLanguage("你好啊");
        String translatedInput = GoogleTranslate.translate(sourceLang, "en-US", "你好啊");
        System.out.println("translatedInput: " + translatedInput);

        String rawResponse = "Hi, how are you?";
        System.out.println("rawResponse: " + rawResponse);
        String translatedResponse = GoogleTranslate.translate("en-US", sourceLang, rawResponse);
        System.out.println("translatedResponse: " + translatedResponse);
    }
}
