package sistemaRH;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import arquivo.Arquivo;
import funcionario.Funcionario;

public class SistemaRH {
	private List<Funcionario> funcionarios;
	Arquivo arquivo = new Arquivo();

	public SistemaRH() throws IOException {
		this.funcionarios = arquivo.buscarDadosFuncionarios();
	}

	// Menu de Cadastro de novos Funcionários.
	public void cadastrarFuncionario() throws IOException {

		// Menu de solicitação de dados do funcionários.
		Scanner scanner = new Scanner(System.in);
		System.out.println("Cadastro de Funcionários:");
		System.out.println("Informe as seguintes informações do novo funcionário");

		System.out.print("Nome: ");
		String nome = scanner.next();

		System.out.print("Matrícula: ");
		int matricula = scanner.nextInt();

		System.out.print("Cargo: ");
		String cargo = scanner.next();

		System.out.print("Salario: ");
		double salario = scanner.nextDouble();

		System.out.print("Data de Adimiss�o: ");
		String dataContratacao = scanner.next();

		System.out.print("Setor: ");
		String setor = scanner.next();

		// Criando um novo funcionário com os dados solicitados.
		Funcionario funcionario = new Funcionario(0, nome, matricula, cargo, salario, dataContratacao, setor);
		// Adicionando o funcionário criado no ArrayList funcionario.

		if (arquivo.gravarDadosFuncionario(funcionario.toString())) {
			this.funcionarios.add(funcionario);
			System.out.println("O novo funcionário " + funcionario.getNome() + " foi criado com sucesso!");
		} else {
			System.err.println("[OPS] - Erro ao cadastrar um novo funcionário!");
		}

	}

	public void alterarSalarioDeTodos(double percentualAumento) throws IOException {
		for (Funcionario func : funcionarios) {
			func.setSalario(func.getSalario() + (func.getSalario() * (percentualAumento) / 100));
			arquivo.atualizarDadosFuncionarios(func, funcionarios);
		}
	}

	public void alterarSalarioPorSetor(String setor, double percentualAumento) throws IOException {
		for (Funcionario func : funcionarios) {
			if (func.getSetor().equalsIgnoreCase(setor)) {
				func.setSalario(func.getSalario() + (func.getSalario() * (percentualAumento) / 100));
				arquivo.atualizarDadosFuncionarios(func, funcionarios);
			}
		}
	}

	public List<Funcionario> listarFuncionarios() {
		return funcionarios;
	}

	public void listarFuncionariosPorSetor(String setor) {
		for (Funcionario func : funcionarios) {
			if (func.getSetor().equalsIgnoreCase(setor)) {
				System.out.println("-------------");
				System.out.println("Nome: " + func.getNome());
				System.out.println("Matrícula: " + func.getMatricula());
				System.out.println("Cargo: " + func.getCargo());
				System.out.println("Salário: " + func.getSalario());
				System.out.println("Data de Contratação: " + func.getDataContratacao());
				System.out.println("Setor: " + func.getSetor());
				System.out.println("-------------");
			}
		}
	}

	public void listarFuncionariosAcimaMedia() {
		double mediaSalarial = 0;
		for (Funcionario func : funcionarios) {
			mediaSalarial += func.getSalario();
		}

		mediaSalarial = mediaSalarial / funcionarios.size();

		for (Funcionario func : funcionarios) {
			if (func.getSalario() >= mediaSalarial) {
				System.out.println("-------------");
				System.out.println("Nome: " + func.getNome());
				System.out.println("Matrícula: " + func.getMatricula());
				System.out.println("Cargo: " + func.getCargo());
				System.out.println("Salário: " + func.getSalario());
				System.out.println("Data de Contratação: " + func.getDataContratacao());
				System.out.println("Setor: " + func.getSetor());
				System.out.println("-------------");
			}
		}
	}

	public void listarFuncionariosPorAnos(int anos) {
		int anoAtual = LocalDate.now().getYear();
		int anoAdmissao, anosDeEmpresa;

		for (Funcionario func : funcionarios) {
			anoAdmissao = Integer.parseInt(func.getDataContratacao().substring(func.getDataContratacao().length() - 4));
			anosDeEmpresa = anoAtual - anoAdmissao;

			if (anosDeEmpresa >= anos) {
				System.out.println("-------------");
				System.out.println("Nome: " + func.getNome());
				System.out.println("Matrícula: " + func.getMatricula());
				System.out.println("Cargo: " + func.getCargo());
				System.out.println("Salário: " + func.getSalario());
				System.out.println("Data de Contratação: " + func.getDataContratacao());
				System.out.println("Setor: " + func.getSetor());
				System.out.println("-------------");
			}

		}
	}
	
	public void demitirFuncionario(int matricula) throws IOException {
		for(Funcionario func : funcionarios) {
			if(func.getMatricula() == matricula) {
				arquivo.deletarFuncionario(func, funcionarios);
				break;
			}
		}
	}
	
	
	

}
