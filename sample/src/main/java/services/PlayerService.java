package services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Player;
import utils.Db;

public class PlayerService {

	public ArrayList<Player> select() {
		
		String sql = "SELECT * FROM players";
		ArrayList<Player> players = new ArrayList<>();	
		
		try(
			Connection conn = Db.open(); 
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
		){
			while(rs.next()) {
				
				Player a = new Player(
						rs.getInt("id"),
						rs.getInt("country_id"),
						rs.getInt("uniform_num"),
						rs.getString("position"),
						rs.getString("name"),
						rs.getString("club"),
						rs.getDate("birth").toLocalDate(),
						rs.getInt("height"),
						rs.getInt("weight")	
					);			
				players.add(a);
			}	
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
		
		return players;
	}
	
	
	public int insert(Player object) {
		String sql = "insert into players(country_id, uniform_num, position, name, club, birth, height, weight) values (?,?,?,?,?,?,?,?);";
		int id = 0;
		
		try (
				Connection conn = Db.open();
				PreparedStatement stmt = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
			) 
		{
			stmt.setInt(1, object.getCountry_id());
			stmt.setInt(2, object.getUniform_num());
			stmt.setString(3, object.getPosition());
			stmt.setString(4, object.getName());
			stmt.setString(5, object.getClub());
			stmt.setDate(6, Date.valueOf(object.getBirth()));
			stmt.setInt(7, object.getHeight());
			stmt.setInt(8, object.getWeight());
			stmt.executeUpdate();

			ResultSet res = stmt.getGeneratedKeys();//	主キーを取得し、IDに代入
			if (res.next()) {
				id = res.getInt(1);
			}
		} catch (Exception se) {
			se.printStackTrace();
		}
		return id;
	}
	
	public void update(Player object) {
		String sql = "update players set";
		
		sql += " country_id = ?, uniform_num = ?, position = ?, name = ?, club = ?, birth = ?, height = ?, weight= ?";
		sql += " where id = ?";

		try (	Connection conn = Db.open();
				PreparedStatement ps = conn.prepareStatement(sql);
			) 
		{
			ps.setInt(1, object.getCountry_id());
			ps.setInt(2, object.getUniform_num());
			ps.setString(3, object.getPosition());
			ps.setString(4, object.getName());
			ps.setString(5, object.getClub());
			ps.setDate(6, Date.valueOf(object.getBirth()));
			ps.setInt(7, object.getHeight());
			ps.setInt(8, object.getWeight());
			ps.setInt(9, object.getId());
			ps.executeUpdate();

		} catch (Exception se) {
			se.printStackTrace();
		}
	}
	
	public void delete(int id) {
		String sql = "delete from players where id = ?";
		
		
		try (	Connection conn = Db.open();
				PreparedStatement ps = conn.prepareStatement(sql);
			) 
		{
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (Exception se) {
			se.printStackTrace();
		}
	}
	
}
