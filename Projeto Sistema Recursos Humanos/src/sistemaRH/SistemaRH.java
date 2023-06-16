package sistemaRH;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import empresa.Empresa;
import funcionario.Funcionario;

public class SistemaRH {
	private Empresa empresa;
	private List<Funcionario> funcionario;
	
	public SistemaRH() {
		this.funcionario = new ArrayList<>();
	}
	 
	
	// Menu de Cadastro de novos Funcionários.
	public void cadastrarFuncionario() {
		
		// Menu de solicitação de dados do funcionários.
		Scanner scanner = new Scanner(System.in);
		System.out.println("Cadastro de Funcion�rios:");
		System.out.println("Informe as seguintes informa��es do novo funcion�rio");
		System.out.println("Nome: ");
		String nome = scanner.next();
		System.out.println("Senha: ");
		int senha = scanner.nextInt();
		System.out.println("Matr�cula: ");
		int matricula = scanner.nextInt();
		System.out.println("Cargo: ");
		String cargo = scanner.next();
		System.out.println("Salario: ");
		double salario = scanner.nextDouble();
		System.out.println("Data de Adimiss�o: ");
		String dataContratacao = scanner.next();
		System.out.println("Setor: ");
		String setor = scanner.next();
		
		scanner.close();
		
		// Criando um novo funcionário com os dados solicitados.
		Funcionario funcionario = new Funcionario(nome, senha, matricula, cargo, salario, dataContratacao, setor);
		// Adicionando o funcionário criado no ArrayList funcionario.
		this.funcionario.add(funcionario);
		System.out.println("O novo funcionário " + funcionario + " foi criado com sucesso!");	
		
	}
	
}
