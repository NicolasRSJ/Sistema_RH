package sistemaRH;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import arquivo.Arquivo;
import funcionario.Funcionario;

public class SistemaRH {
	private List<Funcionario> funcionarios;
	Arquivo arquivo = new Arquivo();
	
	public SistemaRH() {
		this.funcionarios = new ArrayList<>();
	}
	 
	
	// Menu de Cadastro de novos Funcionários.
	public void cadastrarFuncionario() throws IOException {
		
		// Menu de solicitação de dados do funcionários.
		Scanner scanner = new Scanner(System.in);
		System.out.println("Cadastro de Funcion�rios:");
		System.out.println("Informe as seguintes informa��es do novo funcion�rio");
		
		System.out.println("Nome: ");
		String nome = scanner.next();
		
		System.out.println("Senha: ");
		int matricula = scanner.nextInt();
		
		System.out.println("Cargo: ");
		String cargo = scanner.next();
		
		System.out.println("Salario: ");
		double salario = scanner.nextDouble();
		
		System.out.println("Data de Adimiss�o: ");
		String dataContratacao = scanner.next();
		
		System.out.println("Setor: ");
		String setor = scanner.next();
		
		
		// Criando um novo funcionário com os dados solicitados.
		Funcionario funcionario = new Funcionario(0, nome, matricula, cargo, salario, dataContratacao, setor);
		// Adicionando o funcionário criado no ArrayList funcionario.
		
		if(arquivo.gravarDadosFuncionario(funcionario.toString())) {			
			this.funcionarios.add(funcionario);
			System.out.println("O novo funcionário " + funcionarios + " foi criado com sucesso!");
		} else {
			System.err.println("[OPS] - Erro ao cadastrar um novo funcionário!");
		}
		
		
	}
	
}
