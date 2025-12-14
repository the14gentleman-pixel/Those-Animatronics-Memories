# THOSE ANIMATRONICS MEMORIES

## Documento de Design do Jogo (GDD)

---

## 1. VISÃO GERAL

**Título:** Those Animatronics Memories
**Gênero:** Terror psicológico / Sobrevivência
**Estilo:** Gameplay estática (inspirado nos jogos clássicos de FNAF)
**Plataforma alvo:** PC
**Motor / Linguagem planejada:** Java (IntelliJ IDEA)

---

## 2. PREMISSA NARRATIVA

O jogador assume o papel de um homem comum, contratado como **guarda noturno após o incidente da Mordida de 83**, na antiga Fazbear’s Family Dinner.

A pizzaria está **fechada por investigações policiais**, mas a Fazbear Entertainment pressiona para reabrir o local o mais rápido possível.

O protagonista aceita o trabalho mesmo conhecendo os rumores, pois precisa sustentar e custear o tratamento médico de sua filha, que se encontra em **estado terminal**.

A narrativa não é entregue de forma explícita, mas fragmentada por:

* mensagens do Phone Man
* ruídos
* falhas visuais
* comportamento dos animatrônicos
* e pelas próprias mecânicas de sanidade

---

## 3. AMBIENTAÇÃO

**Local:** Sala de segurança de uma pizzaria abandonada

Elementos visuais e sonoros:

* iluminação fraca e instável
* câmeras com falhas e ruídos
* áreas isoladas com vestígios do incidente
* silêncio quebrado por passos, rangidos e estática

A sensação geral é de abandono recente, não de ruína antiga.

---

## 4. SALA DE SEGURANÇA (GAMEPLAY BASE)

O jogador permanece fixo na sala durante as noites.

### Elementos interativos:

* **Computador:** acesso às câmeras
* **Porta à esquerda:** pode ser segurada manualmente
* **Painel de vidro frontal:** visão direta de um corredor
* **Mesa:** esconderijo
* **Luzes:** podem ser desligadas
* **Gaveta:** contém a foto da filha

---

## 5. ANIMATRÔNICOS

### 5.1 Fredbear

* Aproxima-se pelo corredor frontal
* Aparece no painel de vidro
* Ao ser visto, exige que o jogador:

  * apague a luz
  * esconda-se sob a mesa

Fredbear pode:

* atacar
* apenas observar
* ou desaparecer sem explicação

Quanto menor a sanidade, maior a chance de aparições falsas.

---

### 5.2 SpringBonnie

* Ataca pela porta lateral
* Tenta forçar a entrada

Mecânica principal:

* o jogador deve **segurar fisicamente a porta**

Consequências:

* segurar a porta por muito tempo reduz sanidade
* soltar cedo demais pode resultar em ataque

---

## 6. SISTEMA DE SANIDADE MENTAL

A sanidade representa o estado psicológico do protagonista.

### Fontes de perda:

* aparição de animatrônicos
* barulhos repentinos
* vultos nas câmeras
* tempo excessivo segurando a porta
* tempo excessivo escondido sob a mesa

### Recuperação:

* o jogador deve **parar todas as ações**
* abrir a gaveta
* olhar fixamente para a foto da filha

Durante esse tempo:

* o jogador fica completamente vulnerável

---

## 7. COLAPSO MENTAL

Quando a sanidade chega a zero:

1. comandos atrasam
2. ações podem ocorrer automaticamente
3. o jogador não distingue realidade de alucinação

Se o estado persistir:

* ocorre a morte por colapso psicológico / ataque cardíaco

---

## 8. SISTEMA DE CICLOS ("VIDAS")

O jogo **não utiliza vidas tradicionais** e este sistema **não se aplica à parte do escritório**.

Os **ciclos mentais** estão ligados **exclusivamente aos minigames pós-turno** (objetivos opcionais).

Durante a gameplay principal (12AM–6AM), não há limite de tentativas: falhar resulta apenas no reinício da noite.

---

### 8.1 Ciclos por Minigame (Modo Normal)

Cada minigame pós-turno possui **até 3 ciclos mentais próprios**.

Esses ciclos representam a capacidade do protagonista de "forçar-se கொள்ள mentalmente" a continuar tarefas perigosas após um turno exaustivo.

#### Funcionamento:

* Cada morte dentro do minigame consome **1 ciclo**
* Ao perder os 3 ciclos naquele minigame específico:

  * o protagonista desiste da tarefa
  * o objetivo é automaticamente ignorado
  * a noite termina
  * **Frase-tema:** *Some memories don’t reset.*

---

### 8.2 Representação Narrativa das Mortes

As mortes nos minigames **não são mostradas como falhas explícitas**.

Cada colapso segue a lógica onírica:

**Primeiro colapso:**

* tela preta
* respiração pesada
* corte direto para 6:00 AM
* protagonista acorda na sala

**Segundo colapso:**

* despertar brusco
* pequenas falhas visuais no ambiente
* ruído distante de animatrônico

**Terceiro colapso (desistência):**

* protagonista acorda
* permanece sentado por alguns segundos
* levanta lentamente
* decide não continuar a tarefa

Nenhuma morte é confirmada como real.

---

### 8.3 Modo Nightmare

O **Modo Nightmare** altera completamente o peso psicológico dos ciclos.

Neste modo:

* existe um **limite global de 3 ciclos mentais**
* esses ciclos são compartilhados entre **todos os minigames pós-turno da semana**
* perder os 3 ciclos impede qualquer tentativa futura de objetivos opcionais

Consequências narrativas:

* o protagonista demonstra sinais claros de esgotamento extremo
* diálogos do Phone Man tornam-se mais curtos ou ausentes
* algumas Memories tornam-se inacessíveis

O Modo Nightmare não altera os finais padrão, mas **dificulta drasticamente** o acesso ao Final Bom e ao Final Secreto.

Texto exibido ao ativar o modo:

> *You won’t wake up the same way twice.*

---

---

## 9. OBJETIVOS SECUNDÁRIOS (PÓS-TURNO)

Ao final de algumas noites, o Phone Man propõe objetivos opcionais.

Exemplos:

* lavar louça na cozinha
* reparar caixa de fusíveis
* limpar o chão
* recolher objetos espalhados

Durante esses objetivos:

* animatrônicos continuam ativos
* a visibilidade é limitada

### Falha em um objetivo:

O jogador pode escolher:

**Reiniciar:**

* objetivo recomeça
* risco aumentado
* morte consome um ciclo mental

**Ignorar:**

* noite termina
* pagamento reduzido
* compromete o Final Bom

---

## 10. PROGRESSÃO DAS NOITES

* **Noite 1–2:** introdução e adaptação
* **Noite 3–4:** sanidade cai mais rápido
* **Noite 5–6:** animatrônicos mais agressivos
* **Noite 7:** ações quase simultâneas

---

## 11. FINAIS

### Final Ruim

O jogador sobrevive à semana, mas:

* não conclui todos os objetivos
* ou sofre colapso psicológico

Cena final:

* hospital
* protagonista ajoelhado ao lado da cama da filha
* monitor cardíaco zerado

---

### Final Bom

Requisitos:

* completar todos os objetivos
* não atingir o terceiro colapso

Cena final:

* praça ensolarada
* protagonista e filha tomando sorvete
* pizzaria reaberta ao fundo

Ambiguidade permanece.

---

### Final Secreto — *Those Memories That Never Slept*

Este final não depende de dinheiro ou sobrevivência direta, mas da **reconstrução de memórias fragmentadas**.

Durante as noites no escritório e em alguns minigames, o jogador pode encontrar **Memories** — fragmentos jogáveis ou observáveis de lembranças presas ao local.

Essas memórias pertencem principalmente à **Criança Chorona**, vítima da Mordida de 83.

---

## 11.1 SISTEMA DE MEMORIES

As Memories não são coletáveis comuns. Elas só aparecem quando:

* a sanidade está acima de um certo limite (clareza mental)
* o jogador permanece observando algo por tempo demais
* ou quando decide investigar ao invés de se proteger

Cada Memory é apresentada como:

* um breve minigame
* uma cena estática distorcida
* ou um trecho jogável em perspectiva diferente

Não há interface indicando progresso.

---

## 11.2 TIPOS DE MEMORIES

### Memories da Criança Chorona (principais)

* discussões abafadas de adultos
* o palco visto de baixo
* medo intenso de Fredbear
* sensação de abandono

Essas memórias são **emocionais**, não factuais.

---

### Memories dos Animatrônicos (raras)

* falhas de movimento
* comandos sobrepostos
* sensação de estar preso

Não há linguagem humana clara.

---

### Memories de Testemunha (opcional)

* vultos ao longe
* portas se fechando
* alguém observando sem agir

Nunca mostram rostos.

---

## 11.3 CONDIÇÃO PARA O FINAL SECRETO

Para desbloquear o Final Secreto, o jogador deve:

* ativar todas as Memories da Criança Chorona
* sobreviver até o final da Noite 7
* não abandonar o local pela terceira quebra psicológica

O dinheiro e os objetivos secundários **não interferem**.

---

## 11.4 CENA DO FINAL SECRETO

Cena única:

* Tela preta
* Sons distantes da pizzaria em funcionamento
* Riso infantil ecoando lentamente

A imagem surge:

* o palco vazio
* Fredbear desligado
* SpringBonnie imóvel ao fundo

No centro do palco:

* a Criança Chorona
* agora calma
* olhando diretamente para o jogador

Ela dá um passo para trás.

As luzes se apagam.

Última frase na tela:

> *Some memories don’t reset.*
> *Some memories finally rest.*

---

---

## 12. TOM E IDENTIDADE

* terror psicológico acima de jumpscares
* foco em culpa, memória e negação
* atmosfera opressiva e silenciosa

Este jogo não trata monstros como vilões, mas como lembranças que se recusam a desaparecer.
