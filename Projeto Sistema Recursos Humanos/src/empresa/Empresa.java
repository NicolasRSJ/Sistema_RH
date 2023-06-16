package empresa;

public class Empresa {
	
	private String nome;
    
	private String CNPJ;
	
    public Empresa(String nome, String cNPJ) {
		this.nome = nome;
		CNPJ = cNPJ;
	}
	
    
    public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
    
    
}
