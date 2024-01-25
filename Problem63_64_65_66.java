import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import acm.program.ConsoleProgram;

public class Problem63_64_65_66 extends ConsoleProgram{
	private static final String SENTINEL = "";
	
	public void run() {
		Map<String, ArrayList<String>> friendsList = new HashMap<String, ArrayList<String>>();
		
		while(true) {
			String friend = readLine("Enter friend name: ");
			if(friend.equals(SENTINEL)) break;
			String person = readLine("Enter person name: ");
			
			if(!friendsList.containsKey(person)) {
				friendsList.put(person, new ArrayList<String>());
			}
			
			ArrayList<String> personsFriends = friendsList.get(person);
			if(!personsFriends.contains(friend)) {
				personsFriends.add(friend);
				friendsList.put(person, personsFriends);
			}	
		}
		
		int maxFriends = 0;
		String personWithMostFriends = null;
		for(String person : friendsList.keySet()) {
			if(friendsList.get(person).size() > maxFriends) {
				maxFriends = friendsList.get(person).size();
				personWithMostFriends = person;
			}
		}
		println("Person with most friends is " + personWithMostFriends);
		
		ArrayList<String> allNames = new ArrayList<String>();
 		for(String person : friendsList.keySet()) {
 			if(!allNames.contains(person)) allNames.add(person);
 			for(String friend : friendsList.get(person)) {
 				if(!allNames.contains(friend)) allNames.add(friend);
 			}
 		}
 		
 		for(String name : allNames) {
 			if(!friendsList.containsKey(name)) println(name + " has no friends");
 			else {
 				String friends = friendsList.get(name).toString();
 				println(name + ": " + friends);
 			}
 		}
 		
 		
 		
 		
	}
	

}
