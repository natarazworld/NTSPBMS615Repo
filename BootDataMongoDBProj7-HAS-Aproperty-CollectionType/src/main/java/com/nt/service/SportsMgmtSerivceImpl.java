package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.document.Player;
import com.nt.repository.IMedalRepo;
import com.nt.repository.IPlayerRepo;
import com.nt.repository.ISportRepo;

@Service("sportService")
public class SportsMgmtSerivceImpl implements ISportsMgmtService {
	@Autowired
	private IPlayerRepo playerRepo;
	@Autowired
	private  ISportRepo  sportRepo;
	@Autowired
	private  IMedalRepo  medalRepo;

	@Override
	public String registerPlayerWithSportsAndMedals(Player player) {
		return "Player with sports and medal info is saved with "+playerRepo.save(player).getPid()+" id value ";
	}

	@Override
	public List<Player> fetchAllPlayersInfo() {
		return  playerRepo.findAll();  
	}

}
