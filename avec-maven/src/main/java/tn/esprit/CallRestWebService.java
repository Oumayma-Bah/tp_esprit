package tn.esprit;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class CallRestWebService {

	public static final String endpoint = "http://ip-api.com/json";

	public static void main(String[] args) {
		HttpClient client = HttpClients.createDefault();
		HttpGet request = new HttpGet(endpoint);
		String ip = "not found";

		try {
			HttpResponse response = client.execute(request);
			HttpEntity entity = response.getEntity();
			String jsonResponse = EntityUtils.toString(entity);
			System.out.println("Response as String : " + jsonResponse);

			JSONObject responseObj = new JSONObject(jsonResponse);
			ip = responseObj.getString("query");
			System.out.println("ip : " + ip);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
