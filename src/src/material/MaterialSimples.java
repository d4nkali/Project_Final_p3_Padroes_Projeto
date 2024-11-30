package material;

public class MaterialSimples extends Material {
	private double valor;

	// Construtor adequado para aceitar nome e valor
	public MaterialSimples(String nome, double valor) {
		super(nome);  // Supondo que a classe Material tenha um construtor que aceite o nome
		this.valor = valor;
	}

	public double getValor() {
		return valor;
	}
}
