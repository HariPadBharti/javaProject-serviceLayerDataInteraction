package com.samson.sakilaproject.dao;

import java.util.List;

import com.samson.sakilaproject.dbo.ActorDbo;

public interface IActorDao {
	
	public List<ActorDbo> findAll();
	public ActorDbo findById(int id);
	public int insert(ActorDbo actorDbo);
	

}
