package funcionario;

public class Usuario {
	
	private String nome;
	private int matricula;
	private int senha;
	
	public Usuario (String nome, int matricula, int senha) {
		this.nome = nome;
		this.matricula = matricula;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario{" +
	            "\n  nome='" + nome + '\'' +
	            "\n  matricula=" + matricula +
	            "\n  senha=" + senha +
	            "\n}";
	}
	
	
}
