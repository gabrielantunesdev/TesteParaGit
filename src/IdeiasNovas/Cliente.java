package IdeiasNovas;

import java.util.Date;

public class Cliente {

	private String email;
	private String senha;
	Date hora = new Date();
	
	Cliente(){
		
	}
	
	Cliente(String email, String senha){
		this.email = email;
		this.senha = senha;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Email: " + email + " - Senha: " + senha + "\n" + "hora: " + hora;
	}
	
	
}
