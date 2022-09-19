package com.nt.service;



import com.nt.model.IPLTeam;

public interface IIPLTeamMgmtService {
    public   String  saveTeam(IPLTeam team);
    public   IPLTeam findTeamById(int id);
    public   Iterable<IPLTeam>  findAllTeams();
}
