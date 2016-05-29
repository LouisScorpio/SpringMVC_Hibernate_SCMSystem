package com.bme.scm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="sys_param")
public class SysParam implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2768672857058941094L;

	@Override
	public String toString() {
		return "SysParam [sysParamId=" + sysParamId + ", sysParamField="
				+ sysParamField + ", sysParamValue=" + sysParamValue
				+ ", sysParamText=" + sysParamText + ", sysParamType="
				+ sysParamType + "]";
	}

	@Id
	@Column(name="sys_param_id")
	private Integer sysParamId;

	
	@Column(name="sys_param_field")
    private String sysParamField;

	
	@Column(name="sys_param_value")
    private String sysParamValue;

	
	@Column(name="sys_param_text")
    private String sysParamText;

	
	@Column(name="sys_param_type")
    private String sysParamType;

    public Integer getSysParamId() {
        return sysParamId;
    }

    public void setSysParamId(Integer sysParamId) {
        this.sysParamId = sysParamId;
    }

    public String getSysParamField() {
        return sysParamField;
    }

    public void setSysParamField(String sysParamField) {
        this.sysParamField = sysParamField;
    }

    public String getSysParamValue() {
        return sysParamValue;
    }

    public void setSysParamValue(String sysParamValue) {
        this.sysParamValue = sysParamValue;
    }

    public String getSysParamText() {
        return sysParamText;
    }

    public void setSysParamText(String sysParamText) {
        this.sysParamText = sysParamText;
    }

    public String getSysParamType() {
        return sysParamType;
    }

    public void setSysParamType(String sysParamType) {
        this.sysParamType = sysParamType;
    }
}