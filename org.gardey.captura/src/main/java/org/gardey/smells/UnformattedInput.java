package org.gardey.smells;
import java.util.Collection;
import java.util.HashSet;

import javax.jdo.annotations.Embedded;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class UnformattedInput extends UsabilitySmell {
	
	private Collection <Expression> expressions;
	
	public UnformattedInput () {
		this.expressions = new HashSet <Expression> ();
	}

	public Collection<Expression> getExpressions() {
		return expressions;
	}

	public void setExpressions(Collection<Expression> expressions) {
		this.expressions = expressions;
	} 
	
}
