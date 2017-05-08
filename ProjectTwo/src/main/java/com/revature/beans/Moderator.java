package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component(value = "moderator")
@Entity
@Table(name = "MODERATOR")
public class Moderator implements InitializingBean, DisposableBean, Serializable {
	private static final long serialVersionUID = 5499348097731219585L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modSeq")
	@SequenceGenerator(allocationSize = 1, name = "modSeq", sequenceName = "MOD_SEQ")
	@Column(name = "MOD_ID")
	private int id;
	
	@Column(name = "MOD_USERNAME")
	private String username;
	
	@Column(name = "MOD_PASSWORD")
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
