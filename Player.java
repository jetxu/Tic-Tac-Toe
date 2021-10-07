package Swissbank;

public class Player {

	private String name;
	private String NO;
	
	public String getNO() {
		return NO;
	}

	public void setNO(String nO) {
		NO = nO;
	}

	public Player(String NO) {
		this.NO=NO; 
	}
	
	public Player(String NO,String name) {
		this.NO=NO;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
