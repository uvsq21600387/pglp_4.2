package mathieu.pglp_4_2;

import java.util.HashMap;
import java.util.Map;

public class Interpreteur {
	public Map<String, Command> commands;
	
	private Interpreteur() {
		commands = new HashMap<String, Command>();
	}
	
	public void addCommand(String name, Command command) {
		this.commands.put(name, command);
	}
	
	public void executeCommand(String name) {
		if(commands.containsKey(name)) {
			commands.get(name).apply();
		}
	}
	
	public static Interpreteur init() {
		Interpreteur i = new Interpreteur();
		
		//i.addCommand("undo", );
		//i.addCommand("quit", );
		
		return i;
	}
}
