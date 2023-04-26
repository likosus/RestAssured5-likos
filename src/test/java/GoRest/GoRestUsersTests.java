package GoRest;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GoRestUsersTests {


    @Test
    public void createUser(){
      // POST https://gorest.co.in/public/v2/users
      // "Authorization: Bearer 523891d26e103bab0089022d20f1820be2999a7ad693304f560132559a2a152d"
      // {"name":"{{$randomFullName}}", "gender":"male", "email":"{{$randomEmail}}", "status":"active"}

      int userID=
      given()
              .header("Authorization","Bearer 523891d26e103bab0089022d20f1820be2999a7ad693304f560132559a2a152d")
              .contentType(ContentType.JSON) // gönderilecek data JSON
              .body("{\"name\":\"ismet temur1\", \"gender\":\"male\", \"email\":\"ismet1@gmail.com\", \"status\":\"active\"}")
              .log().uri()
              .log().body()

              .when()
              .post("https://gorest.co.in/public/v2/users")

              .then()
              .statusCode(201)
              .contentType(ContentType.JSON)
              .extract().path("id")
      ;
    }

    @Test
    public void getUserByID(){

    }

    @Test
    public void updateUser(){

    }

    @Test
    public void deleteUser(){

    }

    @Test
    public void deleteUserNegative(){

    }



}
