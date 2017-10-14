package com.soecode.lyf.entity;

import java.util.List;

public class JsonCode<T> {

	private String statusCode;
	private List<T> data;
	private String tagCode;
	
	public JsonCode() {	}

	/**
	 * @return statusCode
	 */
	public String getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode 要设置的 statusCode
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return data
	 */
	public List<T> getData() {
		return data;
	}

	/**
	 * @param data 要设置的 data
	 */
	public void setData(List<T> data) {
		this.data = data;
	}

	/**
	 * @return tagCode
	 */
	public String getTagCode() {
		return tagCode;
	}

	/**
	 * @param tagCode 要设置的 tagCode
	 */
	public void setTagCode(String tagCode) {
		this.tagCode = tagCode;
	}

	/**
	 * @param statusCode
	 * @param data
	 * @param tagCode
	 */
	public JsonCode(String statusCode, List<T> data, String tagCode) {
		super();
		this.statusCode = statusCode;
		this.data = data;
		this.tagCode = tagCode;
	}

	/* （非 Javadoc）
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "JsonCode [statusCode=" + statusCode + ", data=" + data + ", tagCode=" + tagCode + "]";
	}

	
	
	
	
}
