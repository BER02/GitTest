import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import acm.program.ConsoleProgram;

public class Problem63_64_65_66 extends ConsoleProgram{
	private static final String SENTINEL = "";
	private Map<String, ArrayList<String>> friendsList = new HashMap<String, ArrayList<String>>();
	
	public void run() {
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
		
		println("Person with most friends is " + getPersonWithMostFriends(friendsList));
		
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
 		
 		println("Person who is friend of most people: " + getPersonWithMostFriends(reverse(friendsList)));
 		
 		println(twoPeopleWithNoCommonFriends(friendsList));
	}
	
	private String getPersonWithMostFriends(Map<String, ArrayList<String>> map) {
		int maxFriends = 0;
		String personWithMostFriends = null;
		for(String person : map.keySet()) {
			if(map.get(person).size() > maxFriends) {
				maxFriends = map.get(person).size();
				personWithMostFriends = person;
			}
		}
		
		return personWithMostFriends;
		}
		
	private Map<String, ArrayList<String>> reverse(Map<String, ArrayList<String>> map) {
		Map<String, ArrayList<String>> reversed = new HashMap<String, ArrayList<String>>();
		for(String person : map.keySet()) {
			for(String friend : map.get(person)) {
				reversed.putIfAbsent(friend, new ArrayList<String>());
				reversed.get(friend).add(person);
			}
		}
		return reversed;
	}
	
	private boolean haveCommonFriend(ArrayList<String> friends1, ArrayList<String> friends2) {
		for(String friend : friends1) {
			if(friends2.contains(friend)) return true;
		}
		return false;
	}
	
	private String twoPeopleWithNoCommonFriends(Map<String, ArrayList<String>> map) {
		for(String person1 : map.keySet()) {
			for(String person2 : map.keySet()) {
				if(person1.equals(person2)) continue;
				ArrayList<String> friends1 = map.get(person1);
				ArrayList<String> friends2 = map.get(person2);
				if(!haveCommonFriend(friends1, friends2)) return "Two person with no common friends are " + person1 + " and " + person2;
			}
		}
		
		return "All of them have at least one friend in common";
	}
	

}
