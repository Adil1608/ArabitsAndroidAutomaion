package tests.experiments;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.common.mapper.TypeRef;
import org.testng.annotations.Test;
import java.util.Map;
import java.util.HashMap;

public class apiTest {

    @Test
    public void wikiTest(){
        int perPerson = 10 % 4;
        double perPerson2 = 10.0 / 4;
        System.out.println("perPerson"+ perPerson);
        System.out.println("perPerson"+ perPerson2);

        Map<String,Object> responseBody = null;
        Object id_ = null;
        responseBody = RestAssured
                        .given()
                        .baseUri("https://en.wikipedia.org/api/rest_v1/page/summary/Encyclopedia")
                        .get()
                        .then()
                        .extract()
                        .body()
                        // Extract response as Map<String,Object>
                        .as(new TypeRef<Map<String,Object>>() {});
                        //  To print booking id
                        System.out.println("responseBody : "+responseBody);
                        System.out.println("Booking id is : "+responseBody.get("namespace"));
        id_ = responseBody.get("namespace");
//        HashMap<String, String> hash_map = new HashMap<String, String>();
//        System.out.println("id_ :"+id_.id);

    }
}
