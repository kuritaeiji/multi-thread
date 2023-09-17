package com.threadpermessage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MiniServer {

	public void start() throws IOException {
		try (ServerSocket serverSocket = new ServerSocket(8080)) {
			while (true) {
				Socket clientSocket = serverSocket.accept();
				new ClientSocketThread(clientSocket).start();
			}
		}
	}
}
