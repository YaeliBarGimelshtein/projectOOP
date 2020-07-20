package Model;

public class TieException extends Exception {
	private String msg;

	public TieException(String msg){
		this.msg = msg;
	}
	
	public String getMessage(){
		return msg;
	}
}
