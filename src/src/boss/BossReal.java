package boss;

import java.util.Random;

public class BossReal {
	private double vida;
	private Random random; // Criar o objeto Random uma vez

	public BossReal() {
		this.vida = 100;  // Vida inicial do Boss
		this.random = new Random(); // Inicializa o Random uma vez
	}

	public double getVida() {
		return vida;
	}

	public boolean estaVivo() {
		return vida > 0;
	}

	public void receberDano(double dano) {
		this.vida -= dano;
		if (this.vida < 0) {
			this.vida = 0;
		}
	}

	// Método para o Boss atacar, com dano aumentado
	public double atacar() {
		// Aumentando o dano do Boss para um intervalo entre 30 e 80
		double danoBoss = 20 + random.nextDouble() * 20;  // Dano entre 20 e 40
		return danoBoss;
	}
}
