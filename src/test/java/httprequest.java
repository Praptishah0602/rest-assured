
   /* given()
        content-type,set cookies,add auth,add param,set header info etc..
when()
            get,post,put,delete
then()
                validate status code,extract response,extract headers cookies &response body
*/


   import io.restassured.RestAssured;
   import io.restassured.response.Response;
   import org.testng.annotations.Test;

   public class httprequest {

       @Test
       public void checkAPI() {

           RestAssured.baseURI = "https://reqres.in/api";

           Response response = RestAssured
                   .given()
                   .when()
                   .get("/users/2");

           System.out.println("Status Code: " + response.getStatusCode());
           System.out.println("Response Body: " + response.asPrettyString());
       }
   }
