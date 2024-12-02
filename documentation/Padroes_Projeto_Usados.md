## Padrão Decorator

O Decorator é o foco central do pacote arma. Ele permite adicionar funcionalidades a objetos de forma dinâmica, sem modificar as classes existentes.

### Como o Decorator é usado em nosso código:

- Classe Base (Arma): Define a interface comum para todas as armas.

- Implementação Concreta (ArmaBasica): A arma padrão que pode ser usada sozinha ou decorada.

- Decorator Abstrato (ArmaDecorator): Serve como modelo para todos os decoradores, encapsulando uma instância de Arma.

- Decorator Específico (ArmaComBonusAtaque): Adiciona funcionalidade ao calcularAtaque, incrementando o poder da arma com um bônus.

Benefícios:

Extensibilidade: Novos decoradores podem ser criados (ex.: ArmaComEfeitoMagico) sem alterar as classes existentes.

Composição Dinâmica: É possível empilhar decoradores para criar combinações complexas.

---

## Padrão Adapter

O Adapter é o foco central do pacote boss. Ele ajusta a interface de uma classe (no caso BossReal) para torná-la compatível com outra interface definida (Boss).

### Como o Adapter é usado em nosso código:

- Interface (Boss): Define o contrato para os objetos do tipo "boss", com o método essencial atacar(double dano).

- Classe Concreta (BossReal): Implementa a lógica de um chefe no jogo, incluindo gerenciamento de vida, ataques dinâmicos e recebimento de dano.

- Classe Adaptadora (BossAdaptado): Encapsula um objeto de BossReal e adapta seu comportamento para ser compatível com a interface Boss. Além disso, adiciona métodos extras como getVida() e estaVivo().

### Benefícios:

- Compatibilidade: Permite que BossReal, que não implementa diretamente a interface Boss, seja utilizado em sistemas que dependem dessa interface.

- Extensibilidade: Novos comportamentos podem ser adicionados ao adaptador (BossAdaptado) sem modificar BossReal.

- Encapsulamento: Esconde os detalhes internos de BossReal, expondo apenas o que é necessário.

---

## Padrão Composite

O Composite é o foco central do pacote material. Ele permite tratar objetos individuais e composições de objetos de forma uniforme.

### Como o Composite é usado em nosso código:

- Classe Base (Material): Define a interface comum para todos os materiais, simples ou compostos.

- Objeto Folha (MaterialSimples): Representa materiais individuais que possuem um valor próprio fixo.

- Composição (MaterialComposto): Permite agrupar vários materiais (simples ou compostos) e calcular o valor combinado de dano.

### Benefícios:

- Uniformidade: Torna possível manipular MaterialSimples e MaterialComposto de maneira uniforme, utilizando a interface comum.

- Extensibilidade: Novos tipos de materiais podem ser adicionados sem alterar as classes existentes.
