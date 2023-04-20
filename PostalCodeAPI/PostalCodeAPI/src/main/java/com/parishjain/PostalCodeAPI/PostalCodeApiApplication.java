package com.parishjain.PostalCodeAPI;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootApplication
public class PostalCodeApiApplication {

	public static void main(String[] args) throws Exception{

		URL getUrl = new URL("https://api.zippopotam.us/us/33162");
		HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
		connection.setRequestMethod("GET");
		int responseCode =connection.getResponseCode();
		if(responseCode==200){

			InputStream inputStream = connection.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader reader = new BufferedReader(inputStreamReader);
			String line;
			StringBuilder response = new StringBuilder();
			while((line = reader.readLine()) != null){
				response.append(line);
			}
			reader.close();
			inputStream.close();

			String responseString = response.toString();
			JSONObject jsonObject = new JSONObject(responseString);
			System.out.println(jsonObject.toString(4));

		}

	}

}
