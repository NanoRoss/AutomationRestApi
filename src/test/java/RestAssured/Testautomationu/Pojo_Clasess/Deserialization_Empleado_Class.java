
package RestAssured.Testautomationu.Pojo_Clasess;

//
//[
//        {
//        "id": 1,
//        "puesto": "QA",
//        "sueldo": "110000"
//        }
//        ]
//

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "puesto",
        "sueldo"
})

public class Deserialization_Empleado_Class {

    @JsonProperty("id")
    private int id;
    @JsonProperty("puesto")
    private String puesto;
    @JsonProperty("sueldo")
    private String sueldo;

    public Deserialization_Empleado_Class(int id, String puesto, String sueldo) {
        this.id = id;
        this.puesto = puesto;
        this.sueldo = sueldo;
    }

/////////////////////////Setters
    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("puesto")
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @JsonProperty("sueldo")
    public void setSueldo(String sueldo) {
        this.sueldo = sueldo;
    }


/////////////////////////Getters
    @JsonProperty("id")
    public int getId() {
        return id;
    }

    @JsonProperty("puesto")
    public String getPuesto() {
        return puesto;
    }

    @JsonProperty("sueldo")
    public String getSueldo() {
        return sueldo;
    }

}
