//IPLTeamMgmtServiceImpl.java
package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.IPLTeam;
import com.nt.repository.IIPLTeamRepository;

@Service("teamService")
public class IPLTeamMgmtServiceImpl implements IIPLTeamMgmtService {
	@Autowired
	private IIPLTeamRepository  teamRepo;

	@Override
	public String saveTeam(IPLTeam team) {
		return "team is saved with:"+ teamRepo.save(team).getTeamId();
	}

	@Override
	public IPLTeam findTeamById(int id) {
		/*	Optional<IPLTeam> opt=teamRepo.findById(id);
			if(opt.isPresent())
				return opt.get();
			else
				throw new IllegalArgumentException("invalid team id");*/
		return  teamRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("invalid team id"));
		
	}

	@Override
	public Iterable<IPLTeam> findAllTeams() {
	
		return teamRepo.findAll();
	}

}
