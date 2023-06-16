package empresa;

public class Empresa {
	
	private String nome;
    
	private String cnpj;
	
    public Empresa(String nome, String cnpj) {
		this.nome = nome;
		this.cnpj = cnpj;
	}
	
    
    public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCNPJ() {
		return cnpj;
	}
	public void setCNPJ(String cnpj) {
		this.cnpj = cnpj;
	}
    
    
}
