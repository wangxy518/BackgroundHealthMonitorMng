package HealthMonitorMng.model;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import HealthMonitorMng.util.JsonDateSerializer;


public class Resource {

	private String id;
	private String name;
	private String url;
	private String comments;
	private String onoff;
	private Date createdatetime;

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getCreatedatetime() {
		return createdatetime;
	}

	public void setCreatedatetime(Date createdatetime) {
		this.createdatetime = createdatetime;
	}

	private String _parentId;

	public String get_parentId() {
		return _parentId;
	}

	public void set_parentId(String _parentId) {
		this._parentId = _parentId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getOnoff() {
		return onoff;
	}

	public void setOnoff(String onoff) {
		this.onoff = onoff;
	}

}
