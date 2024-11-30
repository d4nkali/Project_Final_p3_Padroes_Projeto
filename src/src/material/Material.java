package material;

import java.util.Random;

public abstract class Material {
	private String nome;
	private double valor;  // Este valor será usado para dano

	public Material(String nome) {
		this.nome = nome;
		this.valor = gerarDanoAleatorio();  // Gerando o dano aleatório na criação
	}

	public String getNome() {
		return nome;
	}

	public double getValor() {
		return valor;
	}

	// Método para gerar dano aleatório
	protected double gerarDanoAleatorio() {
		Random rand = new Random();
		return rand.nextInt(16) + 5;  // Dano entre 5 e 20
	}
}
