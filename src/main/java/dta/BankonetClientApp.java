package dta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import org.reflections.Reflections;

import dta.ihm.*;
import dta.ihm.util.ScannerUtil;

public class BankonetClientApp {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException{
		RestServerInfoHelper restServerInfoHelper=new RestServerInfoHelper();
		RestServerInfo restServerInfo=restServerInfoHelper.getRestServerInfo();
		
		System.out.println(restServerInfo.getBaseUrl());
		
		 Reflections reflections = new Reflections("dta.ihm");

		 Set<Class<? extends Action>> list = reflections.getSubTypesOf(Action.class);
		
		 List<Action> listActions=new ArrayList<Action>();
		 
		 //Collections.sort(list, ((Action)o1,(Action)o2)->o1.getId().compareTo((o2.getId()));
		 
		 System.out.println("***** BANKONET!CLIENT *****");
		 
		 for (Class<? extends Action> class1 : list) {
			 listActions.add((Action)class1.newInstance());
			//System.out.println(action.getId()+". "+action.getMenu());
		}
		 
		 Collections.sort(listActions, (o1,o2)->o1.getId().compareTo(o2.getId()));
		 /*TreeSet<Action> actions = new TreeSet<>(new Comparator<Action>(){
			  	@Override
			  	public int compareTo(Action o1, Action o2){
			  		return o1.getId().comparaTo(o2.getId());
			  	}
			  });
			 actions.addAll();
			  */
		 //
		 for (Action action : listActions) {
			System.out.println(action.getId()+". "+action.getMenu());
		}
		 /*
		  List<Action> list = new ArrayList<>();
		  TreeSet<Action> actions = new TreeSet<>(new Comparator<Action>(){
		  	@Override
		  	public int compare(Action o1, Action o2){
		  		return o1.getId().comparaTo(o2.getId());
		  	}
		  });
		  
		  action.addAll();
		  
		  Collections.sort(list, (o1,o2)->o1.getId().compareTo(o2.getId()));
		  
		  TreeSet<Action> actionsJava8 = new TreeSet<>((o1,o2)-> o1.getId().compareTo(o2.getId()));
		  */
		 /*String userInput;
		 System.in(userInput);*/
		 
		 while(true){
			 Integer userInput=ScannerUtil.getInstance().askUserInt("Choisissez une option");
			 if(userInput<listActions.size() && userInput>=0){
				 listActions.get(userInput).execute();
			 }
		 }
		 
	}
	
}
