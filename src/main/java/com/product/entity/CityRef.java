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
@Table(name = "city_ref")
public class CityRef extends BaseEntity {

	private static final long serialVersionUID = -4777211606019741466L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "city_id")
	private int cityId;

	@Column(name = "city_name")
	private String cityeName;


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ci_state_id")
	private StateRef stateRef;

	public CityRef() {

	}

	public CityRef(int cityId) {
		super();
		this.cityId = cityId;
	}

	public CityRef(int cityId, String cityeName, StateRef stateRef) {
		super();
		this.cityId = cityId;
		this.cityeName = cityeName;
		this.stateRef = stateRef;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityeName() {
		return cityeName;
	}

	public void setCityeName(String cityeName) {
		this.cityeName = cityeName;
	}


	public StateRef getStateRef() {
		return stateRef;
	}

	public void setStateRef(StateRef stateRef) {
		this.stateRef = stateRef;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cityId;
		result = prime * result + ((cityeName == null) ? 0 : cityeName.hashCode());
		result = prime * result + ((stateRef == null) ? 0 : stateRef.hashCode());
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
		CityRef other = (CityRef) obj;
		if (cityId != other.cityId)
			return false;
		if (cityeName == null) {
			if (other.cityeName != null)
				return false;
		} else if (!cityeName.equals(other.cityeName))
			return false;
		if (stateRef == null) {
			if (other.stateRef != null)
				return false;
		} else if (!stateRef.equals(other.stateRef))
			return false;
		return true;
	}

}