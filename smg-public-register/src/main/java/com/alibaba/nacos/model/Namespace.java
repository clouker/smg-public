package com.alibaba.nacos.model;

public class Namespace {

	private String namespace;

	private String namespaceShowName;

	private int quota;

	private int configCount;

	/**
	 * 0 : Global configuration， 1 : Default private namespace ，2 : Custom namespace.
	 */
	private int type;

	public String getNamespaceShowName() {
		return namespaceShowName;
	}

	public void setNamespaceShowName(String namespaceShowName) {
		this.namespaceShowName = namespaceShowName;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public Namespace() {
	}

	public Namespace(String namespace, String namespaceShowName) {
		this.namespace = namespace;
		this.namespaceShowName = namespaceShowName;
	}

	public Namespace(String namespace, String namespaceShowName, int quota, int configCount, int type) {
		this.namespace = namespace;
		this.namespaceShowName = namespaceShowName;
		this.quota = quota;
		this.configCount = configCount;
		this.type = type;
	}

	public int getQuota() {
		return quota;
	}

	public void setQuota(int quota) {
		this.quota = quota;
	}

	public int getConfigCount() {
		return configCount;
	}

	public void setConfigCount(int configCount) {
		this.configCount = configCount;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
