package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {

		//we have create object for properties  class
		Properties pro;
		
		//then we have to create constructor
		public Readconfig()
		{
			File src = new File("./configuration/config.properties");//we have to read data from config file so we have to import this file using Fileinputstream ,if you want
			try {                                                     //read the data the we have to open the file in reading mode so in that case we need to use Fileinputstrem
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}catch(Exception e) {
			
		System.out.println("Exception is " + e.getMessage());
		}

	}
		public String getApplicationURL()
		{
			String url=pro.getProperty("baseURL");
			return url;
		}
		
		public String getUsername()
		{
			String username=pro.getProperty("username");
			return username;
		}
		public String getPassword()
		{
			String password=pro.getProperty("password");
			return password;
		}
		public String getChromePath()
		{
			String chromepath=pro.getProperty("chromepath");
			return chromepath;
		}
		public String getEdgePath()
		{
			String edgepath=pro.getProperty("edgepath");
			return edgepath;
		}

}
