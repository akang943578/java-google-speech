A java package to translate text using Google Speech API for free.

refer: https://www.javatips.net/api/java-speech-api-master/src/main/java/com/dark.programs/speech/translator/GoogleTranslate.java


## Usage
1. Add this repository in your pom.xml 'repositories' section
```xml
  <repositories>
    <repository>
      <id>akang943578-maven-repo</id>
      <url>https://raw.githubusercontent.com/akang943578/maven-repo/master/repository</url>
    </repository>
  </repositories>
```
2. Add this package in your pom.xml `dependencies` section
```xml
    <dependency>
      <groupId>com.dark.programs</groupId>
      <artifactId>java-google-speech</artifactId>
      <version>1.0.0</version>
    </dependency>
```
3. Use it in your code
```java
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
```