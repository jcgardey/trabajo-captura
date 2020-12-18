package org.gardey;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class DomElement {
	
	@PrimaryKey
	private String oid;
	
	private String url;
	private String xpath;
	
	private String html;
	
	public DomElement () {
		
	}
	
		
	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public DomElement(String url, String xpath) {
		this.url = url;
		this.xpath = xpath;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getXpath() {
		return xpath;
	}
	public void setXpath(String xpath) {
		this.xpath = xpath;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}
	
	public String toString() {
		return this.url;
	}
}
