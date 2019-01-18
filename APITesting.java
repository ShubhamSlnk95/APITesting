import io.restassured.response.Response;
import java.lang.ref.SoftReference;
import java.util.*;
import static io.restassured.RestAssured.given;

public class APITesting {


    public  String baseURI="https://jsonplaceholder.typicode.com";
    public String data = "{\n" +
            "    \"userId\": 1,\n" +
            "    \"id\": 1,\n" +
            "    \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n" +
            "    \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\n" +
            "}";

    //  Give the Get Request to an API and get the output
    public void getDataFromAPI()
    {
        Response response = given().header("content-type","application/json").baseUri(baseURI).
                            when().get("/posts").
                            then().assertThat().statusCode(200).assertThat().
                            extract().response();
        display(response.getBody().asString());
    }

    //  Give the Post Request to an API and get output
    public void postDataFromAPI()
    {
        Response response = given().header("content-type","application/json").
                baseUri(baseURI).body(data).
                when().post("/posts").
                then().extract().response();
        display(response.getBody().asString());
    }
    // Give The PUT Request to an API and update data
    public void updateDataInAPI()
    {
        Response response = given().header("content-type","application/json").
                baseUri(baseURI).body(data).
                when().put("/posts/1").
                then().extract().response();
        display(response.getBody().asString());
    }

    //Give the Delete request to an API and Delete Data
    public void deleteDataFromAPI()
    {
        Response response = given().header("content-type","application/json").
                baseUri(baseURI).
                when().delete("/posts/1").
                then().assertThat().statusCode(200).assertThat().
                extract().response();
        display(response.getBody().asString());
    }
    // Method To Display Output 
    public void display(String output)
    {
        System.out.println(output);
    }
    //Main Method 
    public static void main(String[] args) {

        APITesting apiTesting = new APITesting();
        Scanner scanner = new Scanner(System.in);
        System.out.print("1: Get Data\n2: PostData\n3: Update Data\n4: delete Data\n");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1: {
                apiTesting.getDataFromAPI();
                break;
            }
            case 2: {
                apiTesting.postDataFromAPI();
                break;
            }
            case 3: {
                apiTesting.updateDataInAPI();
                break;
            }
            case 4: {
                apiTesting.deleteDataFromAPI();
                break;
            }
            default: {
                System.out.print("Invalid Input1");
            }
        }
    }
}






    