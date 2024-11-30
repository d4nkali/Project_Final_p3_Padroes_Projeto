import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;
import material.MaterialSimples;
import material.MaterialComposto;
import material.Material;
import boss.BossAdaptado;
import boss.BossReal;
import jogador.Alquimista;

public class Jogo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		// Formatação para exibição das vidas
		DecimalFormat formatoVida = new DecimalFormat("#0");

		// Loop principal do jogo
		while (true) {
			// Criando materiais disponíveis para coleta (novos a cada rodada)
			MaterialSimples ferro = new MaterialSimples("Ferro", 10 + random.nextDouble() * 10);  // Valor aleatório
			MaterialSimples ouro = new MaterialSimples("Ouro", 15 + random.nextDouble() * 15);   // Valor aleatório
			MaterialSimples madeira = new MaterialSimples("Madeira", 5 + random.nextDouble() * 5); // Valor aleatório
			MaterialSimples cristal = new MaterialSimples("Cristal", 20 + random.nextDouble() * 10); // Valor aleatório

			MaterialComposto espadaComposta = new MaterialComposto("Espada Composta");
			espadaComposta.adicionarMaterial(ferro);
			espadaComposta.adicionarMaterial(ouro);

			// Exibe os materiais para o jogador escolher
			System.out.println("Bem-vindo ao jogo 'The Alchemist'!");
			System.out.print("Digite o seu nome: ");
			String nome = scanner.nextLine();

			Alquimista alquimista = new Alquimista();
			alquimista.definirNome(nome);

			// Criando o Boss
			BossReal bossReal = new BossReal();
			BossAdaptado boss = new BossAdaptado(bossReal);

			// Loop de turno do jogo
			while (alquimista.estaVivo() && boss.estaVivo()) {
				// Limpa os materiais do jogador para garantir que só materiais da rodada atual sejam considerados
				alquimista.limparMateriais();

				// Exibe os materiais disponíveis para o jogador escolher
				System.out.println("\n### Materiais disponíveis nesta rodada ###");
				System.out.println("1. Ferro");
				System.out.println("2. Ouro");
				System.out.println("3. Madeira");
				System.out.println("4. Cristal");
				System.out.println("5. Espada Composta (Ferro + Ouro)");

				// Seleção de materiais (dois por turno)
				System.out.println("\nEscolha dois materiais para coletar:");

				// Loop para garantir que o jogador escolha materiais válidos
				Material material1 = null;
				Material material2 = null;
				boolean escolhasValidas = false;

				while (!escolhasValidas) {
					System.out.print("Escolha o primeiro material (1-5): ");
					int escolha1 = scanner.nextInt();
					System.out.print("Escolha o segundo material (1-5): ");
					int escolha2 = scanner.nextInt();
					scanner.nextLine(); // Limpa a linha

					// Atribui os materiais baseados na escolha do jogador
					material1 = escolherMaterial(escolha1, ferro, ouro, madeira, cristal, espadaComposta);
					material2 = escolherMaterial(escolha2, ferro, ouro, madeira, cristal, espadaComposta);

					if (material1 != null && material2 != null) {
						escolhasValidas = true;
					} else {
						System.out.println("Escolhas inválidas! Tente novamente.");
					}
				}

				// Coleta os materiais selecionados
				if (material1 != null) {
					alquimista.coletarMaterial(material1);
				}
				if (material2 != null) {
					alquimista.coletarMaterial(material2);
				}

				// Criar arma após coletar os materiais
				alquimista.criarArma();

				// Turno do jogador (dano recalculado)
				double danoJogador = alquimista.atacar();
				System.out.println("\n" + alquimista.getNome() + " ataca o boss com " + danoJogador + " de dano.");
				boss.receberDano(danoJogador);

				// Se o boss morrer, termina o jogo
				if (!boss.estaVivo()) {
					System.out.println("\n### O Boss foi derrotado! ###");
					break;
				}

				// Turno do boss (dano aleatório)
				double danoBoss = bossReal.atacar();
				System.out.println("O Boss ataca " + alquimista.getNome() + " causando " + danoBoss + " de dano.");
				alquimista.receberDano(danoBoss);

				// Exibe a vida atual de ambos com formatação
				System.out.println("\n### Status Atual ###");
				System.out.println("Vida do " + alquimista.getNome() + ": " + formatoVida.format(alquimista.getVida()));
				System.out.println("Vida do Boss: " + formatoVida.format(bossReal.getVida()));
				System.out.println("------------------------------------------");
			}

			// Verifica quem foi o vencedor
			if (alquimista.estaVivo()) {
				// Se o alquimista estiver vivo, ele venceu
				System.out.println("\n" + alquimista.getNome() + " Mandou o Oponente para o Lobby!");
				System.out.println("O Boss foi jogar no Vasco.");
			} else {
				// Caso contrário, o boss venceu
				System.out.println("\nO Boss Mandou o "+ alquimista.getNome() +" para o Lobby!");
				System.out.println(alquimista.getNome() + " foi jogar no Vasco.");
			}

			// Pergunta ao jogador se deseja jogar novamente
			System.out.print("Deseja jogar novamente? (s/n): ");
			String resposta = scanner.nextLine();
			if (resposta.equalsIgnoreCase("n")) {
				break; // Encerra o jogo
			}
		}

		scanner.close();
	}

	// Método para escolher material, retorna null se a escolha for inválida
	private static Material escolherMaterial(int escolha, MaterialSimples ferro, MaterialSimples ouro, MaterialSimples madeira, MaterialSimples cristal, MaterialComposto espadaComposta) {
		switch (escolha) {
			case 1:
				return ferro;
			case 2:
				return ouro;
			case 3:
				return madeira;
			case 4:
				return cristal;
			case 5:
				return espadaComposta;
			default:
				return null;
		}
	}
}
