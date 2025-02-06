package Entidades;

public enum Funcao {

	OPERADOR("Operador"), 
	COORDENADOR("Coordenador"), 
	DIRETOR("Diretor"),
	RECEPCIONISTA("Recepcionista"),
	CONTADOR("Contador"),
	GERENTE("Gerente"),
	ELETRICISTA("Eletricista");

	private String descricao;

	Funcao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
