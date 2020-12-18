package org.gardey.smells;

import java.util.HashMap;
import java.util.Map;

import javax.jdo.annotations.Discriminator;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.NullValue;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class FreeInput extends UsabilitySmell {
	

	private double minimumGroupProportion;
	
	private Map <String, Integer> valuesWithOccurrences;
	
	private boolean hasPasswords;
	
	private boolean hasPlainText;
	
	public FreeInput() {
		super();
		this.valuesWithOccurrences = new HashMap<String, Integer>();
		
	}
		
	public double getMinimumGroupProportion() {
		return minimumGroupProportion;
	}


	public void setMinimumGroupProportion(double minimumGroupProportion) {
		this.minimumGroupProportion = minimumGroupProportion;
	}
	
	
	public Map<String, Integer> getValuesWithOccurrences() {
		return valuesWithOccurrences;
	}

	public void setValuesWithOccurrences(Map<String, Integer> valuesWithOccurrences) {
		this.valuesWithOccurrences = valuesWithOccurrences;
	}

	public boolean isHasPasswords() {
		return hasPasswords;
	}

	public void setHasPasswords(boolean hasPasswords) {
		this.hasPasswords = hasPasswords;
	}

	public boolean isHasPlainText() {
		return hasPlainText;
	}

	public void setHasPlainText(boolean hasPlainText) {
		this.hasPlainText = hasPlainText;
	}
	
	

}
