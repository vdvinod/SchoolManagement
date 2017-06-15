package com.schoolManagement.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class NewCategory {
@Id
@GeneratedValue
private int srNo;
private String schoolId;
public int getSrNo() {
	return srNo;
}
public void setSrNo(int srNo) {
	this.srNo = srNo;
}
public String getSchoolId() {
	return schoolId;
}
public void setSchoolId(String schoolId) {
	this.schoolId = schoolId;
}
public String getCategoryName() {
	return categoryName;
}
public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}
private String categoryName;
}
