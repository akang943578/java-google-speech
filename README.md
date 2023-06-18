A java package to translate text using Google Speech API for free.

refer: https://www.javatips.net/api/java-speech-api-master/src/main/java/com/dark.programs/speech/translator/GoogleTranslate.java


## Usage
1. Add this package in your pom.xml `dependencies` section
   * You can find the latest version in [Maven Central Repository](https://search.maven.org/search?q=g:io.github.akang943578%20AND%20a:java-google-speech)
```xml
    <dependency>
        <groupId>io.github.akang943578</groupId>
        <artifactId>java-google-speech</artifactId>
        <version>LATEST</version>
    </dependency>
```
2. Use it in your code
```java
import com.dark.programs.speech.translator.GoogleTranslate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

public class GoogleTranslateTest {

   @Test
   public void test_withNoProxy() throws IOException {
      String rawInput = "你好啊";
      String sourceLang = GoogleTranslate.detectLanguage(rawInput);
      Assertions.assertEquals("zh-CN", sourceLang);
      String translatedInput = GoogleTranslate.translate(sourceLang, "en", "你好啊");
      Assertions.assertEquals("hello", translatedInput);
   }

   @Test
   public void testDetect_withHttpProxy() throws IOException {
      // set HTTP proxy
      GoogleTranslate.setProxy(new Proxy(Proxy.Type.HTTP,
              new InetSocketAddress("192.168.31.1", 7890)));
      // set username/password if proxy needs authentication
      GoogleTranslate.setAuth("authUser", "authPassword");

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
   public void testTranslate_withSocksProxy() throws IOException {
      // set SOCKS proxy
      GoogleTranslate.setProxy(new Proxy(Proxy.Type.SOCKS,
              new InetSocketAddress("192.168.31.1", 7890)));
      // set username/password if proxy needs authentication
      GoogleTranslate.setAuth("authUser", "authPassword");

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
```