package com.jk.comm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Constan {

//	@Value(value = "${ftp.host}")
//	@Value(value = "#{configProperties['ftp.host']}")
	public static String FTP_HOST;
	
	public static int FTP_PORT;
	
	public static String FTP_USER;
	
	public static String FTP_PWD;
	
	public static String FTP_FILE_ADDR;

	@Value(value = "${ftp.host}")
	public void setHost(String host) {
		Constan.FTP_HOST = host;
	}
	
	@Value(value = "${ftp.port}")
	public void setPort(int port) {
		Constan.FTP_PORT = port;
	}
	
	@Value(value = "${ftp.user}")
	public void setUser(String user) {
		Constan.FTP_USER = user;
	}
	
	@Value(value = "${ftp.pwd}")
	public void setPwd(String pwd) {
		Constan.FTP_PWD = pwd;
	}
	
	@Value(value = "${ftp.addr}")
	public void setAddr(String addr) {
		Constan.FTP_FILE_ADDR = addr;
	}
	
}
