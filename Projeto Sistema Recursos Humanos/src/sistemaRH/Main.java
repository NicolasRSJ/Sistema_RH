package sistemaRH;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import arquivo.Arquivo;
import funcionario.Usuario;

public class Main {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		Menus console = new Menus();
		int matricula;
		int senha;
		Arquivo arquivo = new Arquivo();
		SistemaRH sistemaRh = new SistemaRH();
		List<Usuario> usuarios = arquivo.buscarDadosUsuarios();
		
		// Implementar depois
		arquivo.verificarArquivo();

		// Interface
		console.interfaceLogin();

		System.out.print("\nInforme a sua matrícula: ");
		matricula = scan.nextInt();

		System.out.print("Informe a senha: ");
		senha = scan.nextInt();

		for(Usuario usuario : usuarios) {
			
			if ((matricula == usuario.getMatricula()) && (senha == usuario.getSenha())) {
				int opcao;
				
				System.out.println("\n\n");
				System.out.println("===========================================");
		        System.out.println("||       Bem-vindo ao Sistema de RH!     ||");
		        System.out.println("||                                       ||");
		        System.out.println("||       Seu portal para gerenciamento   ||");
		        System.out.println("||       eficiente de Recursos Humanos.  ||");
		        System.out.println("||                                       ||");
		        System.out.println("===========================================");
		        System.out.println("\n\n");
				
				do {
					console.interfaceMenu();
					System.out.print("\nInforme a sua opção: ");
					opcao = scan.nextInt();

					switch (opcao) {
					case 1: // Inserir funcionário
						System.out.println("\n=-=-=-=-=-=- ADMITIR FUNCIONÁRIO =-=-=-=-=-=-");
						sistemaRh.cadastrarFuncionario();
						break;
						
					case 2: // Atualizar funcionário
						System.out.println("\n=-=-=-=-=-=- ALTERAR SALÁRIO =-=-=-=-=-=-");
						System.out.println("1 - Atualizar o salário de todos os funcionários");
						System.out.println("2 - Atualizar o salário por um determinado setor");
						
						System.out.print("Informe uma opção: ");
						int opcaoSalario = scan.nextInt();
						
						switch (opcaoSalario) {
						case 1:
							System.out.println("\n____________ ALTERAR SALÁRIO DE TODOS OS FUNCIONÁRIOS ____________");
							System.out.print("Informe o percentual de aumento: ");
							double percentualTdsFuncs = scan.nextDouble();
							
							sistemaRh.alterarSalarioDeTodos(percentualTdsFuncs);
							
							break;
						case 2:
							System.out.println("\n____________ ALTERAR SALÁRIO POR SETOR ____________");
							
							System.out.print("Informe o setor: ");
							String setor = scan.next();
							
							System.out.print("Informe o percentual de aumento: ");
							double percentualSetor = scan.nextDouble();
							
							sistemaRh.alterarSalarioPorSetor(setor, percentualSetor);
							
							break;
						default:
							System.err.println("[OPS] - Opção inválida!");
						}
						
						break;
						
					case 3: // Remover funcionário
						System.out.println("\n=-=-=-=-=-=- DEMITIR FUNCIONÁRIO =-=-=-=-=-=-");
						System.out.print("Informe a matrícula do funcionário: ");
						int matriculaDemissao = scan.nextInt();
						
						sistemaRh.demitirFuncionario(matriculaDemissao);
						break;
						
					case 4: // Gerar Relatórios
						System.out.println("\n=-=-=-=-=-=- RELATÓRIOS =-=-=-=-=-=-");
						System.out.println("1 - Funcionários acima da Média Salarial");
						System.out.println("2 - Funcionários por setor");
						System.out.println("3 - Funcionários por anos de empresa");
						
						System.out.print("Informe sua opção: ");
						int opcaoRelatorios = scan.nextInt();
						
						switch (opcaoRelatorios) {
						case 1:
							System.out.println("\n____________ Acima da Média Salarial ____________");
							
							sistemaRh.listarFuncionariosAcimaMedia();
							break;
						case 2:
							System.out.println("\n____________ Funcionários por setor ____________");
							System.out.print("Informe o setor: ");
							String setor = scan.next();
							
							sistemaRh.listarFuncionariosPorSetor(setor);
							break;
						case 3:
							System.out.println("\n____________ Funcionários por anos de empresa ____________");
							System.out.print("Informe a quantidade de anos: ");
							int quantAnos = scan.nextInt();
							
							sistemaRh.listarFuncionariosPorAnos(quantAnos);
							
							break;
						default:
							System.err.println("[OPS] - Opção inválida!");
							break;
						}
						break;
						
					case 0:
						System.out.println("\n=-=-=-=-=-=- SAIR =-=-=-=-=-=-");
						System.out.println("\nSaindo...");
						System.out.println("Obrigado por utilizar o sistema!");
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

}
