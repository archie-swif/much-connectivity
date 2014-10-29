package com.ryabokon.executable;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ryabokon.clientfactory.PoolingHttpClientFactory;

public class RequestSenderRunnable implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(RequestSenderRunnable.class);
	private final String openamUrl = "http://128.0.0.1:8080/openam";
	private final String ssoToken;

	public RequestSenderRunnable(String ssoToken) {
		this.ssoToken = ssoToken;
	}

	public void sendRequest() {

		HttpClient client = PoolingHttpClientFactory.createHttpClient();

		HttpGet request = new HttpGet(openamUrl + "/identity/attributes?" + "subjectid=" + ssoToken + "&attributenames=dn");
		request.addHeader("content-type", "application/json");
		HttpResponse response = null;

		try {
			response = client.execute(request);
		} catch (Exception e) {
			log.error("ERROR", e);
		} finally {
			if (response != null) {
				EntityUtils.consumeQuietly(response.getEntity());
			}
		}

	}

	@Override
	public void run() {
		long threadId = Thread.currentThread().getId();
		while (true) {

			sendRequest();
			log.info("hey " + threadId);
		}

	}

}
