package sistemaRH;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import arquivo.Arquivo;
import funcionario.Funcionario;

public class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		Menus console = new Menus();
		int matricula = 1234;
		String senha = "1234";
		Arquivo arquivo = new Arquivo();
		SistemaRH sistemaRh = new SistemaRH();

		// Implementar depois
		arquivo.verificarArquivo();

		// Interface
		console.interfaceLogin();

		System.out.print("\nInforme a sua matrícula: ");
		matricula = scan.nextInt();

		System.out.print("Informe a senha: ");
		senha = scan.next();

		if (matricula == 1234 && senha.equals("1234")) {
			int opcao;

			do {
				console.interfaceMenu();
				System.out.println("\nInforme a sua opção: ");
				opcao = scan.nextInt();

				switch (opcao) {
				case 1: // Inserir funcionário
					sistemaRh.cadastrarFuncionario();
					break;
					
				case 2: // Atualizar funcionário
					System.out.println("1 - Atualizar o salário de todos os funcionários");
					System.out.println("2 - Atualizar o salário por um determinado setor");
					
					System.out.print("Informe uma opção: ");
					int opcaoSalario = scan.nextInt();
					
					switch (opcaoSalario) {
					case 1:
						break;
					case 2:
						break;
					default:
						System.err.println("[OPS] - Opção inválida!");
					}
					
					break;
					
				case 3: // Remover funcionário
					break;
					
				case 4: // Gerar Relatórios
					System.out.println("1 - Funcionários acima da Média Salarial");
					System.out.println("2 - Funcionários por setor");
					System.out.println("3 - Funcionários por anos de empresa");
					int opcaoRelatorios = scan.nextInt();
					
					switch (opcaoRelatorios) {
					case 1:
						break;
					case 2:
						List<Funcionario> funcionarios;
						funcionarios = arquivo.buscarDadosFuncionarios();
						
						
						System.out.println("passou");
						
						for(Funcionario func : funcionarios) {
							System.out.println(func.toString());
							System.out.println("-----------------");
						}
						break;
					case 3:
						break;
					default:
						System.err.println("[OPS] - Opção inválida!");
						break;
					}
					break;
					
				default:
					System.out.println("[OPÇÃO INVÁLIDA!]");
				}

			} while (opcao != 0);

		} else {
			System.err.println("[OPS] - Matrícula ou senha incorretas!");
		}

	}

}
