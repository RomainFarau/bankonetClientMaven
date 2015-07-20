
package dta;

import java.util.ResourceBundle;

class RestServerInfo{
	String protocol;
	String host;
	String port;
	

	
	

	public String getBaseUrl(){
		return "http://"+host+":"+port;
	}

	


	public void setProtocol(String pProtocol){
		protocol=pProtocol;
	}
	public void setHost(String pHost){
		host=pHost;
	}
	public void setPort(String pPort){
		port=pPort;
	}



	public String getProtocol(){
		return protocol;
	}
	public String getHost(){
		return host;
	}
	public String getPort(){
		return port;
	}

}