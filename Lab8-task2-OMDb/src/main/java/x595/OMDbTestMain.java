package x595;

import java.io.IOException;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

import x595.data.OMDbData;


public class OMDbTestMain {
	
	private static final String urlPattern = "http://www.omdbapi.com/?t=%s&y=&plot=short&r=json";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner istream = new Scanner(System.in);

		String movie_name;
		System.out.print("Give a movie name: ");
		movie_name = istream.nextLine();
		
		getMovieData(movie_name);
		
		istream.close();
	}
	
	public static void getMovieData(String movie_name) {
		HttpGet get = new HttpGet(String.format(urlPattern, movie_name).replaceAll(" ", "+"));
		
		System.out.println("Fetching data for " + movie_name);
		
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
			OMDbData data = new Gson().fromJson(json, OMDbData.class);
			
			if("True".equalsIgnoreCase(data.getResponse())) {
			
				System.out.println("\nResult:");
				System.out.println("Name: " + data.getTitle());
				System.out.println("Release date: " + data.getReleased());
				System.out.println("Genre: " + data.getGenre());
				System.out.println("Actors: " + data.getActors());
				System.out.println("IMDb rating: " + data.getImdbRating() + " over " + data.getImdbVotes() + " votes");
			} else {
				
				System.out.println("\nEncounter an error!");
				System.out.println("Error description: " + data.getError());
			}
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
