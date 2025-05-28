package beans;
//test
import java.time.LocalDate;

public class Player {

	private int id;
	private int country_id;
	private int uniform_num;
	private String position;
	private String name;
	private String club;
	private LocalDate birth;
	private int height;
	private int weight;
	
	
	public Player(int i, int c, int u, String p, String n, String cl, LocalDate b, int h, int w) {
		
		this.id = i;
		this.country_id = c;
		this.uniform_num = u;
		this.position = p;
		this.name = n;
		this.club = cl;
		this.birth = b;
		this.height = h;
		this.weight = w;
		
	}


	public int getId() {
		return id;
	}


	public int getCountry_id() {
		return country_id;
	}


	public int getUniform_num() {
		return uniform_num;
	}


	public String getPosition() {
		return position;
	}


	public String getName() {
		return name;
	}


	public String getClub() {
		return club;
	}


	public LocalDate getBirth() {
		return birth;
	}


	public int getHeight() {
		return height;
	}


	public int getWeight() {
		return weight;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}


	public void setUniform_num(int uniform_num) {
		this.uniform_num = uniform_num;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setClub(String club) {
		this.club = club;
	}


	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}
	

