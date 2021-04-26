package rest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

class MobileBankApiTestV6 {
    private RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("http://localhost")
            .setBasePath("/api/v1")
            .setPort(9999)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    @Test
    void shouldReturnDemoAccounts() {
        // Given - When - Then
        // Предусловия
        given()
                .spec(requestSpec) // со спецификацией проще (особенно когда много тестов)
                // Выполняемые действия
              //  .log().all() Полный лог
                .when()
                .get("/demo/accounts")
                // Проверки
                .then()
                //  .log().all() Полный лог
                .statusCode(200);
    }
}
