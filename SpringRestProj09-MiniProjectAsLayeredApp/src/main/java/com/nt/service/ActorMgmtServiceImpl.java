//ActorMgmtServiceImpl.java
package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.exception.ActorNotFoundException;
import com.nt.model.Actor;
import com.nt.repository.IActorRepo;

@Service("actorMgmtService")
public class ActorMgmtServiceImpl implements IActorMgmtService {
	@Autowired
	private IActorRepo  actorRepo;

	@Override
	public String registerActor(Actor actor) {
		  Actor  actorS=actorRepo.save(actor);
		return "Actor is registered with id value ::"+actorS.getActorid();
	}

	/*	@Override
		public Iterable<Actor> getAllActors() {
			Iterable<Actor>  it=actorRepo.findAll();
			List<Actor> list1=(List<Actor>)it;
			list1.sort((t1,t2)->t1.getActorname().compareTo(t2.getActorname()));
			return  list1;
		}*/
	
	/*@Override
	public Iterable<Actor> getAllActors() {
		Iterable<Actor>  it=actorRepo.findAll();
		Collections.sort((List<Actor>) it, (t1,t2)->t1.getActorname().compareTo(t2.getActorname()));
		return  it;
	}*/
	
	@Override
	public Iterable<Actor> getAllActors() {
		Iterable<Actor>  it=actorRepo.findAll();
		List<Actor> list1 = 
				  StreamSupport.stream(it.spliterator(), false).sorted((t1,t2)->t1.getActorname().compareTo(t2.getActorname()))
				    .collect(Collectors.toList());
		return  list1;
	}
	
	
	@Override
	public Actor getActorById(int id) {
		//Actor  actor=actorRepo.findById(id).get();
		//return actor;
		return actorRepo.findById(id).orElseThrow(()->new IllegalArgumentException());
	}
	
	
	@Override
	public List<Actor> fetchActorsByCategory(String category1, String category2) {
		 List<Actor>  list=actorRepo.getActorsByCategories(category1, category2);
		 return list;
	}
	
	
	@Override
	public String updateActor(Actor actor) {
		Optional<Actor> opt=actorRepo.findById(actor.getActorid());
		if(opt.isPresent()) {
			actorRepo.save(actor);  //update object
			return "Actor Information is updated";
		}
		else {
			throw new  ActorNotFoundException("Actor not found");
		}
	}
	
	
	@Override
	public String deleteActorById(int id) {
		Optional<Actor> opt=actorRepo.findById(id);
		if(opt.isPresent()) {
			actorRepo.deleteById(id);
			return "Actor Information is deleted";
		}
		else {
			throw new  ActorNotFoundException("Actor not found");
		}
	}
	
	
	@Override
	public String updateActorMobileNo(int id, long newMobileNo) {
		Optional<Actor> opt=actorRepo.findById(id);
		if(opt.isPresent()) {
			Actor actor=opt.get();
			actor.setMobileNo(newMobileNo);
			actorRepo.save(actor);  //update object
			return "Actor's Mobile Number is  updated";
		}
		else {
			throw new  ActorNotFoundException("Actor not found");
		}
		
	}
	

	
	

}
