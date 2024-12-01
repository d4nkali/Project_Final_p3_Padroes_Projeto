package arma;

public class ArmaComBonusAtaque extends Arma {
	private Arma armaDecorada;
	private double bonus;

	public ArmaComBonusAtaque(Arma armaDecorada, double bonus) {
		this.armaDecorada = armaDecorada;
		this.bonus = bonus;
	}

	@Override
	public String getNome() {
		return armaDecorada.getNome();
	}

	@Override
	public double getPoderAtaque() {
		return armaDecorada.getPoderAtaque() + bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
}
