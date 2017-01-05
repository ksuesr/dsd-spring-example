package x595;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;

import x595.data.CountryData;

public class CountryAPIMain {
	
	private static final String URL_PT = "http://restcountries.eu/rest/v1/lang/pt";
	private static final String URL_EA = "http://restcountries.eu/rest/v1/subregion/eastern asia";
	private static final String URL_USD = "http://restcountries.eu/rest/v1/currency/usd";

	public static void main(String... args) {
		
		test(URL_PT, 1, "Portuguese-speaking countries");
		test(URL_EA, 2, "Countries in eastern asia");
		test(URL_USD, 3, "Countries that use the US dollar as the currency");

	}
	
	public static void test(String url, int testCode, String desc) {
		System.out.println("Test " + testCode + " start: " + desc);
		
		HttpGet get = new HttpGet(url.replaceAll(" ", "%20"));
		
		HttpClient client = HttpClientBuilder.create().build();
		get.setHeader("Accept", "application/json");
		
		HttpEntity entity;
		try {
			HttpResponse response = client.execute(get);
			
			System.out.println(url);
			System.out.println(">" + response.getStatusLine().getStatusCode() + " " + response.getStatusLine().getReasonPhrase());
			if(response.getStatusLine().getStatusCode() != 200) {
				System.out.println("There was a problem with connection");
				return;
			}
			
			entity = response.getEntity();
			
			String json = EntityUtils.toString(entity);
			Type listType = new TypeToken<List<CountryData>>(){}.getType();
			List<CountryData> data = new Gson().fromJson(json, listType);
			
			System.out.println("\nResult:");
			for(CountryData d : data) {
				System.out.println(d.getName());
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("Test " + testCode + " ended: ");
		}
	}

}
