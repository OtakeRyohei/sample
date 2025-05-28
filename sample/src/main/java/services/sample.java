package services;

import java.util.ArrayList;

import beans.Player;

public class sample {
	public static void main(String[] args) {
		ArrayList<Player> players = new ArrayList<>();
		
		PlayerService ps = new PlayerService();
		players = ps.select();
		
		for(Player p : players) {
			System.out.println(p.getName());
		}
	}

}
