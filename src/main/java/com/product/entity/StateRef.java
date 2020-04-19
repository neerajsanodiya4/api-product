package com.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "state_ref")
public class StateRef extends BaseEntity {

	private static final long serialVersionUID = -4777211606019741466L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "state_id")
	private int stateId;

	@Column(name = "state_name")
	private String stateName;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "st_country_id")
	private CountryRef countryRef;

	public StateRef() {
	}

	
	public StateRef(int stateId) {
		super();
		this.stateId = stateId;
	}


	public StateRef(int stateId, String stateName,CountryRef countryRef) {

		this.stateId = stateId;
		this.stateName = stateName;
		this.countryRef = countryRef;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}



	

	public CountryRef getCountryRef() {
		return countryRef;
	}

	public void setCountryRef(CountryRef countryRef) {
		this.countryRef = countryRef;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((countryRef == null) ? 0 : countryRef.hashCode());
		result = prime * result + stateId;
		result = prime * result + ((stateName == null) ? 0 : stateName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StateRef other = (StateRef) obj;
		if (countryRef == null) {
			if (other.countryRef != null)
				return false;
		} else if (!countryRef.equals(other.countryRef))
			return false;
		
		if (stateId != other.stateId)
			return false;
		if (stateName == null) {
			if (other.stateName != null)
				return false;
		} else if (!stateName.equals(other.stateName))
			return false;
		return true;
	}

}
