package com.nt.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.client.IIPLTeamServiceConsumer;
import com.nt.model.IPLPlayer;
import com.nt.model.IPLTeam;
import com.nt.repository.IIPLPlayerRepository;

@Service("playerService")
public class IPLPlayerMgmtServiceImpl implements IIPLPlayMgmtService {
	private static  Logger logger= LoggerFactory.getLogger(IPLPlayerMgmtServiceImpl.class);
	@Autowired
	private IIPLPlayerRepository  playerRepo;
	@Autowired
	private IIPLTeamServiceConsumer  consumer;

	@Override
	public String registerPlayer(IPLPlayer player) {
		//use feign client   MS communication to get IPLTeam info being Palyer service
		  IPLTeam team=consumer.searchTeamById(player.getTeamInfo().getTeamId()).getBody();
		  logger.info(" The consumer Palyer service has consumer team service using feignt client");
		  //assign team Object to player object
		  player.setTeamInfo(team);
		  logger.info(" Player object is saved ...");
		  //save player object
		  return  "player with team details are saved with id value:"+playerRepo.save(player).getPlayerId();
		  
		
	}

	@Override
	public Iterable<IPLPlayer> showAllPlayers() {
		logger.info(" All  Player details retrived");
		return  playerRepo.findAll();
	}

}
