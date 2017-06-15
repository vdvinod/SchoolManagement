package com.schoolManagement.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="division")
public class NewDivision {
@Id
@GeneratedValue
private int srNo;
private String newDivision;
public int getSrNo() {
	return srNo;
}
public void setSrNo(int srNo) {
	this.srNo = srNo;
}
public String getNewDivision() {
	return newDivision;
}
public void setNewDivision(String newDivision) {
	this.newDivision = newDivision;
}
private String schoolId;
public String getSchoolId() {
	return schoolId;
}
public void setSchoolId(String schoolId) {
	this.schoolId = schoolId;
}
}
