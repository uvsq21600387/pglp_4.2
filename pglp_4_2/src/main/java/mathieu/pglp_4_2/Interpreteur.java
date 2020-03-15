package mathieu.pglp_4_2;

import java.util.HashMap;
import java.util.Map;

public class Interpreteur {
	public Map<String, GenericCommand> commands;
	
	private Interpreteur() {
		commands = new HashMap<String, GenericCommand>();
	}
	
	public void addCommand(final String name, final GenericCommand command) {
		this.commands.put(name, command);
	}
	
	public void executeCommand(final String name) throws Exception {
		if(commands.containsKey(name)) {
			try {
				commands.get(name).apply();
			} catch (Exception e) {
				System.err.println("La commande a échouée");
			}
		}
		else {
			throw new Exception();
		}
	}
	
	public static Interpreteur init(final Undo u) {
		Interpreteur i = new Interpreteur();
		
		i.addCommand("undo", u);
		i.addCommand("quit", new Quit());
		
		return i;
	}
}
