package com.nt.service;

import java.util.List;

import com.nt.document.Player;

public interface ISportsMgmtService {
    public   String registerPlayerWithSportsAndMedals(Player player);
    public  List<Player> fetchAllPlayersInfo();
}
