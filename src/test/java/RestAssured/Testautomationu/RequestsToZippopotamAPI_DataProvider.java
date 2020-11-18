package RestAssured.Testautomationu;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;



public class RequestsToZippopotamAPI_DataProvider {  //extends DataProviders

    @DataProvider(name = "data-provider-ZipCodes")    //Genero el DataProvider
    public static Object[][] zipCodesAndPlaces() {
        return new Object[][] {                       //Retorna una Matriz de Objetos
                { "us", "90210", "Beverly Hills" },
                { "us", "12345", "Schenectady" },
                { "ca", "B2R", "Waverley"}
        };
    }

    @Test(dataProvider = "data-provider-ZipCodes")
    public void requestZipCodesFromCollection_checkPlaceNameInResponseBody_expectSpecifiedPlaceName(String countryCode, String zipCode, String expectedPlaceName) {

        System.out.println(countryCode);
        System.out.println(zipCode);
        System.out.println(expectedPlaceName);

        given().
                pathParam("countryCode", countryCode).
                pathParam("zipCode", zipCode).
        when().
                get("http://zippopotam.us/{countryCode}/{zipCode}").  //http://zippopotam.us/us/90210 paso los dos parametros.
        then().
                assertThat().
                body("places[0].'place name'", equalTo(expectedPlaceName));

    }




}
