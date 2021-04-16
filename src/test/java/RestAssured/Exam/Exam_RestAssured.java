package RestAssured.Exam;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import Helpers.helpers;


//https://braulio-batista.medium.com/json-schema-validation-with-rest-assured-f5adb4dc1bda

public class Exam_RestAssured {


    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;

    @BeforeClass     //Preparo Pre-Condiciones Comunes a todos los tests.
    public static void Request_Response_Specification() {

        requestSpec = new RequestSpecBuilder(). //PreCondiciones Comunes
                setBaseUri("https://petstore.swagger.io/v2/").
                build();

        responseSpec = new ResponseSpecBuilder().  //PostCondiciones Comunes
                expectStatusCode(200).
                build();
    }



    @Test()
    public void AddPet_POST() throws IOException {

        System.out.println("------------------AddPet_POST:");

        helpers helpers = new helpers();
        String jsonBody = helpers.generateStringFromResource("src/test/resources/Jsons_Files/RestAssured_AddPet_POST.json");

        given().
                contentType(ContentType.JSON).  //Especifica el tipo de data que enviamos en el bodyRequest.
                spec(requestSpec). // Seteo precondiciones comunes.
                header("Content-Type","application/json").
                and().
                body(jsonBody).
                log().all().   //Imprimo el Request Body.
        when().
                post("/pet").
        then().
                log().all().
                assertThat().
                contentType(ContentType.JSON).  // Valido el tipo de ContentType en el Response Header.
                spec(responseSpec). // Seteo postcondiciones comunes (Validaciones)
                body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schemas/RestAssured_AddPet_POST-Schema.json"));
    }




    @Test()
    public void foundPetById_GET() throws IOException {

        System.out.println("------------------foundPetById_GET:");


        given().
                contentType(ContentType.JSON).  //Especifica el tipo de data que enviamos en el bodyRequest.
                spec(requestSpec). // Seteo precondiciones comunes.
                header("Content-Type","application/json").
                and().
                log().all().
        when().
                get("/pet/9222999990497623468").
        then().
                log().all().
                assertThat().
                spec(responseSpec).
                body("tags[0].'name'", equalTo("tagName")).
                body("tags[0].'id'", equalTo(0)).
                body("category.'id'", equalTo(88)).
                body("name", equalTo("NanoEXAM-NanoEXAM")).
                body("photoUrls[0]", equalTo("fotourl"));
    }


    @Test()
    public void editPet_PUT() throws IOException {

        System.out.println("------------------editPet_PUT:");

        helpers helpers = new helpers();
        String jsonBody = helpers.generateStringFromResource("src/test/resources/Jsons_Files/RestAssured_UpdatePet_PUT.json");

        given().
                contentType(ContentType.JSON).  //Especifica el tipo de data que enviamos en el bodyRequest.
                spec(requestSpec). // Seteo precondiciones comunes.
                header("Content-Type","application/json").
                and().
        body(jsonBody).
                log().all().   //Imprimo el Request Body.
        when().
                put("/pet").
        then().
                log().all(). //Imprimo el Response Body.
                assertThat().
                spec(responseSpec). // Seteo postcondiciones comunes
                body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schemas/RestAssured_UpdatePet_PUT-Schema.json"));
    }

    @Test()
    public void postStoreOrder_POST() throws IOException {

        System.out.println("------------------postStoreOrder_POST:");

        helpers helpers = new helpers();
        String jsonBody = helpers.generateStringFromResource("src/test/resources/Jsons_Files/[ExamRestAssured]-postStoreOrder_POST.json");

        given().
                contentType(ContentType.JSON).  //Especifica el tipo de data que enviamos en el bodyRequest.
                spec(requestSpec). // Seteo precondiciones comunes.
                header("Content-Type","application/json").
                and().
                body(jsonBody).
                log().all().   //Imprimo el Request Body.
        when().
                post("store/order").
        then().
                log().all(). //Imprimo el Response Body.
                assertThat().
                spec(responseSpec); // Seteo postcondiciones comunes

    }
}
