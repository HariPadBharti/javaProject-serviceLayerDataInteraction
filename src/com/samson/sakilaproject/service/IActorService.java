package com.samson.sakilaproject.service;

import java.util.List;

import com.samson.sakilaproject.bo.ActorBo;

public interface IActorService {
	
	public List<ActorBo> findAll();
	public ActorBo findById(int id);
	public int insert(ActorBo actorBo);

}
