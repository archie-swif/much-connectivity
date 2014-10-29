package com.ryabokon.executable;

public class MuchConnectivityExecutable {

	public static void main(String... args) throws Throwable {

		String ssoToken = "test";

		for (int i = 0; i < 1000; i++) {
			Thread thread = new Thread(new RequestSenderRunnable(ssoToken));
			thread.start();
			Thread.sleep(100);
		}

	}

}
