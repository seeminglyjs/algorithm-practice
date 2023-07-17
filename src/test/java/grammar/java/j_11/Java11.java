package grammar.java.j_11;


import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.hamcrest.Matchers.is;

public class Java11 { // String ends with?

    //================================================================
    //String Method New Features
    //================================================================
    @Test
    public void whenRepeatStringTwice_thenGetStringTwice() {
        String output = "La ".repeat(2) + "Land";
        System.out.println(output);
        MatcherAssert.assertThat(output, Matchers.is("La La Land"));
    }

    @Test
    public void whenStripString_thenReturnStringWithoutWhitespaces() {
        MatcherAssert.assertThat("\n\t  hello   \u2005".strip(), Matchers.is("hello"));
        //strip() 인스턴스 메서드는 선행 및 후행 공백이 모두 제거된 문자열을 반환합니다.
    }

    @Test
    public void whenTrimAdvanceString_thenReturnStringWithWhitespaces() {
        MatcherAssert.assertThat("\n\t  hello   \u2005".trim(), Matchers.is("hello   \u2005"));
        //trim 은   는 제거하지 못함
    }

    @Test
    public void whenBlankString_thenReturnTrue() {
        String input = "\n\t\u2005  ";
        MatcherAssert.assertThat(input.isBlank(), Matchers.is(true));
        //strip() 은 공백을 제거한 문자열을 리턴하지만 isBlank 는 공백만 있는지 여부를 체크해서 리턴한다.

        String input2 = "\n\t\u2005  test";
        MatcherAssert.assertThat(input2.isBlank(), Matchers.is(false));
        //공백이 아닌 문자열이 포함되어서 false 를 리턴한다.
    }

    @Test
    public void whenMultilineString_thenReturnNonEmptyLineCount() {
        String multilineStr = "This is\n \n a multiline\n string.";

        long lineCount = multilineStr.lines()
                .filter(line -> !line.isBlank())
                .count();
        //line 는 줄바꿈 문자 기준으로 split 해서 Stream 을 리턴함

        List<String> arr = multilineStr.lines().toList();
        for (String s : arr) {
            System.out.println(s);
        }

        MatcherAssert.assertThat(lineCount, Matchers.is(3L));
    }
    //================================================================


    @Test
    public void whenWriteStringToFile_thenReadStringFromFile() throws IOException {
        Path tempDir = Files.createTempDirectory("tempDir");
        Path filePath = Files.writeString(Files.createTempFile(tempDir, "demo", ".txt"), "Sample text");
        String fileContent = Files.readString(filePath);
        //파일을 쓰고 읽는 부분이 간소화 되었다.
        MatcherAssert.assertThat(fileContent, Matchers.is("Sample text"));
    }


}
