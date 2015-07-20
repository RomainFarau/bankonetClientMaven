package dta.ihm;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import dta.RestServerInfoHelper;
import dta.ihm.util.ScannerUtil;

public class RechercherEmployeParIdAction implements Action{

	public String getId() {
		// TODO Auto-generated method stub
		return "2";
	}

	public String getMenu() {
		// TODO Auto-generated method stub
		return "Rechercher un employé par id";
	}

	public void execute() {
		// TODO Auto-generated method stub
		
		while(true){
			Integer userInput=ScannerUtil.getInstance().askUserInt("Donnez l'id recherché");
			if(userInput>=0){
				Client client = ClientBuilder.newClient();
				WebTarget target = client.target(String.format("http://localhost:8081/bankonetREST/api/employes/%s",userInput.toString()));
				
		        
		        Invocation.Builder builder = target.request();
		        
		        Response response = builder.get();
		        
		        if(response.getStatus() ==200){
		        	
		        	
		        	JSONObject obj = new JSONObject(response.readEntity(String.class));
		        	System.out.println("ID : " + obj.get("id")+" | "+"Nom : " + obj.get("nom")+" | " );
	                System.out.println("-------------------------------------");
		        	break;
		        }else {
		        	System.out.println("Identifiant inconnu");
		        }
			}else if(userInput==-1){
				break;
			}	
			else{
				System.out.println("Entrée invalide. -1 pour quitter.");
			}
		}
	}

}
