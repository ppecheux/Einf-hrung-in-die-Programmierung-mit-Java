import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Main {
	public static void main (String[]args){
		ArrayList<Person> personen = new ArrayList<>();
		for(int i =0;i<3;++i){
			Person p = new Person("M"+i,0);
			personen.add(p);
		}
		for(Person p : personen){
			p.Update();
			System.out.println(p.toString());
		}
		personen.remove(1);
		for(Person p : personen){
			p.Update();
			System.out.println(p.toString());
		}
		Person n = new Person("Mneu",0);
		personen.add(0,n);
		for(Person p : personen){
			p.Update();
			System.out.println(p.toString());
		}
		System.out.println(personen.size()+ "and"+personen.isEmpty());
		//personen.clear();
		System.out.println(personen.size()+ "and"+personen.isEmpty());
		
		//Ubung 9
		Map<String, Person> personMap = new HashMap<>();
		for(Person p:personen){
			personMap.put(p.name, p);
		}
		System.out.println("the size our map is: "+personMap.size());
		for (Person pers : personMap.values()){
			pers.setAngry(true);
		}
		for (Person pers : personMap.values()){
			System.out.println(pers.name+" is Hungrig "+pers.isAngry());
		}
		personMap.remove("Mneu");
		for (Person pers : personMap.values()){
			System.out.println(pers.name+" is Hungrig "+pers.isAngry());
		}
		personMap.get("Mneu").toString();
		Map<String, boolean> angryMap = new HashMap<>();
	
	}

}
