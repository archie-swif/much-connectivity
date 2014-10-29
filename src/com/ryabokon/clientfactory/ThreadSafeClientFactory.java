package com.ryabokon.clientfactory;

import org.apache.http.client.HttpClient;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;

public class ThreadSafeClientFactory {

	private static HttpClient client;
	private static ThreadSafeClientConnManager manager;

	/**
	 * @return
	 */
	public static HttpClient createHttpClient() {

		if (client == null) {
			client = new DefaultHttpClient(manager);
			client.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.IGNORE_COOKIES);
		}

		return client;
	}

}
