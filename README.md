# Projeto Final Padroes de Projeto p3

# The Alchemist

**The Alchemist** é um jogo em Java onde você controla um Alquimista, coleta materiais, cria armas e enfrenta um poderoso Boss.

## 💡 Funcionalidades

- Coletar materiais para criar armas.
- Utilizar armas para atacar o Boss.
- Cada turno apresenta novos materiais aleatórios.
- Boss com ataques dinâmicos e vida ajustável.
- Combate por turnos até que um dos lados vença.

## 🛠️ Estrutura do Código

### Classes Principais

1. **Arma**
   - Classe abstrata que define armas e suas propriedades.
   - Subclasses:
     - `ArmaBasica`: Representa uma arma simples.
     - `ArmaComBonusAtaque`: Permite adicionar bônus ao ataque.

2. **Material**
   - Representa os materiais que podem ser coletados.
   - Tipos:
     - `MaterialSimples`: Um único material com valor específico.
     - `MaterialComposto`: Combinação de materiais simples.

3. **Boss**
   - `BossReal`: Representa o inimigo com ataques dinâmicos e vida ajustável.
   - `BossAdaptado`: Adapta a lógica do `BossReal` para ser utilizada no jogo.

4. **Alquimista**
   - O personagem controlado pelo jogador.
   - Pode coletar materiais, criar armas e atacar o Boss.

5. **Jogo**
   - Contém a lógica principal, incluindo:
     - Loop de turnos.
     - Coleta de materiais.
     - Combate entre o Alquimista e o Boss.
    
## 🎮 Instruções de Jogo

Ao iniciar o jogo, insira o nome do seu personagem.
Escolha dois materiais por turno para criar armas.
Ataque o Boss e defenda-se dos ataques dele.
O jogo termina quando o Boss ou o jogador perder toda a vida.
Ao final, escolha se deseja jogar novamente.

## 🔧 Requisitos

- Java Development Kit (JDK 8 ou superior).
- Editor de texto ou IDE como Eclipse, IntelliJ IDEA ou VSCode.

## 🧱 Melhorias Futuras

- Adicionar mais tipos de materiais e armas.
- Implementar efeitos visuais no terminal.
- Criar múltiplos níveis de Boss.
- Salvar o progresso do jogo.
