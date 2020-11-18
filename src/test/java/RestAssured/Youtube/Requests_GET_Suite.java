package RestAssured.Youtube;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;


public class Requests_GET_Suite {

    @Test
    public void GETRequests_ObtenerListaUsuarios (){  //Obtengo Lista de Usuarios
        //HEADER

        // BODY
        Response resp = given().get("https://reqres.in/api/users?page=2");
        int CodigoRta = resp.statusCode();
        resp.prettyPrint();
        System.out.println("El codigo de rta es: " + CodigoRta);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void GETRequests_ValidarResponseBody_equalTo (){


        given().get("https://reqres.in/api/users?page=2").

                then().
                statusCode(200).
                body(                                                                          //Valido un elemento del array del body especifico
                        "data.email[0]",equalTo("michael.lawson@reqres.in"),
                        "data.first_name[0]",equalTo("Michael"),
                        "data.last_name[0]",equalTo("Lawson")).
                    log().all();

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void GETRequests_ValidarResponseBody_hasItems (){


        given().get("https://reqres.in/api/users?page=2").

                then().
                statusCode(200).
                body("data.first_name", hasItems("Michael","Tobias","Rachel")).  //Valido en todos los data.first_name existan esos valores.
                log().all();

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void GETRequests_ValidarResponseBody_WithParameters_ContentType (){


        given().get("https://reqres.in/api/users?page=2").

                then().
                statusCode(200).
                body("data.first_name", hasItems("Michael","Tobias","Rachel")).  //Valido en todos los data.first_name existan esos valores.
                log().all();

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void Requests_Post_CrearUsuario_1(){  // Creo un Usuario pasando parametros con formParam
        //HEADER
        // BODY
        Response resp = given()
                .formParam("name","nano")
                .formParam("salary","5000")
                .formParam("age","33")
                .post("http://dummy.restapiexample.com/api/v1/create");
        int CodigoRta = resp.statusCode();
        resp.prettyPrint();

        System.out.println("El codigo de rta es: " + CodigoRta);

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void Requests_Post_CrearUsuario_2(){  // Creo un Usuario pasando parametros desde archivo JSON
        //HEADER

        // BODY
        Response resp = given().body(new File("D:\\Dropbox\\WORK\\QA-TESTING\\Automation\\API\\AutomationRestApi\\src\\test\\java\\Requests\\Jsons\\PostTest_CrearUsuario.json"))
                .contentType(ContentType.JSON)
                .post("\thttp://dummy.restapiexample.com/api/v1/create");
        int CodigoRta = resp.statusCode();
        resp.prettyPrint();
        System.out.println("El codigo de rta es: " + CodigoRta);


        //RESPONSE

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void Requests_Delete_BorrarUsuario(){  // Creo un Usuario pasando parametros desde archivo JSON
        //HEADER

        // BODY
        Response resp = given().delete("http://dummy.restapiexample.com/api/v1/delete/4925");
        int CodigoRta = resp.statusCode();
        resp.prettyPrint();
        System.out.println("El codigo de rta es: " + CodigoRta);


        //RESPONSE

    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void Requests_Update_ActualizarUsuario(){
        //HEADER

        // BODY
        Response resp = given().body(new File("D:\\Dropbox\\WORK\\QA-TESTING\\Automation\\API\\AutomationRestApi\\src\\test\\java\\Requests\\Jsons\\UpdateTest_UpdateUsuario.json"))
                .contentType(ContentType.JSON)
                .put("http://dummy.restapiexample.com/api/v1/update/35");
        int CodigoRta = resp.statusCode();
        resp.prettyPrint();
        System.out.println("El codigo de rta es: " + CodigoRta);


        //RESPONSE

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////







}
