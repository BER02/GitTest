import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import acm.program.ConsoleProgram;

public class Problem63 extends ConsoleProgram{
	private static final String SENTINEL = "";
	public void run() {
//		Tornike Anastasia -> anastasia: tornike (tornike aris anastasias megobari)
		Map<String, ArrayList<String>> friendList = new HashMap<String, ArrayList<String>>();
		
		while(true) {
			String friend = readLine("Enter friend name: ");
			if(friend.equals(SENTINEL)) break;
			String person = readLine("Enter person name: ");
			
			if(!friendList.containsKey(person)) {
				ArrayList<String> friends = new ArrayList<String>();
//				friends.add(friend);
				friendList.put(person, friends);
			}
			
			ArrayList<String> personsFriends = friendList.get(person);
			if(!personsFriends.contains(friend)) personsFriends.add(friend);
			friendList.put(person, personsFriends);
		}
		
		println(friendList);
//		tornike -> anastasia, giorgi, lizi
//		anastasia -> lizi
		
		
	}
}
