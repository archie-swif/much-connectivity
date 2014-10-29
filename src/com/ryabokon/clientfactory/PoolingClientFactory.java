package com.ryabokon.clientfactory;

import org.apache.http.client.HttpClient;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;

public class PoolingClientFactory {

	private static HttpClient client;
	private static PoolingClientConnectionManager manager;

	public static HttpClient createHttpClient() {

		if (client == null) {
			client = new DefaultHttpClient(manager);
			client.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.IGNORE_COOKIES);
		}

		return client;
	}

}
