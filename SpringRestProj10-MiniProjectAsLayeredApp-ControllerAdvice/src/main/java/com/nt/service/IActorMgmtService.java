//IActorMgmtService.java
package com.nt.service;

import java.util.List;

import com.nt.model.Actor;

public interface IActorMgmtService {
    public   String   registerActor(Actor  actor);
    public   Iterable<Actor> getAllActors();
    public   Actor  getActorById(int id);
    public    List<Actor>  fetchActorsByCategory(String category1,String category2);
    public   String    updateActor(Actor actor);
    public   String    deleteActorById(int id);
    public  String   updateActorMobileNo(int id , long  newMobileNo);
    
}
