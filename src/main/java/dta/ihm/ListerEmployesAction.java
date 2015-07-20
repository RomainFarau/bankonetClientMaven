package dta.ihm;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

public class ListerEmployesAction implements Action{

	private String identifiant="1";
	private static final String REST_URL = "http://localhost:8081/bankonetREST/api";
	
	Client client = ClientBuilder.newClient();
	WebTarget target = client.target(REST_URL);
	
	public String getId() {
		// TODO Auto-generated method stub
		return this.identifiant;
	}

	public String getMenu() {
		// TODO Auto-generated method stub
		return "Lister les employés";
	}

	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("Liste des employés");
        
        Invocation.Builder builder = target.request();
        
        Response response = builder.get();
        System.out.println("------------------La liste des employés------------------");
        
        if(response.getStatus() ==200){
            JSONArray jsonres = new JSONArray(response.readEntity(String.class));
            for(int i=0;i<jsonres.length();i++){
                JSONObject obj = new JSONObject(jsonres.get(i).toString());
                System.out.println("ID : " + obj.get("id")+" | "+"Nom : " + obj.get("nom")+" | " );
                System.out.println("-------------------------------------");
            }
        }
        System.out.println("\n");
		
		
	}

}
