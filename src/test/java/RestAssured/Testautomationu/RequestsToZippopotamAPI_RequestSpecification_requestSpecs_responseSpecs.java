package RestAssured.Testautomationu;

import RestAssured.Testautomationu.DataProviders.DataProviders;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;




public class RequestsToZippopotamAPI_RequestSpecification_requestSpecs_responseSpecs extends DataProviders {

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



    @Test(dataProvider = "data-provider-ZipCodes")
    public void requestZipCodesFromCollection_checkPlaceNameInResponseBody_expectSpecifiedPlaceName(String countryCode, String zipCode, String expectedPlaceName) {

        given().
                spec(requestSpec). // Seteo precondiciones comunes.
                pathParam("countryCode", countryCode).
                pathParam("zipCode", zipCode).
        when().
                get("{countryCode}/{zipCode}").
        then().
                spec(responseSpec). // Seteo postcondiciones comunes.
                assertThat().
                body("places[0].'place name'", equalTo(expectedPlaceName));

    }


   //https://testautomationu.applitools.com/automating-your-api-tests-with-rest-assured/chapter4.html



}
