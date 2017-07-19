package com.samson.sakilaproject.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.samson.sakilaproject.bo.ActorBo;
import com.samson.sakilaproject.dao.ActorDao;
import com.samson.sakilaproject.dao.IActorDao;
import com.samson.sakilaproject.dbo.ActorDbo;

public class ActorService implements IActorService {

	@Override
	public List<ActorBo> findAll() {
		List<ActorBo> actorList = new ArrayList<ActorBo>();
		ActorBo actorBo = null;
		IActorDao actorDao = new ActorDao();
		List<ActorDbo> actorsdbo =	actorDao.findAll();
		for(ActorDbo dbo : actorsdbo){
			actorBo = new ActorBo();
			actorBo.setActorId(dbo.getActorId());
			actorBo.setFirstName(dbo.getFirstName());
			actorBo.setLastName(dbo.getLastName());
			actorList.add(actorBo);			
		}
		
		return actorList;
	}

	@Override
	public ActorBo findById(int id) {

		IActorDao actorDao = new ActorDao();
		
	  ActorDbo actorDbo = actorDao.findById(id);
		ActorBo bo = new ActorBo();
		
		bo.setActorId(actorDbo.getActorId());
		bo.setFirstName(actorDbo.getFirstName());
		bo.setLastName(actorDbo.getLastName());
		
		
		/*for(ActorDbo actorDB : actorsDbo) {
			bo = new ActorBo();
			bo.setActorId(actorDB.getActorId());
			bo.setFirstName(actorDB.getFirstName());
			bo.setLastName(actorDB.getLastName());
			actors.add(bo);
		}*/
		System.out.println("resultttt"+bo);
		return bo;
	}
	

	@Override
	public int insert(ActorBo bo) {
		int i =0;
		System.out.println(bo);
		IActorDao dao = new ActorDao();
		ActorDbo dbo = new ActorDbo();
		
		dbo.setActorId(bo.getActorId());
		dbo.setFirstName(bo.getFirstName());
		dbo.setLastName(bo.getLastName());
		
		i = dao.insert(dbo);
		return i;
	
	}
	
	public static void main(String[] args) {
		int i = 0;
		ActorService as = new ActorService();
		ActorBo actorBo = new ActorBo();
		actorBo.setActorId(9998);
		actorBo.setFirstName("hari");
		actorBo.setLastName("hpb");
		i = as.insert(actorBo);
	}

}
