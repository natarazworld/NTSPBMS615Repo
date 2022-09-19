package com.nt.service;

import com.nt.model.IPLPlayer;

public interface IIPLPlayMgmtService {
    public   String registerPlayer(IPLPlayer player);
    public  Iterable<IPLPlayer> showAllPlayers();
}
