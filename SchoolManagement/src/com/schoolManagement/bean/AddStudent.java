package com.schoolManagement.bean;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="student")
@org.hibernate.annotations.Entity(
		dynamicUpdate = true
)
public class AddStudent implements Serializable{
@Id
private String rollNo;
private long uniqueId;
private String stuFirstName;
private String stuMiddleName;
private String stuLastName;
private String motherName;
private String nationality;
private String motherTongue;
private String religion;
private String cast;
private String subCast;
private String birthPlace;
private String taluka;
private String district;
private String state;
private String country;
private String dob;
private String gender;
private String language;
private long mobileNo;
private long bankAccNo;
private String category;
private String previousSchName;
private String previousSchClass;
/*private String schoolName;
public String getSchoolName() {
	return schoolName;
}
public void setSchoolName(String schoolName) {
	this.schoolName = schoolName;
}*/
private String division;
private String stream;
private String standard;
private String bankName;
private String branchOrIfsc;
public String getBankName() {
	return bankName;
}
public void setBankName(String bankName) {
	this.bankName = bankName;
}
public String getBranchOrIfsc() {
	return branchOrIfsc;
}
public void setBranchOrIfsc(String branchOrIfsc) {
	this.branchOrIfsc = branchOrIfsc;
}
public String getStandard() {
	return standard;
}
public void setStandard(String standard) {
	this.standard = standard;
}
@Id
private String schoolId;
private String approver1Status;
private String approver2Status;

public String getApprover1Status() {
	return approver1Status;
}
public void setApprover1Status(String approver1Status) {
	this.approver1Status = approver1Status;
}
public String getApprover2Status() {
	return approver2Status;
}
public void setApprover2Status(String approver2Status) {
	this.approver2Status = approver2Status;
}
public String getRollNo() {
	return rollNo;
}
public void setRollNo(String rollNo) {
	this.rollNo = rollNo;
}
public long getUniqueId() {
	return uniqueId;
}
public void setUniqueId(long uniqueId) {
	this.uniqueId = uniqueId;
}
public String getStuFirstName() {
	return stuFirstName;
}
public void setStuFirstName(String stuFirstName) {
	this.stuFirstName = stuFirstName;
}
public String getStuMiddleName() {
	return stuMiddleName;
}
public void setStuMiddleName(String stuMiddleName) {
	this.stuMiddleName = stuMiddleName;
}
public String getStuLastName() {
	return stuLastName;
}
public void setStuLastName(String stuLastName) {
	this.stuLastName = stuLastName;
}
public String getMotherName() {
	return motherName;
}
public void setMotherName(String motherName) {
	this.motherName = motherName;
}
public String getNationality() {
	return nationality;
}
public void setNationality(String nationality) {
	this.nationality = nationality;
}
public String getMotherTongue() {
	return motherTongue;
}
public void setMotherTongue(String motherTongue) {
	this.motherTongue = motherTongue;
}
public String getReligion() {
	return religion;
}
public void setReligion(String religion) {
	this.religion = religion;
}
public String getCast() {
	return cast;
}
public void setCast(String cast) {
	this.cast = cast;
}
public String getSubCast() {
	return subCast;
}
public void setSubCast(String subCast) {
	this.subCast = subCast;
}
public String getBirthPlace() {
	return birthPlace;
}
public void setBirthPlace(String birthPlace) {
	this.birthPlace = birthPlace;
}
public String getTaluka() {
	return taluka;
}
public void setTaluka(String taluka) {
	this.taluka = taluka;
}
public String getDistrict() {
	return district;
}
public void setDistrict(String district) {
	this.district = district;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getLanguage() {
	return language;
}
public void setLanguage(String language) {
	this.language = language;
}
public long getMobileNo() {
	return mobileNo;
}
public void setMobileNo(long mobileNo) {
	this.mobileNo = mobileNo;
}
public long getBankAccNo() {
	return bankAccNo;
}
public void setBankAccNo(long bankAccNo) {
	this.bankAccNo = bankAccNo;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getPreviousSchName() {
	return previousSchName;
}
public void setPreviousSchName(String previousSchName) {
	this.previousSchName = previousSchName;
}
public String getPreviousSchClass() {
	return previousSchClass;
}
public void setPreviousSchClass(String previousSchClass) {
	this.previousSchClass = previousSchClass;
}

public String getDivision() {
	return division;
}
public void setDivision(String division) {
	this.division = division;
}
public String getStream() {
	return stream;
}
public void setStream(String stream) {
	this.stream = stream;
}
public String getSchoolId() {
	return schoolId;
}
public void setSchoolId(String schoolId) {
	this.schoolId = schoolId;
}
}
@Embeddable
class AddStuKey {
   	String rollNo ;
    String schoolId ;
}
