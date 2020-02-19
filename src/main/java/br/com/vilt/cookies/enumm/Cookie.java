package br.com.vilt.cookies.enumm;

public enum Cookie {
	
	PROXIMO(1),
	AUSENTE(2),
	FERIAS(3);
	
	private int status;
	
	
	Cookie(int status){
		this.status=status;
	}
	
	public int get() {return status;}
	

}
