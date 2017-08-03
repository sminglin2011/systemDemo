package com.sm.system.domain.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class SystemUser implements Serializable{

	@Override
	public boolean equals(Object arg0) {
		return arg0.equals(this.toString());
	}

	@Override
	public int hashCode() {
		return this.getUsername().hashCode();
	}

	@Override
	public String toString() {
		return this.getUsername();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;
    private String password;

    public SystemUser(){}

    public SystemUser(SystemUser user){
        this.username = user.getUsername();
        this.password = user.getPassword();
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
