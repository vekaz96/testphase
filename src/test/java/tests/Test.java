package tests;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

public class Test {

    static String baseUrl = "http://localhost:3000";

    @org.junit.Test
    public void positiveTest1() {
        when().
                get(baseUrl + "/houses?price_gte=100000&price_lte=700000&city=New York").
                then().
                statusCode(200).
                body("size()", is(2)).
                body("[0].city", equalTo("New York"));

    }

    @org.junit.Test
    public void positiveTest2() {
        when().
                get(baseUrl + "/houses?price_gte=200000&price_lte=500000&city=New York").
                then().
                statusCode(200).
                body("size()", is(0));

    }

    @org.junit.Test
    public void positiveTest3() {
        when().
                get(baseUrl + "/houses?price_gte=450000&price_lte=666000&city=Austin").
                then().
                statusCode(200).
                body("size()", greaterThan(0)).
                body("[0].city", equalTo("Austin"));

    }
}