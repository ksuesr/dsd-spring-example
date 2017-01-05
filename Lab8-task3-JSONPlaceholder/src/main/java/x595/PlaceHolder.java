package x595;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

public class PlaceHolder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("HTTP GET sample");
		testGet();
		
		System.out.println("HTTP POST sample");
		testPost();
	}
	
	public static void testGet() {
		int randomID = (int)(Math.random() * 100) + 1;
		HttpGet get = new HttpGet("http://jsonplaceholder.typicode.com/posts/" + randomID);
		
		
		HttpClient client = HttpClientBuilder.create().build();
		get.setHeader("Accept", "application/json");
		
		HttpEntity entity;
		try {
			HttpResponse response = client.execute(get);
			
			if(response.getStatusLine().getStatusCode() != 200) {
				System.out.println("There was a problem with connection");
				return;
			}
			
			entity = response.getEntity();
			
			String json = EntityUtils.toString(entity);
			PostData data = new Gson().fromJson(json, PostData.class);
			
			if(data == null || data.getUserid() == null) {
				System.out.println("No such data exists");
				return;
			}
			System.out.println("{");
			System.out.println("\t\"userId\": " + data.getUserid() + ",");
			System.out.println("\t\"id\": " + data.getPostid() + ",");
			System.out.println("\t\"title\": " + data.getTitle() + ",");
			System.out.println("\t\"body\": " + data.getBody());
			System.out.println("}");
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testPost() {
		HttpPost post = new HttpPost("http://jsonplaceholder.typicode.com/posts/");
		HttpClient client = HttpClientBuilder.create().build();
		
		post.addHeader("Content-Type", "application/json");
		post.addHeader("Accept", "application/*");
		
		//prepare post data
		PostData toSend = new PostData();
		toSend.setUserid(9);
		toSend.setTitle("An unwelcomed news");
		toSend.setBody("When I was at buffet restaurant, I found that some of my friends start a relationship\r\nI was so angry because I am a single since birthdate :(");
		
		StringEntity se = new StringEntity(toSend.toString(),"UTF-8");
		post.setEntity(se);
		
		try {
			HttpResponse res = client.execute(post);
			
			if(res.getStatusLine().getStatusCode() != 201) {
				System.out.println("Something strnage happened!");
				return;
			}
			
			HttpEntity ent = res.getEntity();
			String json = EntityUtils.toString(ent);
			
			PostData received = new Gson().fromJson(json, PostData.class);
			
			if(received == null || received.getUserid() == null) {
				System.out.println("No such data exists");
				return;
			}
			System.out.println("{");
			System.out.println("\t\"userId\": " + received.getUserid() + ",");
			System.out.println("\t\"id\": " + received.getPostid() + ",");
			System.out.println("\t\"title\": " + received.getTitle() + ",");
			System.out.println("\t\"body\": " + received.getBody());
			System.out.println("}");
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
