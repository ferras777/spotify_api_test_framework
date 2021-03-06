package api.requests;

import api.bodies.artist.ArtistBody;
import io.restassured.response.Response;

import static api.specifications.RequestSpecifications.requestSpecification;
import static api.specifications.ResponseSpecifications.responseSpecification;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_OK;
import static api.enums.Endpoints.GET_ARTIST;

public class ArtistRequests {

    public ArtistBody getArtistBody(String id) {
        return getArtist(id).as(ArtistBody.class);
    }

    public Response getArtist(String id) {
        return given()
                    .spec(requestSpecification)
                .when()
                    .get(GET_ARTIST + id)
                .then()
                    .spec(responseSpecification)
                    .assertThat().statusCode(SC_OK)
                    .extract().response();
    }

    public Response getArtistWithWrongId() {
        return given()
                    .spec(requestSpecification)
                .when()
                    .get(GET_ARTIST + "asd64as6d5a46s5d4z23xc145")
                .then()
                    .spec(responseSpecification)
                    .assertThat().statusCode(SC_BAD_REQUEST)
                    .extract().response();
    }
}
