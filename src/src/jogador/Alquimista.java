package jogador;

import material.Material;
import arma.Arma;
import arma.ArmaBasica;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Alquimista {
	private String nome;
	private double vida;
	private double dano;  // Dano calculado a cada rodada
	private List<Material> materiais;

	public Alquimista() {
		this.materiais = new ArrayList<>();
		this.vida = 100;  // Vida inicial
	}

	public void definirNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public double getVida() {
		return vida;
	}

	public boolean estaVivo() {
		return vida > 0;
	}

	// Limpa a lista de materiais a cada rodada e adiciona os novos materiais
	public void coletarMaterial(Material material) {
		materiais.add(material);
	}

	public void criarArma() {
		recalcularDano();  // Sempre recalcula o dano após coletar novos materiais
	}

	public void recalcularDano() {
		// Reseta o dano para 0 a cada turno
		this.dano = 0;
		// Somando os valores dos materiais coletados no turno
		for (Material material : materiais) {
			this.dano += material.getValor();  // Somando o valor dos materiais ao dano
		}
	}

	// Método para o jogador atacar, retornando o dano recalculado
	public double atacar() {
		recalcularDano();  // Garantir que o dano seja recalculado a cada vez
		return dano;  // Retorna o dano recalculado para aquele turno
	}

	public void receberDano(double danoRecebido) {
		this.vida -= danoRecebido;
		if (this.vida < 0) {
			this.vida = 0;  // Vida não pode ser menor que 0
		}
	}

	// Método para limpar a lista de materiais no final da rodada (se necessário)
	public void limparMateriais() {
		this.materiais.clear();  // Limpa os materiais para a próxima rodada
	}
}
