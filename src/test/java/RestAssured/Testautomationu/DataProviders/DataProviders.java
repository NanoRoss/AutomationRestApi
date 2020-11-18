package RestAssured.Testautomationu.DataProviders;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "data-provider-ZipCodes")    //Genero el DataProvider
    public static Object[][] zipCodesAndPlaces() {
        return new Object[][] {                       //Retorna una Matriz de Objetos
                { "us", "90210", "Beverly Hills" },
                { "us", "12345", "Schenectady" },
                { "ca", "B2R", "Waverley"}
        };
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////








    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
