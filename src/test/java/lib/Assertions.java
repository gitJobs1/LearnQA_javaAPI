package lib;

import io.restassured.response.Response;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Assertions {
    public static void assertJsonByName(Response response, String name, int expectedValue) {
        response.then().assertThat().body("$", hasKey(name));
        int value = response.jsonPath().getInt(name);
        assertEquals(expectedValue, value, "JSON value is not equals to expected value");
    }

    public static void assertJsonByName(Response response, String name, String expectedValue) {
        response.then().assertThat().body("$", hasKey(name));
        String value = response.jsonPath().getString(name);
        assertEquals(expectedValue, value, "JSON value is not equals to expected value");
    }

    public static void assertResponseTextEquals(Response response, String expectedAnswer) {
        assertEquals(
                expectedAnswer,
                response.asString(),
                "Response text is not as expected"
        );
    }

    public static void assertResponseStatuscodeEquals(Response response, int expectedStatuscode) {
        assertEquals(
                expectedStatuscode,
                response.statusCode(),
                "Response Statuscode is not as expected"
        );
          }
    public static void assertJsonHasField(Response response, String expectedFieldName) {
        response.then().assertThat().body("$",hasKey(expectedFieldName));
    }

    public static void assertJsonHasFields(Response response, String[] expectedFieldNames){
        for(String expectedFieldName : expectedFieldNames){
            Assertions.assertJsonHasNotField(response, expectedFieldName);
        }
    }

    public static void assertJsonHasNotField(Response response,String unexpectedFieldName){
        response.then().assertThat().body("$",not(hasKey(unexpectedFieldName)));
    }
}
