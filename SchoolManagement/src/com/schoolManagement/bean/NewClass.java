package com.schoolManagement.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.collections.FactoryUtils;
import org.apache.commons.collections.list.LazyList;

@Entity
@Table(name="newClass")
public class NewClass {
@Id
@GeneratedValue
private int newClassSrNo;

public List<AddSubject> getSubjectAdd() {
	return subjectAdd;
}
public void setSubjectAdd(List<AddSubject> subjectAdd) {
	this.subjectAdd = subjectAdd;
}
public int getNewClassSrNo() {
	return newClassSrNo;
}
public void setNewClassSrNo(int newClassSrNo) {
	this.newClassSrNo = newClassSrNo;
}
public String getClassName() {
	return className;
}
public void setClassName(String className) {
	this.className = className;
}
private String className;
private String schoolId;

public String getSchoolId() {
	return schoolId;
}
public void setSchoolId(String schoolId) {
	this.schoolId = schoolId;
}
@SuppressWarnings("unchecked")
@OneToMany(mappedBy = "addClass", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
private List<AddSubject> subjectAdd=LazyList.decorate(new ArrayList<AddSubject>(),FactoryUtils.instantiateFactory(AddSubject.class));
}

