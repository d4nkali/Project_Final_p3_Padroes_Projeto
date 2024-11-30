package arma;

public abstract class Arma {
	protected String nome;
	protected double poderAtaque;

	public String getNome() {
		return nome;
	}

	public double getPoderAtaque() {
		return poderAtaque;
	}

	public void setPoderAtaque(double poderAtaque) {
		this.poderAtaque = poderAtaque;
	}
}
