package BL;

import java.util.ArrayList;

import po.MatchShortPO;
import Data.MatchDataService;
import Data.MatchData_Impl;
import vo.MatchShortVO;
import vo.MatchVO;

public class MatchBL_Impl implements MatchBL{
   MatchDataService match=new MatchData_Impl();

public ArrayList<MatchVO> getMatchByPlayer(String player) {
	// TODO Auto-generated method stub
	ArrayList<MatchVO>list=new ArrayList<MatchVO>();
	if(match.getMatchByPlayer(player)!=null){
		for(int i=0;i<match.getMatchByPlayer(player).size();i++){
			list.add(new MatchVO(match.getMatchByPlayer(player).get(i)));
		}
		return list;
	}else{
		return null;
	}
}

public ArrayList<MatchVO> getMatchByTeam(String team) {
	// TODO Auto-generated method stub
	ArrayList<MatchVO>list=new ArrayList<MatchVO>();
	if(match.getMatchByTeam(team)!=null){
		for(int i=0;i<match.getMatchByTeam(team).size();i++){
			list.add(new MatchVO(match.getMatchByTeam(team).get(i)));
		}
		return list;
	}else{
		return null;
	}
}

public ArrayList<MatchVO> getMatchByTime(String time) {
	// TODO Auto-generated method stub
	ArrayList<MatchVO>list=new ArrayList<MatchVO>();
	if(match.getMatchByTime(time)!=null){
		for(int i=0;i<match.getMatchByTime(time).size();i++){
			list.add(new MatchVO(match.getMatchByTime(time).get(i)));
		}
		return list;
	}else{
		return null;
	}
}

public ArrayList<MatchVO> getRecentMatchByPlayer(String playerName) {
	// TODO Auto-generated method stub
	ArrayList<String> nameList=new ArrayList<String>();
	nameList=match.getMatchNamesByPlayer(playerName);
	nameList.sort(null);
	ArrayList<MatchVO> list=new ArrayList<MatchVO>();
	if(nameList.size()<5){
		for(int i=nameList.size()-1;i>=0;i--){
			list.add(new MatchVO(match.getMatchByName(nameList.get(i))));
		}
	}else{
		for(int i=nameList.size()-1;i>nameList.size()-6;i--){
		list.add(new MatchVO(match.getMatchByName(nameList.get(i))));
	}
	}
	
	return list;
}

public ArrayList<MatchVO> getRecentMatchByTeam(String teamName) {
	// TODO Auto-generated method stub
	ArrayList<String> nameList=new ArrayList<String>();
	nameList=match.getMatchNamesByTeam(teamName);
	nameList.sort(null);
	ArrayList<MatchVO> list=new ArrayList<MatchVO>();
	for(int i=nameList.size()-1;i>nameList.size()-6;i--){
		list.add(new MatchVO(match.getMatchByName(nameList.get(i))));
	}
	return list;
}

public ArrayList<MatchShortVO> getRecentShortMatchByTeam(String teamName) {
	// TODO Auto-generated method stub
	ArrayList<MatchShortPO> polist=match.getRecentShortMatchByTeam(teamName);
	
	if(polist!=null){
		ArrayList<MatchShortVO> list=new ArrayList<MatchShortVO>();
		for(int i=0;i<polist.size();i++){
			list.add(new MatchShortVO(polist.get(i)));		
		}
		return list;
	}else{
		return null;
	}
}

public ArrayList<MatchShortVO> getRecentShortMatchByPlayer(String playerName) {
	// TODO Auto-generated method stub
ArrayList<MatchShortPO> polist=match.getRecentShortMatchByPlayer(playerName);
	
	if(polist!=null){
		ArrayList<MatchShortVO> list=new ArrayList<MatchShortVO>();
		for(int i=0;i<polist.size();i++){
			list.add(new MatchShortVO(polist.get(i)));		
		}
		return list;
	}else{
		return null;
	}
}

public ArrayList<MatchShortVO> getShortMatchByPeriod(String beginTime,
		String endTime) {
	// TODO Auto-generated method stub
ArrayList<MatchShortPO> polist=match.getShortMatchByPeriod(beginTime, endTime);
	
	if(polist!=null){
		ArrayList<MatchShortVO> list=new ArrayList<MatchShortVO>();
		for(int i=0;i<polist.size();i++){
			list.add(new MatchShortVO(polist.get(i)));		
		}
		return list;
	}else{
		return null;
	}
}

public ArrayList<MatchShortVO> getAllMatch() {
	// TODO Auto-generated method stub
ArrayList<MatchShortPO> polist=match.getAllMatch();
	
	if(polist!=null){
		ArrayList<MatchShortVO> list=new ArrayList<MatchShortVO>();
		for(int i=0;i<polist.size();i++){
			list.add(new MatchShortVO(polist.get(i)));		
		}
		return list;
	}else{
		return null;
	}
}

public MatchVO getMatchByName(String name) {
	// TODO Auto-generated method stub
	return new MatchVO(match.getMatchByName(name));
}

}
