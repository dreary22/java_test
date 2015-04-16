package com.pbm;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BusinessSystems {

	public List<BusinessSystem> businessSystems;

	@XmlElementWrapper(name="BusinessSystems")
	@XmlElement(name="BusinessSystem")
	public List<BusinessSystem> getBusinessSystems() {
		return businessSystems;
	}

	public void setBusinessSystems(List<BusinessSystem> businessSystems) {
		this.businessSystems = businessSystems;
	}
	
}
