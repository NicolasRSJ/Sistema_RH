package funcionario;

public class Funcionario {
	
	private int id = 0;
	private String nome;
	private int matricula;
	private String cargo;
	private double salario;
	private String dataContratacao;
	private String setor;

	public Funcionario(int id, String nome, int matricula, String cargo, double salario, String dataContratacao, String setor) {
		this.id = id == 0 ? (int) ( Math.random() * 200 ) + 1 : id ;
		this.nome = nome;
		this.matricula = matricula;
		this.cargo = cargo;
		this.salario = salario;
		this.dataContratacao = dataContratacao;
		this.setor = setor;
	}

	public int getId() {
		return id;
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

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(String dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}
	
	public String toString() {
		return "Funcionario{" +
	            "\n  id=" + id +
	            "\n  nome='" + nome + '\'' +
	            "\n  matricula=" + matricula +
	            "\n  cargo='" + cargo + '\'' +
	            "\n  salario=" + salario +
	            "\n  dataContratacao='" + dataContratacao + '\'' +
	            "\n  setor='" + setor + '\'' +
	            "\n}";
	}


}
