package ServerProject.ServerProject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Serilization {
	private static final ObjectMapper MAPPER = new ObjectMapper();
	@Test
	public void serilize() throws JsonProcessingException {
		
		Blog_Post blog_Post = new Blog_Post();
		blog_Post.setId(1);
		blog_Post.setTitle("json-server1");
		blog_Post.setAuthor("santosh1");	
		
		String urlString = "http://localhost:3000/posts";
		
		String jsonString = MAPPER.writeValueAsString(blog_Post);
		
		Response response = (Response) RestAssured.given()
							.contentType(ContentType.JSON)
							.body(jsonString)
							.log()
							.all()
							.post(urlString);
					response.prettyPrint();
					response.statusCode();
	}

}
