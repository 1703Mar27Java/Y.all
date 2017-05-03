package com.revature.beans;

import java.io.*;
import java.sql.*;

import javax.persistence.*;

@Entity
@Table(name = "POST")
public class Post implements Serializable {
	private static final long serialVersionUID = 5588324711462153938L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "postSeq")
	@SequenceGenerator(allocationSize = 1, name = "postSeq", sequenceName = "POST_SEQ")
	@Column(name = "POST_ID")
	private int id;

	@Column(name = "POST_PARENT")
	private int parent;

	@Column(name = "POST_TIME")
	private Timestamp time;

	@Column(name = "POST_NAME")
	private String name;

	@Column(name = "POST_SUBJECT")
	private String subject;

	@Column(name = "POST_COMMENT")
	private String comment;

	@Column(name = "POST_IMAGE")
	private InputStream image;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public InputStream getImage() {
		return image;
	}

	public void setImage(InputStream image) {
		this.image = image;
	}

	public Post() {
		super();
	}

	public Post(int id, int parent, Timestamp time, String name, String subject, String comment, InputStream image) {
		this();
		this.id = id;
		this.parent = parent;
		this.time = time;
		this.name = name;
		this.subject = subject;
		this.comment = comment;
		this.image = image;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + id;
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + parent;
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
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
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (id != other.id)
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (parent != other.parent)
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Post [POST_ID=" + id + ", POST_PARENT=" + parent + ", POST_TIME=" + time + ", POST_NAME=" + name
				+ ", POST_SUBJECT=" + subject + ", POST_COMMENT=" + comment + ", POST_IMAGE=" + image + "]";
	}

}
