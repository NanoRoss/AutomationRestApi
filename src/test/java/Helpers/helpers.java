package Helpers;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class helpers {


    public void GetToURI_PrintResponseANDstatusCode(String URI){
        Response resp = given().get(URI);
        int CodigoRta = resp.statusCode();
        resp.prettyPrint();
        System.out.println("El codigo de rta es: " + CodigoRta);
    }

    public String generateStringFromResource(String path) throws IOException {

        return new String(Files.readAllBytes(Paths.get(path)));

    }



    private boolean validateSchema(Response resp, String jsonSchemaPath) {
        boolean isCheckOk = true;
        try {
            JsonSchemaValidator validator = JsonSchemaValidator.matchesJsonSchemaInClasspath(jsonSchemaPath);
            resp.then().assertThat().body(validator);
        } catch (Exception oEx) {
            isCheckOk = false;
        }
        return isCheckOk;
    }

}
