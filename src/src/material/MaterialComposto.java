package material;

import java.util.ArrayList;
import java.util.List;

public class MaterialComposto extends Material {
	private List<Material> materiais;

	public MaterialComposto(String nome) {
		super(nome);  // Chama o construtor da classe pai (Material)
		this.materiais = new ArrayList<>();  // Inicializa a lista corretamente
	}

	public void adicionarMaterial(Material material) {
		materiais.add(material);
	}

	public List<Material> getMateriais() {
		return materiais;
	}

	@Override
	protected double gerarDanoAleatorio() {
		double danoTotal = 0;
		// Verifica se a lista de materiais não está vazia
		if (materiais != null && !materiais.isEmpty()) {
			for (Material material : materiais) {
				danoTotal += material.getValor();  // Somando o dano de cada material
			}
		}
		return danoTotal;  // Retorna o valor total do dano
	}
}
