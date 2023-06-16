package arquivo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.List;
import java.util.Scanner;

import funcionario.Funcionario;

public class Arquivo {
	
	private List<Funcionario> funcionario;
	private File funcionarios = new File("./dados/funcionarios.txt");
	private File usuarios = new File("./dados/usuarios.txt");

	// Método que realiza a verificação se os arquivos necessários para o sistema
	// funcionar existem.
	public void verificarArquivo() throws IOException { // O IOException é utilizado para realizar a trativa do método "createNewFile()".

		// Chamada do método "Exists" que retorna um valor boolean dizendo se o arquivo
		// existe.
		boolean existeFuncionarios = funcionarios.exists();
		boolean existeUsuarios = usuarios.exists();

		// Estrutura de Tratativa: Essa tratativo é composta por uma estrutura de
		// IF/ELSE onde utilizamos o "createNewFile()" para criar o arquivo caso ele não
		// exita.
		if (existeFuncionarios && existeUsuarios == false) { // Caso os dois arquivos não existam crie os dois
			funcionarios.createNewFile();
			usuarios.createNewFile();
		} else if (existeFuncionarios == false) { // Caso o arquivo de Funcionários não exista ele irá criar só ele.
			funcionarios.createNewFile();
		} else if (existeUsuarios == false) { // Caso o arquivo de Usuários não exista ele irá criar só ele.
			usuarios.createNewFile();
		}

	};

	// Função para descobrir o repositórios dos arquivos Funcionários e Usuários.
	public File[] verificarRepositorio() {

		// O método "listFiles" é utilizado para descobrir o repositório de determidado
		// arquivo, ele retorna um Array do tipo File.
		File[] repoFuncionarios = funcionarios.listFiles();
		File[] repoUsuarios = usuarios.listFiles();

		// Menu para escolher qual dos repositórios deseja descobrir.
		Scanner scanner = new Scanner(System.in);
		System.out.println("Existem dois tipos de Repositórios no Sistema: ");
		System.out.println("1 - Funcionários");
		System.out.println("2 - Usuários");
		System.out.println("0 - Sair");
		System.out.println("Qual deseja visualizar -> ");
		int opcao = scanner.nextInt();

		scanner.close();

		// Estrutura de tratativa, que é controlada pela escolha do usuário do sistema.
		switch (opcao) {
		case 1: {
			return repoFuncionarios;
		}
		case 2: {
			return repoUsuarios;
		}
		case 0: {
			return null;
		}
		default:
			throw new IllegalArgumentException("O valor escolhido não existe: " + opcao);
		}

	}

	// Função utilizada para gravar dados do funcionário no arquivo "funcionarios".
	public boolean gravarDadosFuncionario(String dadosFuncionario) throws IOException {// O IOException é utilizado para realizar a trativa do método "close()".
		
		// Essa instaciação por fora é importante para tratativa que é realizada no "finally"
		FileWriter gravarDados = null;
		BufferedWriter tratarDados = null;
		
		// Estrutura de Tentativa: Essa estrutura de código tenta gravar os dados do funcionários no arquivo desejado.
		// Dentro dessa estrutura contem returns onde eles devolvem valores booleans que devem ser tratados nos métodos que utulizarem essa função.
		try {
			gravarDados = new FileWriter(funcionarios, true); // Esse "true" certifica que os dados vão ser adicionados no arquivo não substituidos
			tratarDados = new BufferedWriter(gravarDados);

			tratarDados.write(dadosFuncionario);

			return true;
		} catch (IOException e) {
			return false;
		} finally {
			if (tratarDados != null) {
				tratarDados.close();
			}

			if (gravarDados != null) {
				gravarDados.close();
			}
		}

	}

	// Função utilizada para gravar dados do funcionário no arquivo "usuários".
	public boolean gravarDadosUsuario(String matricula, int senha) throws IOException {// O IOException é utilizado para realizar a trativa do método "close()".
		
		// Essa instaciação por fora é importante para tratativa que é realizada no "finally"
		FileWriter gravarDados = null;
		BufferedWriter tratarDados = null;
		
		// Estrutura de Tentativa: Essa estrutura de código tenta gravar os dados do funcionários no arquivo desejado.
		// Dentro dessa estrutura contem returns onde eles devolvem valores booleans que devem ser tratados nos métodos que utulizarem essa função.
		try {
			String dados = "" + matricula + "\n" + senha;
			gravarDados = new FileWriter(usuarios, true); // Esse "true" certifica que os dados vão ser adicionados no arquivo não substituidos
			tratarDados = new BufferedWriter(gravarDados);

			tratarDados.write(dados);

			return true;
		} catch (IOException e) {
			return false;
		} finally {
			if (tratarDados != null) {
				tratarDados.close(); // Finaliza o BufferedWriter ou o método tratarDados.
			}

			if (gravarDados != null) {
				gravarDados.close(); // Finaliza o FileWriter ou o método gravarDados.
			}
		}

	}
	
	// Função utilizada para realizar a busca dos dados dos funcionários no arquivo "funcionários".
	public List<Funcionario> buscarDadosFuncionarios() throws IOException {
		
		// Essa instaciação por fora é importante para tratativa que é realizada no "finally"
		FileReader lerArquivo = null;
		BufferedReader tratarLeitura = null;
		// Inicianlizando o Array dentro da Função.
		funcionario = null;
		
		// Estrutura de Tentativa: está estrutura de código tentar realizar a leitura de arquivo retornando assim uma Lista.
		try {
			lerArquivo = new FileReader(funcionarios);
			tratarLeitura = new BufferedReader(lerArquivo);
			String linha; // Variável que irá guardar o que está escrito em uma linha do arquivo.			
			
			//Estrutura de Controle: está estrutura ficará em execução enquanto a variável "linha" for diferente de null.
			while((linha = tratarLeitura.readLine()) != null) {
				String[] partes = linha.split(",");

		        String nome = partes[0].substring(partes[0].indexOf("'") + 1, partes[0].lastIndexOf("'"));
		        int senha = Integer.parseInt(partes[1].trim());
		        int matricula = Integer.parseInt(partes[2].trim());
		        String cargo = partes[3].substring(partes[3].indexOf("'") + 1, partes[3].lastIndexOf("'"));
		        double salario = Double.parseDouble(partes[4].trim());
		        String dataContratacao = partes[5].substring(partes[5].indexOf("'") + 1, partes[5].lastIndexOf("'"));
		        String setor = partes[6].substring(partes[6].indexOf("'") + 1, partes[6].lastIndexOf("'"));

		        funcionario.add(new Funcionario(nome, senha, matricula, cargo, salario, dataContratacao, setor));
			}
			
			return funcionario;
		} finally {
			if (tratarLeitura != null) {
				tratarLeitura.close(); // Finaliza o BufferedReader ou o método tratarLeitura.
			}

			if (lerArquivo != null) {
				lerArquivo.close(); // Finaliza o FileReader ou o método lerArquivo.
			}
		}
		
	};
	
}