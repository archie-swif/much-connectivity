package com.ryabokon.clientfactory;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

public class PoolingHttpClientFactory {

	private static HttpClient client;
	private static PoolingHttpClientConnectionManager manager;

	public static HttpClient createHttpClient() {

		if (client == null) {
			manager = new PoolingHttpClientConnectionManager();
			client = HttpClients.custom().setConnectionManager(manager).disableCookieManagement().build();
		}

		return client;
	}

}
