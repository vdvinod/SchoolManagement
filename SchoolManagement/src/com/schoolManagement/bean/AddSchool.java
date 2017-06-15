package com.schoolManagement.bean;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="school")
@org.hibernate.annotations.Entity(
		dynamicUpdate = true)
		public class AddSchool {
	@Id
	private String schoolId;
	private String schoolName;
	private long contactNo;
	private String principalName;
	private String principalContact;
	private String vicePrincipalName;
	private String vicePrincipalContact;
	private String approverName1;
	private String approverName2;
	private String approverContact1;
	private String approverContact2;
	private String emailSchool;
	private String passwordSchool;
	private String approverEmail1;
	private String approverEmail2;
	private String approverPassword1;
	private String approverPassword2;
	private String senderName;
	private String address;
	private String language;
	
	
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getEmailSchool() {
		return emailSchool;
	}
	public void setEmailSchool(String emailSchool) {
		this.emailSchool = emailSchool;
	}
	public String getPasswordSchool() {
		return passwordSchool;
	}
	public void setPasswordSchool(String passwordSchool) {
		this.passwordSchool = passwordSchool;
	}
	public String getApproverEmail1() {
		return approverEmail1;
	}
	public void setApproverEmail1(String approverEmail1) {
		this.approverEmail1 = approverEmail1;
	}
	public String getApproverEmail2() {
		return approverEmail2;
	}
	public void setApproverEmail2(String approverEmail2) {
		this.approverEmail2 = approverEmail2;
	}
	public String getApproverPassword1() {
		return approverPassword1;
	}
	public void setApproverPassword1(String approverPassword1) {
		this.approverPassword1 = approverPassword1;
	}
	public String getApproverPassword2() {
		return approverPassword2;
	}
	public void setApproverPassword2(String approverPassword2) {
		this.approverPassword2 = approverPassword2;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public long getContactNo() {
		return contactNo;
	}
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	public String getPrincipalName() {
		return principalName;
	}
	public void setPrincipalName(String principalName) {
		this.principalName = principalName;
	}
	public String getPrincipalContact() {
		return principalContact;
	}
	public void setPrincipalContact(String principalContact) {
		this.principalContact = principalContact;
	}
	public String getVicePrincipalName() {
		return vicePrincipalName;
	}
	public void setVicePrincipalName(String vicePrincipalName) {
		this.vicePrincipalName = vicePrincipalName;
	}
	public String getVicePrincipalContact() {
		return vicePrincipalContact;
	}
	public void setVicePrincipalContact(String vicePrincipalContact) {
		this.vicePrincipalContact = vicePrincipalContact;
	}
	public String getApproverName1() {
		return approverName1;
	}
	public void setApproverName1(String approverName1) {
		this.approverName1 = approverName1;
	}
	public String getApproverName2() {
		return approverName2;
	}
	public void setApproverName2(String approverName2) {
		this.approverName2 = approverName2;
	}
	public String getApproverContact1() {
		return approverContact1;
	}
	public void setApproverContact1(String approverContact1) {
		this.approverContact1 = approverContact1;
	}
	public String getApproverContact2() {
		return approverContact2;
	}
	public void setApproverContact2(String approverContact2) {
		this.approverContact2 = approverContact2;
	}


}
