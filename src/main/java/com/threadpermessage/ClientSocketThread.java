package com.threadpermessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClientSocketThread extends Thread {

	private final Socket clientSocket;

	@Override
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
			writer.print("HTTP/1.1 200 OK\r\n");
			writer.print("Content-Type: text/html\r\n\r\n");
			writer.print("<html><head><meta charset=\"utf-8\"></head><body>こちらはMiniServerです。");
			for (int i = 0; i < 10; i++) {
				writer.println("<h1>" + i + "</h1>");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
			}
			writer.print("</body></html>");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				clientSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
