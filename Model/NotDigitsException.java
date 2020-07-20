package Model;

public class NotDigitsException extends Exception {
	private String msg;

	public NotDigitsException(String msg){
		this.msg = msg;
	}
	
	public String getMessage(){
		return msg;
	}
}
