package com.revature.beans;

import java.io.*;
import java.sql.*;
import java.util.Base64;

import javax.persistence.*;

import org.springframework.beans.factory.*;
import org.springframework.stereotype.Component;

@Component(value = "post")
@Entity
@Table(name = "POST")
public class Post implements InitializingBean, DisposableBean, Serializable {
	private static final long serialVersionUID = 5588324711462153938L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "postSeq")
	@SequenceGenerator(allocationSize = 1, name = "postSeq", sequenceName = "POST_SEQ")
	@Column(name = "POST_ID")
	private int id;

	@Column(name = "POST_FLAG")
	private int flag;

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
	private byte[] image;
	
	@Column(name = "POST_THUMBNAIL")
	private byte[] thumb;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
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

	public byte[] getImage() {
		return image;
	}

	public String getImageString() {
		try {
			if (image == null) {
				return "";
			} else {
				return new String(Base64.getEncoder().encode(image), "UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public byte[] getThumb() {
		return thumb;
	}

	public void setThumb(byte[] thumb) {
		this.thumb = thumb;
	}

	public Post() {
		super();
	}

	public Post(int id, int flag, int parent, Timestamp time, String name, String subject, String comment,
			byte[] image) {
		this();
		this.id = id;
		this.flag = flag;
		this.parent = parent;
		this.time = time;
		this.name = name;
		this.subject = subject;
		this.comment = comment;
		this.image = image;
	}

	@Override
	public String toString() {
		return "Post [POST_ID=" + id + ", POST_PARENT=" + parent + ", POST_TIME=" + time + ", POST_NAME=" + name
				+ ", POST_SUBJECT=" + subject + ", POST_COMMENT=" + comment + ", POST_IMAGE=" + image + "]";
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
	}

}
