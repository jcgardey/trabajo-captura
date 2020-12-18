package org.gardey.events;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class OptionSelection extends UsabilityEvent {

	private int selectionIndex;

	private boolean optionChanged;

	public OptionSelection() {

	}

	public int getSelectionIndex() {
		return selectionIndex;
	}

	public void setSelectionIndex(int selectionIndex) {
		this.selectionIndex = selectionIndex;
	}

	public boolean isOptionChanged() {
		return optionChanged;
	}

	public void setOptionChanged(boolean optionChanged) {
		this.optionChanged = optionChanged;
	}

}
