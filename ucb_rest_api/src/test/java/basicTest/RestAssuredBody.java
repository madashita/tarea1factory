
package basicTest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class RestAssuredBasic {

    /*
      given()----> configuracion
      when() ----> request action --> URL ---> Method
      then() ----> verificaciones
     */

    @Test
    public void createProject(){
        given()
                .header("Authorization","Basic bWFkYWlAdWNiMjAyMS5jb206MTIzNDU=")
                .body("{\n" +
                        "  \"Content\":\"UCB_Madai\",\n" +
                        "  \"Icon\":\"5\"\n" +
                        "}")
                .log()
                .all()
                .when()
                .post("http://todo.ly/api/projects.json")
                .then()
                .log()
                .all();


    }
    @Test
    public void createProject2(){
        given()
                .auth()
                .preemptive()
                .basic("usb@ucb2021.com","12345")
                .body("{\n" +
                        "  \"Content\":\"UCB_Madai_REST\",\n" +
                        "  \"Icon\":\"5\"\n" +
                        "}")
                .log()
                .all()
                .when()
                .post("http://todo.ly/api/projects.json")
                .then()
                .log()
                .all();


    }
}
