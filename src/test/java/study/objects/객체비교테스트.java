package study.objects;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;

public class 객체비교테스트 {

    @Test
    public void stringTest1(){
        String name1 = "hh";
        String name2 = "hh";
        MatcherAssert.assertThat("(name1 == name2) != true",name1 == name2, is(true));
    }

}
