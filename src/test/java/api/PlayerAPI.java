package api;

import api.pojo.PlayerDetailsAPI;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;
import javafx.beans.binding.ObjectExpression;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.get;

public class PlayerAPI {
    @BeforeTest
    public void setUp() {
        RestAssured.baseURI = "https://api.opendota.com";
    }

    @AfterTest
    public void tearDown() {
        RestAssured.baseURI = null;
    }

    @Test(dataProvider = "accountId")
    public void getPlayerDetails(String accountId) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ResponseBody responseBody = get("/api/players/{account_id}", accountId).getBody();
        PlayerDetailsAPI player = mapper.readValue(responseBody.asString(),PlayerDetailsAPI.class);
        System.out.println(player.getAccount_id());
    }

    /*
    88470
    1296625
    3916428
     */
    @DataProvider(name = "accountId")
    public Object[][] getData() {
        Object[][] data = new Object[3][1];
        data[0][0]= "88470";
        data[1][0]= "1296625";
        data[2][0]= "3916428";
        return data;
    }
}
