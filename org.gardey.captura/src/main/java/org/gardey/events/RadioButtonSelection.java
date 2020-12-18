package org.gardey.events;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class RadioButtonSelection extends OptionSelection {
	
	private String name;
	
	public RadioButtonSelection () {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
