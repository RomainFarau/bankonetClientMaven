package dta;

import java.util.ResourceBundle;

public class RestServerInfoHelper {

	public RestServerInfo getRestServerInfo(){
		ResourceBundle serverProps=ResourceBundle.getBundle("server");
		String protocol=serverProps.getString("protocol");
		String host=serverProps.getString("host");
		String port=serverProps.getString("port");
				
				
				
	    RestServerInfo infosServer=new RestServerInfo();
		infosServer.setProtocol(protocol);
		infosServer.setHost(host);
		infosServer.setPort(port);
		
		return infosServer;
	}
	
}
