package org.gardey.events;

import org.gardey.DomElement;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Navigation {
	
	@PrimaryKey
	private String oid;
	
	private String url;
	
	private DomElement anchor;
	
	public Navigation () {
		
	}
	
	public Navigation (String url, DomElement anchor) {
		this.url = url;
		this.anchor = anchor;
	}
	
	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public DomElement getAnchor() {
		return anchor;
	}

	public void setAnchor(DomElement anchor) {
		this.anchor = anchor;
	}
	
	public String toString() {
		return "url: " + this.url + "element: " + this.getAnchor().toString();
	}

	public Navigation clone() {
		return new Navigation (this.getUrl(), this.getAnchor());
	}
}
