package RestAssured.Testautomationu.Pojo_Clasess;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.response.Response;

public class Deserialization_Empleado {



    @Test
    public  void NO_Deserialization_EmpleadoRequest(){

        //////////////////////////////////////////////////////////////////////////// 1 Forma:

//        Response resp = given().get("http://localhost:3000/Empleado");
//        assertThat(resp.getBody().jsonPath().get("puesto"), equalTo("QA"));

        //////////////////////////////////////////////////////////////////////////// 2 Forma:
        given().
                header("Content-Typesd","application/json").
                contentType(ContentType.JSON).  //Especifica el tipo de data que enviamos en el bodyRequest.
                accept(ContentType.JSON).       //Especifica el tipo de data que nos retornan en el bodyResponse.
        when().
                get("http://localhost:3000/Empleado").
        then().
                assertThat().
                contentType(ContentType.JSON).
                body("'puesto'", equalTo("QA")).
                log().body();

    }

    @Test
    public  void Deserialization_EmpleadoRequest(){

        Deserialization_Empleado_Class deserialization_empleado_class =
                given().
                when().
                        get("http://localhost:3000/Empleado").
                        as(Deserialization_Empleado_Class.class);  //De-serialization : Convierto rta Json a Java Object para laburarlo mas comodo.
        Assert.assertEquals("QA", deserialization_empleado_class.getPuesto());   //Genero el Assert directamente al Objeto generado del json recibido.

    }



}
