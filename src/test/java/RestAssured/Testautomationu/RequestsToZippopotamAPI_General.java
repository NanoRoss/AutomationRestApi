package RestAssured.Testautomationu;

import Helpers.helpers;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class RequestsToZippopotamAPI_General {  //http://api.zippopotam.us/

    Helpers.helpers helpers = new helpers();


    @Test
    public void Requests_USZipCode_CheckStatusCode(){
        given().log().all().  //Loguea detalles del request
        when().get("http://api.zippopotam.us/us/90210").
        then().assertThat()

                .statusCode(200) // Valido statusCode
                 // Muestro el response Body, .log().all(); Loguea detalles del Response
                .contentType(ContentType.JSON)  // Valido el tipo de ContentType en el Response Header.
                .body("'post code'", equalTo("90210")) //Valido un elemento especifico del Response Body contra un JsonPath (Similar Xpath for html)
                .body("places[0].'place name'", equalTo("Beverly Hills")) //Valido un elemento especifico del Response Body contra un JsonPath: "places[0].'place name'",(Similar Xpath for html)
                .body("'places'", hasSize(1))
                .body("places.'state'" , hasItem("California")); //Valido si en la Lista de Places en State alguno tiene California


 //equalTo(x)  hasitem("Rome")  hassize(3)  not(equalto(x))

//helpers.GetToURI_PrintResponseANDstatusCode("http://api.zippopotam.us/us/90210");
    }



}
