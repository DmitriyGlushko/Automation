import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class Get200Test {
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://dmbp-core.192.168.100.38.sslip.io";
    }


    @Test
    public void healthCheck() {
                given().contentType(ContentType.JSON)
                .get("/actuator/health")
                .then()
                .statusCode(200)
                .body("status", equalTo("UP"))
                .body("groups", hasItems("liveness", "readiness"));
    }
}