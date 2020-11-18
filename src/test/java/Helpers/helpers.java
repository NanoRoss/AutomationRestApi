package Helpers;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class helpers {


    public void GetToURI_PrintResponseANDstatusCode(String URI){
        Response resp = given().get(URI);
        int CodigoRta = resp.statusCode();
        resp.prettyPrint();
        System.out.println("El codigo de rta es: " + CodigoRta);
    }
}
