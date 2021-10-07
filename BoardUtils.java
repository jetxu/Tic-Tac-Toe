package Swissbank;

public class BoardUtils {

	private BoardUtils() {
		
	}
	
	public static int squareNO2Index(char no) {
		return no-Constants.NO1_START;
	}
	
	public static char squareIndex2No(int idx) {
		return (char)(idx+Constants.NO1_START);
	}
}
