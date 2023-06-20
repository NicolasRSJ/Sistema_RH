package sistemaRH;

import java.util.Scanner;



public class Main {
	static Scanner scan =new Scanner(System.in);
	public static void main(String[] args) {
		Menus console = new Menus();
		int matricula;
		String senha;
		int aux_loopLogin = 0; 
		int aux_loopMenu = 0;
		
		while(aux_loopLogin != 1) {
			console.interfaceLogin();
			System.out.println("Matricula: ");
			matricula = scan.nextInt();
			System.out.println("Senha: ");
			senha = scan.next();
			
			// Criar metodo Verificar matricula e senha retornando um boolean -  if true aux_loopLogin = 1	
			if(matricula == 1234 && senha.equals(senha)){
				System.out.println("  Acesso efetuado com sucesso!");
				aux_loopLogin = 1;
			}
		}		
		while(aux_loopMenu != 1) {
			console.interfaceMenu();
			aux_loopMenu = 1;
		}
		
		
	}

}
