package ServerProject.ServerProject;
import java.lang.reflect.Type;

import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;


import io.restassured.RestAssured;

public class Deserilization {

	@Test
	public void deserilization () throws JsonProcessingException{
		
		String urlString = "http://localhost:3000/posts";
		
		Blog_Post blogPosts1 = RestAssured.given()
				                .get(urlString)
				                .as(Blog_Post.class);
		
		System.out.println("javaobject:" + blogPosts1);
		String urlString1 = "http://localhost:3000/posts";
		
	
		
		Type type = new TypeReference<List<Blog_Post>>() {}.getType();  
		
		List<Blog_Post> blogpostsList = RestAssured.get(urlString1)
				                                     .as(type);
		
		System.out.println("javaobject1:" + blogpostsList); 
		
		
				
		
		
		
	}
}
