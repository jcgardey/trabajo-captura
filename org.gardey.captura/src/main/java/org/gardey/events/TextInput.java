package org.gardey.events;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class TextInput extends UsabilityEvent {
	
	@Column(length=10000)
	private String text;
	
	private int keystrokes;
	
	private boolean correction;
	
	private float time;
	
	private double textWidth;
	
	private int inputLength;
	
	
	public TextInput () {
		
	}

	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public int getKeystrokes() {
		return keystrokes;
	}


	public void setKeystrokes(int keystrokes) {
		this.keystrokes = keystrokes;
	}


	public boolean isCorrection() {
		return correction;
	}


	public void setCorrection(boolean correction) {
		this.correction = correction;
	}


	public float getTime() {
		return time;
	}


	public void setTime(float time) {
		this.time = time;
	}


	public double getTextWidth() {
		return textWidth;
	}


	public void setTextWidth(double textWidth) {
		this.textWidth = textWidth;
	}


	public int getInputLength() {
		return inputLength;
	}


	public void setInputLength(int inputLength) {
		this.inputLength = inputLength;
	}
	
}
