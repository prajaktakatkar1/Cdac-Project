package com.sunbeam.dtos;

//  valid for all admin , doctor and patient

public class UserDTO
{
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String contact;
	public UserDTO() {
		super();
	}
	
	
	
	
	public UserDTO(int id, String firstName, String lastName, String email, String password, String contact) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.contact = contact;
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}




	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", contact=" + contact + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
