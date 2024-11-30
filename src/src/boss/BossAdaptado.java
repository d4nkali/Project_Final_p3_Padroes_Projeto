package boss;

public class BossAdaptado {
	private BossReal bossReal;

	public BossAdaptado(BossReal bossReal) {
		this.bossReal = bossReal;
	}

	// Método para atacar
	public double atacar() {
		return bossReal.atacar();  // Delegando o ataque para o BossReal
	}

	// Método para receber dano
	public void receberDano(double dano) {
		bossReal.receberDano(dano);  // Delegando o recebimento de dano para o BossReal
	}

	// Método para verificar se o boss está vivo
	public boolean estaVivo() {
		return bossReal.estaVivo();  // Retornando o estado de vida do BossReal
	}

	// Novo método para pegar a vida do boss
	public double getVida() {
		return bossReal.getVida();  // Retorna a vida do BossReal
	}
}
