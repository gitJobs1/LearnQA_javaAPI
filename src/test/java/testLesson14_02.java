import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class testLesson14_02 {
    @Test
    public void testHelloWorldLesson14_02(){ //тест
        Response response = RestAssured
                .get("https://playground.learnqa.ru/api/hello" /*"https://playground.learnqa.ru/api/hello"*/)
                .andReturn();

        response.prettyPrint();
    }
}