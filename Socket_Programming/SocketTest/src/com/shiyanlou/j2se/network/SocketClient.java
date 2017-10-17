package com.shiyanlou.j2se.network;

import java.awt.BorderLayout;
import java.io.PrintWriter;
import java.net.*;
import javax.swing.*;

public class SocketClient extends JFrame{
	
	private Socket socket;
	
	private JTextArea socket_info;
	
	private PrintWriter writer;
	
	
	public SocketClient(){
		
		super();
		
		setTitle("Socket Client");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(200, 200, 500, 500);
		
		final JScrollPane scrollPane = new JScrollPane();
		
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		socket_info = new JTextArea();
		
		scrollPane.setViewportView(socket_info);
	}
	
	private void connect(){
		
		socket_info.append("Connecting to Server");
		
		try{
			
			socket = new Socket("127.0.0.1", 2015);
			
			writer = new PrintWriter(socket.getOutputStream(), true);
						
			socket_info.append("Connection Completes");
			
			writer.println("Client Message");

			
			InetAddress serverAddress = socket.getInetAddress();
			
			String serverIP = serverAddress.getHostAddress();
			
			int serverPort = socket.getPort();
			
			InetAddress localAddress = socket.getLocalAddress();
			
			String clientIP = localAddress.getHostAddress();
			
			int clientPort = socket.getLocalPort();
			
			socket_info.append("Server IP: " + serverIP + "\n");
            socket_info.append("Server Port: " + serverPort + "\n");
            socket_info.append("Client IP: " + clientIP + "\n");
            socket_info.append("Client Port: " + clientPort + "\n");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	
	}
	
	
	public static void main(String[] args){
		try{
			SocketClient clientFrame = new SocketClient();
			
			clientFrame.setVisible(true);
			
			clientFrame.connect();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}