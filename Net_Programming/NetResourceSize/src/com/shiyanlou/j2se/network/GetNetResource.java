package com.shiyanlou.j2se.network;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.*;

public class GetNetResource extends JFrame{

	
	public GetNetResource(){
		super();
		
		setTitle("Get the size and content of resource from Internet");
		
		getContentPane().setLayout(null);
		
		setBounds(200, 200, 1000, 800);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Set the following GUI Components final to ensure that
		//they can be accessed inside the method of inner class
		
		
		final JLabel url_label  = new JLabel("Enter URL:");
		url_label.setBounds(10, 80, 100, 25);
		
		final JLabel size_label = new JLabel("Size: ");
		size_label.setBounds(10, 125, 80, 25);
		
		final JTextField url_text = new JTextField();
		url_text.setBounds(90, 80, 300, 25);

		final JTextArea content_text = new JTextArea();
		content_text.setBounds(10, 180, 500, 500);
		
		final JTextField size_text = new JTextField();
		size_text.setBounds(80, 125, 145, 25);
		
		final JLabel content_label = new JLabel("Content");
		content_label.setBounds(10, 150, 80, 25);
		
		final JButton button = new JButton();
		
		button.setText("Get the size and content");
		
		button.setBounds(235, 125, 300, 25);
		
		button.addActionListener(new ActionListener(){
			public void actionPerformed(final ActionEvent e){
				
				String url = url_text.getText().trim();
				
				try{
					long len = resourceSize(url);
					
					size_text.setText(String.valueOf(len)+" bytes");

					Collection<String> content = get_content_from_url(url);
					
					Iterator<String> it = content.iterator();
					
					while(it.hasNext()){
						content_text.append(it.next() + "\n");
					}
					
					
				}catch(Exception ex){
					ex.printStackTrace();
				}
				
			}
		});
		
        getContentPane().add(url_label);
        getContentPane().add(size_label);
        getContentPane().add(url_text);
        getContentPane().add(size_text);
        getContentPane().add(content_text);
        getContentPane().add(button);
		
	}
	
	//get the size of the resource from given URL
	public long resourceSize(String Url)throws Exception{
		URL url = new URL(Url);
		
		URLConnection conn = url.openConnection();
		
		conn.connect();
		
		return conn.getContentLength();
	}
	
	//get the content of the resource from the given URL
	public Collection<String> get_content_from_url(String Url){
		URL url = null;
		
		URLConnection conn = null;
		
		Collection<String> content = new ArrayList<String>();
		
		try{
			url = new URL(Url);
			
			conn = url.openConnection();
			
			conn.connect();
			
			InputStream is = conn.getInputStream();
			
			InputStreamReader in = new InputStreamReader(is, "UTF-8");
			
			BufferedReader br = new BufferedReader(in);
			
			String nextLine = br.readLine();
			
			while(nextLine != null){
				content.add(nextLine);
				
				nextLine = br.readLine();
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return content;
	}
	
	
	
	
	public static void main(String[] args){
		
		//catch the exception during creation of frame
		try{
			GetNetResource frame = new GetNetResource();
			
			frame.setVisible(true);
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
	}
	
	
}
