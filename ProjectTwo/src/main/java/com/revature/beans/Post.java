package com.revature.beans;

import java.io.InputStream;
import java.io.Serializable;
import java.sql.Timestamp;

public class Post implements Serializable {
	private int POST_ID;
	private int POST_PARENT;
	private Timestamp POST_TIME;
	private String POST_NAME;
	private String POST_SUBJECT;
	private String POST_COMMENT;
	private InputStream POST_IMAGE;

	public int getPOST_ID() {
		return POST_ID;
	}

	public void setPOST_ID(int pOST_ID) {
		POST_ID = pOST_ID;
	}

	public int getPOST_PARENT() {
		return POST_PARENT;
	}

	public void setPOST_PARENT(int pOST_PARENT) {
		POST_PARENT = pOST_PARENT;
	}

	public Timestamp getPOST_TIME() {
		return POST_TIME;
	}

	public void setPOST_TIME(Timestamp pOST_TIME) {
		POST_TIME = pOST_TIME;
	}

	public String getPOST_NAME() {
		return POST_NAME;
	}

	public void setPOST_NAME(String pOST_NAME) {
		POST_NAME = pOST_NAME;
	}

	public String getPOST_SUBJECT() {
		return POST_SUBJECT;
	}

	public void setPOST_SUBJECT(String pOST_SUBJECT) {
		POST_SUBJECT = pOST_SUBJECT;
	}

	public String getPOST_COMMENT() {
		return POST_COMMENT;
	}

	public void setPOST_COMMENT(String pOST_COMMENT) {
		POST_COMMENT = pOST_COMMENT;
	}

	public InputStream getPOST_IMAGE() {
		return POST_IMAGE;
	}

	public void setPOST_IMAGE(InputStream pOST_IMAGE) {
		POST_IMAGE = pOST_IMAGE;
	}

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(int pOST_ID, int pOST_PARENT, Timestamp pOST_TIME, String pOST_NAME, String pOST_SUBJECT,
			String pOST_COMMENT, InputStream pOST_IMAGE) {
		super();
		POST_ID = pOST_ID;
		POST_PARENT = pOST_PARENT;
		POST_TIME = pOST_TIME;
		POST_NAME = pOST_NAME;
		POST_SUBJECT = pOST_SUBJECT;
		POST_COMMENT = pOST_COMMENT;
		POST_IMAGE = pOST_IMAGE;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((POST_COMMENT == null) ? 0 : POST_COMMENT.hashCode());
		result = prime * result + POST_ID;
		result = prime * result + ((POST_IMAGE == null) ? 0 : POST_IMAGE.hashCode());
		result = prime * result + ((POST_NAME == null) ? 0 : POST_NAME.hashCode());
		result = prime * result + POST_PARENT;
		result = prime * result + ((POST_SUBJECT == null) ? 0 : POST_SUBJECT.hashCode());
		result = prime * result + ((POST_TIME == null) ? 0 : POST_TIME.hashCode());
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
		Post other = (Post) obj;
		if (POST_COMMENT == null) {
			if (other.POST_COMMENT != null)
				return false;
		} else if (!POST_COMMENT.equals(other.POST_COMMENT))
			return false;
		if (POST_ID != other.POST_ID)
			return false;
		if (POST_IMAGE == null) {
			if (other.POST_IMAGE != null)
				return false;
		} else if (!POST_IMAGE.equals(other.POST_IMAGE))
			return false;
		if (POST_NAME == null) {
			if (other.POST_NAME != null)
				return false;
		} else if (!POST_NAME.equals(other.POST_NAME))
			return false;
		if (POST_PARENT != other.POST_PARENT)
			return false;
		if (POST_SUBJECT == null) {
			if (other.POST_SUBJECT != null)
				return false;
		} else if (!POST_SUBJECT.equals(other.POST_SUBJECT))
			return false;
		if (POST_TIME == null) {
			if (other.POST_TIME != null)
				return false;
		} else if (!POST_TIME.equals(other.POST_TIME))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Post [POST_ID=" + POST_ID + ", POST_PARENT=" + POST_PARENT + ", POST_TIME=" + POST_TIME + ", POST_NAME="
				+ POST_NAME + ", POST_SUBJECT=" + POST_SUBJECT + ", POST_COMMENT=" + POST_COMMENT + ", POST_IMAGE="
				+ POST_IMAGE + "]";
	}

}
