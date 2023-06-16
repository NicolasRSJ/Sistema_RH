package SistemaRH;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
	 
	
	// Menu de Cadastro de novos Funcionários
	public void cadastrarFuncionario() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Cadastro de Funcionários:");
		System.out.println("Informe as seguintes informações do novo funcionário");
		System.out.println("Nome: ");
		String nome = scanner.next();
		System.out.println("Senha: ");
		int senha = scanner.nextInt();
		System.out.println("Matrícula: ");
		int matricula = scanner.nextInt();
		System.out.println("Cargo: ");
		String cargo = scanner.next();
		System.out.println("Salario: ");
		double salario = scanner.nextDouble();
		System.out.println("Data de Adimissão: ");
		String dataContratacao = scanner.next();
		System.out.println("Setor: ");
		String setor = scanner.next();
		
		Funcionario funcionario = new Funcionario(nome, senha, matricula, cargo, salario, dataContratacao, setor);
		this.funcionario.add(funcionario);
		System.out.println("O novo funcionário " + funcionario + " foi criado com sucesso!");
		
		
		//Escrevendo em um arquivo existente.
		File arquivo = new File("../arquivosDeDados/dadosFuncionarios");
		try {
			FileWriter fw = new FileWriter(arquivo, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(funcionario.getNome());
			bw.newLine();
			
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Lendo Arquivo.
		FileReader lerArquivo;
		try {
			lerArquivo = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(lerArquivo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
		
	}
	
}
