package RestAssured.Testautomationu;

import RestAssured.Testautomationu.DataProviders.DataProviders;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RequestsToZippopotamAPI_Extract  {

    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;

    @BeforeClass     //Preparo Pre-Condiciones Comunes a todos los tests.
    public static void Request_Response_Specification() {

        requestSpec = new RequestSpecBuilder(). //PreCondiciones Comunes
                setBaseUri("http://api.zippopotam.us").
                build();

        responseSpec = new ResponseSpecBuilder().  //PostCondiciones Comunes
                expectStatusCode(200).
                expectContentType(ContentType.JSON).
                build();
    }


    @Test()
    public void requestZipCodesFromCollection_Extract_SpecifiedPlaceName() {

        String placeName =

        given().
                spec(requestSpec). // Seteo precondiciones comunes.
        when().
                get("us/90210").
        then().
                extract().
                path("places[0].'place name'");

        Assert.assertEquals(placeName,"Beverly Hills");

    }
}

