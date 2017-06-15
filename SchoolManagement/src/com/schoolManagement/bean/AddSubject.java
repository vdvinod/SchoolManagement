package com.schoolManagement.bean;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@SuppressWarnings("serial")
@Entity
@Table(name="subjectAdd")
public class AddSubject implements Serializable{
@Id
private int srNo;
private String subName;
@Id
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name="newClassSrNo")
NewClass addClass;
public int getSrNo() {
	return srNo;
}
public void setSrNo(int srNo) {
	this.srNo = srNo;
}
public String getSubName() {
	return subName;
}
public void setSubName(String subName) {
	this.subName = subName;
}
public NewClass getAddClass() {
	return addClass;
}
public void setAddClass(NewClass addClass) {
	this.addClass = addClass;
}

}
@Embeddable
class AddKey {
   	int srNo;
    int newClassSrNo ;
}
