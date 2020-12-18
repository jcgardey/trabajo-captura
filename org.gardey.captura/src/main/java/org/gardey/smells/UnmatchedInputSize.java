package org.gardey.smells;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class UnmatchedInputSize extends UsabilitySmell {
	
	private double textLengthVariance;
	
	private double textLengthMean;
	
	public UnmatchedInputSize() {
		
	}

	public double getTextLengthVariance() {
		return textLengthVariance;
	}

	public void setTextLengthVariance(double textLengthVariance) {
		this.textLengthVariance = textLengthVariance;
	}

	public double getTextLengthMean() {
		return textLengthMean;
	}

	public void setTextLengthMean(double textLengthMean) {
		this.textLengthMean = textLengthMean;
	}
	
}
