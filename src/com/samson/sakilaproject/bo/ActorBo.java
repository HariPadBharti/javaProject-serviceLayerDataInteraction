package com.samson.sakilaproject.bo;

public class ActorBo {

	int actorId;
	String firstName;
	String lastName;
	
	public int getActorId() {
		return actorId;
	}
	public void setActorId(int actorId) {
		this.actorId = actorId;
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
	@Override
	public String toString() {
		return "ActorBo [actorId=" + actorId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
	
	
	
	
	
}
