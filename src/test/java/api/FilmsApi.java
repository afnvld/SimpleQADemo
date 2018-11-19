package api;

import api.pojo.FilmDetails;
import api.pojo.FilmsApi_pojo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.get;

public class FilmsApi {

    @BeforeTest
    public void setUp() {
        RestAssured.baseURI = "https://ghibliapi.herokuapp.com";
    }

    @AfterTest
    public void tearDown() {
        RestAssured.baseURI = null;
    }

    /*
    * 67405111-37a5-438f-81cc-4666af60c800
    578ae244-7750-4d9f-867b-f3cd3d6fecf4
    5fdfb320-2a02-49a7-94ff-5ca418cae602
    */

    @Test
    public void getAllFilms() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ResponseBody responseBody = get("/films").getBody();
        List<FilmsApi_pojo> films = mapper.readValue(responseBody.asString(), new TypeReference<List<FilmsApi_pojo>>() {
        });

        for (FilmsApi_pojo film : films) {
            System.out.println(film.getId());
            Assert.assertNotNull(film.getTitle());
            Assert.assertNotNull(film.getDescription());
            Assert.assertNotNull(film.getId());
            Assert.assertNotNull(film.getRelease_date());

        }


    }
    @Test(dataProvider = "filmId")
    public void getFilmDetails(String filmId) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ResponseBody responseBody = get("/films/{id}", filmId).getBody();
        FilmDetails filmdetails = mapper.readValue(responseBody.asString(), FilmDetails.class);
        System.out.println(filmdetails.getTitle());
    }

    @DataProvider(name = "filmId")
    public Object[] getData() {
        Object[] data = new Object[3];
        data[0] = "67405111-37a5-438f-81cc-4666af60c800";
        data[1] = "578ae244-7750-4d9f-867b-f3cd3d6fecf4";
        data[2] = "5fdfb320-2a02-49a7-94ff-5ca418cae602";
        return data;
    }



}
