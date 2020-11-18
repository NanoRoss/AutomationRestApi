package RestAssured.Youtube;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Request_DELETE_Suite {

    @Test
    public void test_DeleteMyApi(){


        baseURI = "http://localhost:3000/";

          when()   //Cuando hacemos un Post en la URL
                 .delete("/users/2"). //Entonces espero codigo 201 como respuesta valida, else fail.
          then()
                 .statusCode(200)
                 .log().all();  //Impr   imo el Response Body.

    }

}
