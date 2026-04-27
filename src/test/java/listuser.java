import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

import java.util.HashMap;


public class listuser {
    int bookingid;
@Test(priority = 1)
    void check()
    {
        given()
            .when()
                .get("https://dummyjson.com/products?page=2")
            .then()
                .statusCode(200)
                .body("products[0].id",equalTo(1))
                .log().all();
    }
@Test(priority = 2)
void checkbooking()
{
    HashMap data= new HashMap();
    data.put("firstname", "Jim");
    data.put("lastname","Brown");

    bookingid=given()// use for udating the requess
            .contentType("application/json").body(data)
    .when()
        .post("https://restful-booker.herokuapp.com/booking")
            .jsonPath().getInt("bookingid");
            //.then()
            //.statusCode(200)
            //.log().all();
}
@Test(priority = 3)
void updatebooking()
{
    HashMap data= new HashMap();
    data.put("firstname", "Jim");
    data.put("lastname","kio");

    given()
            .contentType("application/json").body(data)

            .when()
            .put("https://restful-booker.herokuapp.com/booking/"+ bookingid)

            .then()
            .statusCode(201)
            .log().all();
}

}
