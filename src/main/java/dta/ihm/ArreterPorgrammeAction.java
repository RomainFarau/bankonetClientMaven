package dta.ihm;

import dta.ihm.util.ScannerUtil;

public class ArreterPorgrammeAction implements Action{

	public String getId() {
		// TODO Auto-generated method stub
		return "0";
	}

	public String getMenu() {
		// TODO Auto-generated method stub
		
		return "Arrêter le Programme";
	}

	public void execute() {
		// TODO Auto-generated method stub
		ScannerUtil.getInstance().close();
		System.out.println("Fermeture du programme");
		System.exit(0);
	}

}
