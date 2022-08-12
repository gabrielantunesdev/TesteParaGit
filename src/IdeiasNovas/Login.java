package IdeiasNovas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Login {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {

		int evento = 1;

		Date horario = new Date();
		Scanner leia = new Scanner(System.in);
		List<Cliente> aprovado = new ArrayList<>();
		Cliente cadastro = new Cliente();

		while (evento == 1) {
			String email = "";
			String senha = "";
			String escolha = "";
			System.out.println("-----------------------");
			System.out.println("1 - Login");
			System.out.println("2 - Ver hora");
			System.out.println("3 - Ver clientes");
			System.out.print("Escolha uma opção: ");
			leia = new Scanner(System.in);
			escolha = leia.next();
			int escolhaOfc = Integer.parseInt(escolha);
			if (escolhaOfc == 1) {
				System.out.println("Adicione um cadastro para prosseguir.");
				System.out.print("Email: ");
				try {
					leia = new Scanner(System.in);
					email = leia.next();

				} catch (NumberFormatException e) {
					System.out.println("Erro na seu login, tente novamente!");
				    escolhaOfc = 1;
				} catch (Exception e) {
					System.out.println("Tente novamente");
					escolhaOfc = 1;
				}

				boolean validacaoEmail = email.matches("\\w+@\\D+\\.\\D{2,3}");
				if (validacaoEmail) {
					System.out.print("Informe uma senha: ");
					try {
						leia = new Scanner(System.in);
						senha = leia.next();
					} catch (Exception e) {
						System.out.println("Tente novamente");
					}
					boolean validacaoSenha = senha.matches("\\w{4,8}");
					cadastro.setEmail(email);
					if (validacaoSenha) {
						cadastro.setSenha(senha);
						System.out.println("\nCliente validado");
						Cliente cadastro1 = new Cliente(cadastro.getEmail(), cadastro.getSenha());
						aprovado.add(cadastro1);
						horario = new Date();
					} else if (validacaoSenha == false) {
						System.out.println("Senha no padrão errado.");
						System.out.println("Mínimo 4 números e no Máximo 8");
					}
			
				} else {
					System.out.println("Ponha um email válido");
					System.out.println("Padrão : abc123@abc.abc");
					
					// Erro, ele retorna o codigo com erro!
					// Resolvido com leia = new Scanner(System.in);
				}
			}
			if (escolhaOfc == 2) {
				horario = new Date();
				System.out.println("\n" + horario);
			}
			if (escolhaOfc == 3) {
				if (aprovado.size() > 0) {
					for (Cliente nomes : aprovado) {
						System.out.println("\n" + nomes);
					}
				} else {
					System.out.println("\nTem ninguem!");
				}
			}

			evento = 1;

		}
		leia.close();

	}
}
