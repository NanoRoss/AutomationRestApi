package Requests;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;


public class Request_PUT_Suite {



    @Test
    public void test_PutMyApi(){

        JSONObject requestBody = new JSONObject();
        requestBody.put("firstName","Agus_Update");
        requestBody.put("lastname","Garcia_Update");
        requestBody.put("Subjectid","2_Update");
        requestBody.put("id","2");

        baseURI = "http://localhost:3000/";


        //Dado 1 body con un Json para enviar en el request.
        given().
                header("Content-Typesd","application/json").
                contentType(ContentType.JSON).  //Especifica el tipo de data que enviamos en el bodyRequest.
                accept(ContentType.JSON).       //Especifica el tipo de data que nos retornan en el bodyResponse.
                body(requestBody.toJSONString()).
                log().all().   //Imprimo el Request Body.


                when()   //Cuando hacemos un Post en la URL
                .put("/users/2"). //Entonces espero codigo 201 como respuesta valida, else fail.
                then()
                .statusCode(200)
                .log().all();  //Impr   imo el Response Body.



    }


}
