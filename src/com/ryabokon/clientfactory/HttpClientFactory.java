package com.ryabokon.clientfactory;

import org.apache.http.client.HttpClient;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpClientFactory {

	/**
	 * @return
	 */
	public static HttpClient createHttpClient() {
		HttpClient client = new DefaultHttpClient();
		client.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.IGNORE_COOKIES);
		return client;
	}

}
