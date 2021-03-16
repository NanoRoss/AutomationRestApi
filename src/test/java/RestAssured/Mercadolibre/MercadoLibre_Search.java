package RestAssured.Mercadolibre;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class MercadoLibre_Search {

    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;

    @BeforeClass     //Preparo Pre-Condiciones Comunes a todos los tests.
    public static void Request_Response_Specification() {

        requestSpec = new RequestSpecBuilder(). //PreCondiciones Comunes
                setBaseUri("https://api.mercadolibre.com/sites/MLA").
                build();

        responseSpec = new ResponseSpecBuilder().  //PostCondiciones Comunes
                expectStatusCode(200).
                expectContentType(ContentType.JSON).
                build();
    }

    @Test()
    public void requestZipCodesFromCollection_Extract_SpecifiedPlaceName() {

                given().
                        spec(requestSpec). // Seteo precondiciones comunes.
                when().
                        get("search?q=Iphone").
                then().
                        log().all()
                        .body("results[0].'title'", equalTo("iPhone 11 64 Gb Negro"));
                        //.body("results.findAll{it.title=='iPhone 11 64 Gb Negro'}.size()", equalTo(15));  //Busca en todos los registros title
                        //.body("results[0].seller.id", equalTo(110242209));

    }




}
