package RestAssured.Testautomationu;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class xml_Response {

    ////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////

    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;

    @BeforeClass     //Preparo Pre-Condiciones Comunes a todos los tests.
    public static void Request_Response_Specification() {

        requestSpec = new RequestSpecBuilder(). //PreCondiciones Comunes
                setBaseUri("http://api.openweathermap.org/data/2.5").
                build();

        responseSpec = new ResponseSpecBuilder().  //PostCondiciones Comunes
                expectStatusCode(200).
                expectContentType(ContentType.JSON).
                build();
    }

    ////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////

    @Test()
    public void requestWeatherFromCity_xmlResponse() {

        given().
                spec(requestSpec). // Seteo precondiciones comunes.
                pathParam("City", "Rosario").
        when().
                get("weather?q={City}&APPID=ddccc4939be8cdb7a8ae6350f952bdc9&mode=xml").
        then().
                // spec(responseSpec); // Seteo postcondiciones comunes.
                assertThat().
                log().body().
                contentType(ContentType.XML).
                statusCode(200).
                body("current.city.name", equalTo("Rosario"));




    }




}
