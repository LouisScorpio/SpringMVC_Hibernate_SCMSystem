package com.bme.scm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 * 
 * @author   LouisScorpio
 * @Company  ZJU.BME
 * @Date     2016Äê5ÔÂ29ÈÕ
 *
 */


@Component
@Scope("prototype")
@Entity
@Table(name="ACCOUNT")
public class Account implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 8971557569763969226L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ACC_ID")
	private Integer accId;

	@Column(name="ACC_LOGIN",length=50)
    private String accLogin;

	@Column(name="ACC_NAME",length=50)
    private String accName;

	@Column(name="ACC_PASS",length=50)
    private String accPass;

    public Integer getAccId() {
        return accId;
    }

    public void setAccId(Integer accId) {
        this.accId = accId;
    }

    public String getAccLogin() {
        return accLogin;
    }

    public void setAccLogin(String accLogin) {
        this.accLogin = accLogin;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getAccPass() {
        return accPass;
    }

    public void setAccPass(String accPass) {
        this.accPass = accPass;
    }
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return "Account [accId=" + accId + ", accLogin=" + accLogin
				+ ", accName=" + accName + ", accPass=" + accPass+ "]";
    }
}