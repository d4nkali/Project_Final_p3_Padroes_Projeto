package arma;

public abstract class ArmaDecorator extends Arma {
	protected Arma armaDecorada;

	public ArmaDecorator(Arma armaDecorada) {
		this.armaDecorada = armaDecorada;
	}

	public abstract double getAtaque();
}
