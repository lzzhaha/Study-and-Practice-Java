package com.shiyanlou.j2se.network;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SocketServer extends JFrame {
	
	private JTextArea socket_info;
	
	private ServerSocket server;
	
	private Socket client;
	
	private BufferedReader reader;
	
	public SocketServer(){
		
		super();
		
		setTitle("Socket Server");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(200, 200, 500, 500);
		
		final JScrollPane scrollPane = new JScrollPane();
		
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		socket_info = new  JTextArea();
		
		scrollPane.setViewportView(socket_info);
		
	}
	
	public void getServer(){
		try{
			//the port number should be consistent with the request
			server = new ServerSocket(2015);
			
			socket_info.append("Server socket create successfully\n");
			
			while(true){
				
				socket_info.append("Waiting for connection from client\n");
				
				client = server.accept();
				
				socket_info.append("Connect Successfully\n");
				
				reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
				
				getClientInfo();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	private void getClientInfo(){
		
		try{
			socket_info.append("Info from client: " + reader.readLine() + "\n");
		}catch(Exception e){
			socket_info.append("No message sent\n");
		}finally{
			try{
				if(reader != null){
					reader.close();
				}
				
				if(client != null){
					client.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args){
		try{
			SocketServer serverFrame = new SocketServer();
			
			serverFrame.setVisible(true);
			
			serverFrame.getServer();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}