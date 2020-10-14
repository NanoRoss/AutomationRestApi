package Requests;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;


public class Requests_Suite {

    @Test
    public void Requests_GET_ObtenerListaUsuarios (){  //Obtengo Lista de Usuarios
        //HEADER

        // BODY
        Response resp = given().get("https://reqres.in/api/users?page=2");
        int CodigoRta = resp.statusCode();
        resp.prettyPrint();
        System.out.println("El codigo de rta es: " + CodigoRta);

        given().get("http://dummy.restapiexample.com/api/v1/employees").then().statusCode(200);



    }

    @Test
    public void Requests_GET_ObtenerInfoUsuario (){  //Obtengo Lista de Usuarios
        Response resp = given().get("https://reqres.in/api/users/2");
        int CodigoRta = resp.statusCode();
        resp.prettyPrint();
        System.out.println("El codigo de rta es: " + CodigoRta);

    }



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







}
