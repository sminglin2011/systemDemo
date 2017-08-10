package com.sm.system.domain.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sm.system.util.SystemUtil;
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

	@Column(nullable = false, unique = true)
    private String username;
    private String password;
    private String email;
    private String expired;

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

	public String getExpired() {
		try {
			if (SystemUtil.isEmpty(this.expired)){
				return this.expired;
			} else {
				return SystemUtil.desDecrypt(this.expired);
			}
		} catch (Exception e) {
			System.out.println("这里错了");
			e.printStackTrace();
		}
		return this.expired;
	}

	public void setExpired(String expired) {
		this.expired = expired;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
