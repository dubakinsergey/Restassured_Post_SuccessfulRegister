import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ReqresTest {
    private final static String URL = "https://reqres.in/";

    @Test
    public void checkSuccessfulRegister() {
        Specification.installSpecification(Specification.requestSpecification(URL), Specification.responseSpecificationStatus200());
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        Register user = new Register("eve.holt@reqres.in", "pistol");
        SuccessfulRegister successfulRegister = given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().body().as(SuccessfulRegister.class);

        Assert.assertNotNull(successfulRegister.getId());
        Assert.assertNotNull(successfulRegister.getToken());

        Assert.assertEquals(successfulRegister.getId(), id);
        Assert.assertEquals(successfulRegister.getToken(), token);
    }

}
