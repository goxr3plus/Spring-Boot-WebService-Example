package com.example.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("SomeBeanFilter")
//@JsonPropertyOrder(value = { "v1", "v2" })
public class SomeBean {

	private String v1;
//	@JsonIgnore
	private String v2;
	private String v3;

	public SomeBean(String v1, String v2, String v3) {
		super();
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
	}

	/**
	 * @return the v1
	 */
	public String getV1() {
		return v1;
	}

	/**
	 * @param v1 the v1 to set
	 */
	public void setV1(String v1) {
		this.v1 = v1;
	}

	/**
	 * @return the v2
	 */
	public String getV2() {
		return v2;
	}

	/**
	 * @param v2 the v2 to set
	 */
	public void setV2(String v2) {
		this.v2 = v2;
	}

	/**
	 * @return the v3
	 */
	public String getV3() {
		return v3;
	}

	/**
	 * @param v3 the v3 to set
	 */
	public void setV3(String v3) {
		this.v3 = v3;
	}

}
