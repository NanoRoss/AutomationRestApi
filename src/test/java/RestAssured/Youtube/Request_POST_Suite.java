package RestAssured.Youtube;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;


public class Request_POST_Suite {

    @Test
    public void test_1_post(){

        JSONObject requestBody = new JSONObject();
        requestBody.put("Nano","it");
        requestBody.put("Agus","counter");

        baseURI = "https://reqres.in/api/";


        //Dado 1 body con un Json para enviar en el request.
        given().
                header("Content-Typesd","application/json").
                contentType(ContentType.JSON).  //Especifica el tipo de data que enviamos en el bodyRequest.
                accept(ContentType.JSON).       //Especifica el tipo de data que nos retornan en el bodyResponse.
                body(requestBody.toJSONString()).
                log().all().   //Imprimo el Request Body.

        //Cuando hacemos un Post en la URL
        when().post("/users").
        //Entonces espero codigo 201 como respuesta valida, else fail.
        then().statusCode(201)
                .log().all();  //Imprimo el Response Body.



    }

    @Test
    public void test_POST_MyApi(){

        JSONObject requestBody = new JSONObject();
        requestBody.put("firstName","Tomas");
        requestBody.put("lastname","Garcia");
        requestBody.put("Subjectid","3");
        requestBody.put("id","3");

        baseURI = "http://localhost:3000/";


        //Dado 1 body con un Json para enviar en el request.
        given().
                header("Content-Typesd","application/json").
                contentType(ContentType.JSON).  //Especifica el tipo de data que enviamos en el bodyRequest.
                accept(ContentType.JSON).       //Especifica el tipo de data que nos retornan en el bodyResponse.
                body(requestBody.toJSONString()).
                log().all().   //Imprimo el Request Body.


                when()   //Cuando hacemos un Post en la URL
                .post("/users"). //Entonces espero codigo 201 como respuesta valida, else fail.
                then()
                .log().all();  //Impr   imo el Response Body.


    }






}
