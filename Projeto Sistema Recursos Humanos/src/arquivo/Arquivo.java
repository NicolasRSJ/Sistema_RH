package arquivo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import funcionario.Funcionario;
import funcionario.Usuario;

public class Arquivo {
	
	private List<Funcionario> funcionario = new ArrayList<>();
	private List<Usuario> usuario = new ArrayList<>();
	private File funcionarios = new File("funcionarios.txt");
	private File usuarios = new File("usuarios.txt");

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
		if ((existeFuncionarios == false) && (existeUsuarios == false)) { // Caso os dois arquivos não existam crie os dois
			funcionarios.createNewFile();
			usuarios.createNewFile();
			gravarDadosUsuario("Administrador do Sistema," + 2054 + "," + 2054);
		} else if (existeFuncionarios == false) { // Caso o arquivo de Funcionários não exista ele irá criar só ele.
			funcionarios.createNewFile();
		} else if (existeUsuarios == false) { // Caso o arquivo de Usuários não exista ele irá criar só ele.
			usuarios.createNewFile();
			gravarDadosUsuario("Administrador do Sistema," + 2054 + "," + 2054);
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
	public boolean gravarDadosUsuario(String dadosUsuario) throws IOException {// O IOException é utilizado para realizar a trativa do método "close()".
		
		// Essa instaciação por fora é importante para tratativa que é realizada no "finally"
		FileWriter gravarDados = null;
		BufferedWriter tratarDados = null;
		
		// Estrutura de Tentativa: Essa estrutura de código tenta gravar os dados do funcionários no arquivo desejado.
		// Dentro dessa estrutura contem returns onde eles devolvem valores booleans que devem ser tratados nos métodos que utulizarem essa função.
		try {
			gravarDados = new FileWriter(usuarios, true); // Esse "true" certifica que os dados vão ser adicionados no arquivo não substituidos
			tratarDados = new BufferedWriter(gravarDados);

			tratarDados.write(dadosUsuario);

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
	    try {
	        Scanner scanner = new Scanner(funcionarios);

	        while (scanner.hasNextLine()) {
	            String linha = scanner.nextLine().trim(); // Remover espaços em branco do início e do fim da linha

	            // Verificar se a linha está vazia ou contém apenas espaços em branco
	            if (linha.isEmpty()) {
	                continue; // Pular para a próxima iteração do loop
	            }

	            String[] campos = linha.split(",");

	            // Verificar se a linha possui todos os campos esperados
	            if (campos.length == 7) {
	                int id = Integer.parseInt(campos[0]);
	                String nome = campos[1];
	                int matricula = Integer.parseInt(campos[2]);
	                String cargo = campos[3];
	                double salario = Double.parseDouble(campos[4]);
	                String dataContratacao = campos[5];
	                String setor = campos[6];

	                funcionario.add(new Funcionario(id, nome, matricula, cargo, salario, dataContratacao, setor));
	            } else {
	                System.out.println("Linha inválida: " + linha);
	            }
	        }

	    } catch (FileNotFoundException e) {
	        System.out.println("Arquivo não encontrado: " + funcionarios);
	        e.printStackTrace();
	    }

	    return funcionario;
	}
	
	// Função utilizada para realizar a busca dos dados dos usuários do sistema no arquivo "usuarios".
	public List<Usuario> buscarDadosUsuarios() throws IOException {
		
		try {
            Scanner scanner = new Scanner(usuarios);
            
            while (scanner.hasNextLine()) {
            	 String linha = scanner.nextLine().trim(); // Remover espaços em branco do início e do fim da linha

 	            // Verificar se a linha está vazia ou contém apenas espaços em branco
 	            if (linha.isEmpty()) {
 	                continue; // Pular para a próxima iteração do loop
 	            }
   
 	           String[] campos = linha.split(",");
 	            
                // Verifica se a linha possui todos os campos esperados
                if (campos.length == 3) {
                	
                    String nome = campos[0];
                    int matricula = Integer.parseInt(campos[1]);
                    int senha = Integer.parseInt(campos[2]);
                    
                    usuario.add(new Usuario(nome, matricula, senha));
                } else {
                	System.out.println("Linha inválida: " + linha);
                }
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + funcionarios);
            e.printStackTrace();
        }
        
        return usuario;
		
	}
	
	@SuppressWarnings("unused")
	// Função utilizada para realizar a exclusão dos dados de um funcionário especifico do sistema no arquivo "funcionario".
	public boolean deletarFuncionario(Funcionario dados, List<Funcionario> dadosFuncionario) throws IOException {

	    // Estrutura de Repetição: que percorre o objeto "Usuario" na lista "dadosUsuarios".
	    Iterator<Funcionario> iterator = dadosFuncionario.iterator();
	    while (iterator.hasNext()) {
	        Funcionario funcionario = iterator.next();
	        // Estrutura de Controle: Se a matrícula do objeto Usuario for igual à matrícula informada pelo usuário, ele exclui os dados. 
	        if (funcionario.getMatricula() == dados.getMatricula()) {
	            iterator.remove();
	            break;
	        }
	    }

	    // Estrutura de Tentativa: utilizada para reescrever os dados do arquivo "usuarios".
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(funcionarios, false))) {
	        for (Funcionario funcionario : dadosFuncionario) {
	            writer.write(funcionario.toString());
	            writer.newLine();
	        }
	        writer.close();
	        return true;
	    } catch (IOException e) {
	        return false;
	    }
	}

	
	@SuppressWarnings("unused")
	// Função utilizada para realizar a exclusão dos dados de um funcionário especifico do sistema no arquivo "usuarios".
	public boolean deletarUsuarios(Usuario dados, List<Usuario> dadosUsuarios) throws IOException {

	    // Estrutura de Repetição: que percorre o objeto "Usuario" na lista "dadosUsuarios".
	    Iterator<Usuario> iterator = dadosUsuarios.iterator();
	    while (iterator.hasNext()) {
	        Usuario usuario = iterator.next();
	        // Estrutura de Controle: Se a matrícula do objeto Usuario for igual à matrícula informada pelo usuário, ele exclui os dados.
	        
	        if(dados.getMatricula() == 2054) {
	        	break;
	        }
	        
	        if (usuario.getMatricula() == dados.getMatricula()) {
	            iterator.remove();
	            break;
	        }
	        
	        
	    }

	    // Estrutura de Tentativa: utilizada para reescrever os dados do arquivo "usuarios".
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(usuarios, false))) {
	        for (Usuario usuario : dadosUsuarios) {
	            writer.write(usuario.toString());
	            writer.newLine();
	        }
	        writer.close();
	        return true;
	    } catch (IOException e) {
	        return false;
	    }
	}
	
	@SuppressWarnings("unused")
	// Função utilizada para realizar a atualização dos dados de um funcionário especifico do sistema no arquivo "usuarios".
	public boolean atualizarDadosFuncionarios(Funcionario dados, List<Funcionario> dadosFuncionarios) throws IOException {
		// Reutilização da Função "buscarDadosFuncionarios".		
		
		// Estrutura de Repetição: que percorre o objeto "Funcionario" na lista "dadosFuncionarios".
		for ( Funcionario funcionario : dadosFuncionarios ) {
			// Estrutura de Controle: Se o id do objeto Funcionario for igual ao do dados informados pelo usuário, ele irá atualizar os dados. 
			if(funcionario.getId() == dados.getId()) {
				funcionario.setNome(dados.getNome());
				funcionario.setMatricula(dados.getMatricula());
				funcionario.setCargo(dados.getCargo());
				funcionario.setSalario(dados.getSalario());
				funcionario.setDataContratacao(dados.getDataContratacao());
				funcionario.setSetor(dados.getSetor());
				break;
			}
		}
		
		// Estrutura de Tentativa: utilizada para reescrever os dados do arquivo "funcionarios".
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(funcionarios))){
			for( Funcionario funcionario : dadosFuncionarios ) {
				writer.write(funcionario.toString());
				writer.newLine();
			}
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	@SuppressWarnings("unused")
	// Função utilizada para realizar a atualização dos dados de um funcionário especifico do sistema no arquivo "usuarios".
	public boolean atualizarDadoUsuarios(Usuario dados, List<Usuario> dadosUsuarios ) throws IOException {
		
		// Estrutura de Repetição: que percorre o objeto "Usuario" na lista "dadosUsuarios".
		for ( Usuario usuario : dadosUsuarios ) {
			// Estrutura de Controle: Se a matrícula do objeto Usuario for igual ao do dados informados pelo usuário, ele irá atualizar os dados. 
			if(usuario.getMatricula() == dados.getMatricula()) {
				usuario.setNome(dados.getNome());
				usuario.setMatricula(dados.getMatricula());
				usuario.setSenha(dados.getSenha());
				break;
			}
		}
		
		// Estrutura de Tentativa: utilizada para reescrever os dados do arquivo "usuarios".
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(funcionarios))){
			for( Usuario usuario : dadosUsuarios ) {
				writer.write(usuario.toString());
				writer.newLine();
			}
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	
}
