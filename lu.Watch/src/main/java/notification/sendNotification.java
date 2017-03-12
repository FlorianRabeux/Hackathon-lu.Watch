package notification;

import java.io.IOException;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class sendNotification {

	public static void sendSMS(String msg, String phone) throws IOException
	{
		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, "{\n\t\"message\" : \""+msg+"\",\n\t\"phoneNumber\" : \""+phone+"\"\n}");
		Request request = new Request.Builder()
		  .url("https://x2cu96g2tf.execute-api.eu-west-1.amazonaws.com/test/notification/sms")
		  .post(body)
		  .addHeader("content-type", "application/json")
		  .addHeader("x-api-key", "kKQgOwbOro3XQ0tVXGv3T6Zs4StIPTJBUUWDWuEj")
		  .addHeader("cache-control", "no-cache")
		  .addHeader("postman-token", "c0b99839-f5a0-4082-44d1-75d026bdcc55")
		  .build();

		Response response = client.newCall(request).execute();
	}
	
	public static void sendEmail(String msg, String to, String object) throws IOException {
		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, "{\n        \"message\" : \""+msg+"\",\n        \"to\" : \""+to+"\",\n        \"subject\" : \""+object+"\"\n}");
		Request request = new Request.Builder()
		  .url("https://x2cu96g2tf.execute-api.eu-west-1.amazonaws.com/test/notification/email")
		  .post(body)
		  .addHeader("content-type", "application/json")
		  .addHeader("x-api-key", "kKQgOwbOro3XQ0tVXGv3T6Zs4StIPTJBUUWDWuEj")
		  .addHeader("cache-control", "no-cache")
		  .addHeader("postman-token", "3fc6bbb1-4691-7294-cb91-885ed4801a76")
		  .build();

		Response response = client.newCall(request).execute();
	}
}
