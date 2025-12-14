# THOSE ANIMATRONICS MEMORIES
## Documento de Design do Jogo (GDD)

---

## 1. VISÃO GERAL

**Título:** Those Animatronics Memories  
**Gênero:** Terror psicológico / Sobrevivência  
**Estilo:** Gameplay estática (inspirado nos jogos clássicos de FNAF)  
**Plataforma alvo:** PC  
**Motor / Linguagem planejada:** Java (IntelliJ IDEA)  

**Frase-tema:** *Some memories don’t reset.*

---

## 2. PREMISSA NARRATIVA

O jogador assume o papel de um homem comum, contratado como **guarda noturno após o incidente da Mordida de 83**, na antiga Fazbear’s Family Dinner.

A pizzaria está **fechada por investigações policiais**, mas a Fazbear Entertainment pressiona para reabrir o local o mais rápido possível.

O protagonista aceita o trabalho mesmo conhecendo os rumores, pois precisa sustentar e custear o tratamento médico de sua filha, que se encontra em **estado terminal**.

A narrativa não é entregue de forma explícita, mas fragmentada por:
- mensagens do Phone Man
- ruídos
- falhas visuais
- comportamento dos animatrônicos
- e pelas próprias mecânicas de sanidade

---

## 3. AMBIENTAÇÃO

**Local:** Sala de segurança de uma pizzaria abandonada

Elementos visuais e sonoros:
- iluminação fraca e instável
- câmeras com falhas e ruídos
- áreas isoladas com vestígios do incidente
- silêncio quebrado por passos, rangidos e estática

A sensação geral é de abandono recente, não de ruína antiga.

---

## 4. SALA DE SEGURANÇA (GAMEPLAY BASE)

O jogador permanece fixo na sala durante as noites.

### Elementos interativos:
- **Computador:** acesso às câmeras
- **Porta à esquerda:** pode ser segurada manualmente
- **Painel de vidro frontal:** visão direta de um corredor
- **Mesa:** esconderijo
- **Luzes:** podem ser desligadas
- **Gaveta:** contém a foto da filha

---

## 5. ANIMATRÔNICOS

### 5.1 Fredbear

- Aproxima-se pelo corredor frontal
- Aparece no painel de vidro
- Ao ser visto, exige que o jogador:
  - apague a luz
  - esconda-se sob a mesa

Fredbear pode:
- atacar
- apenas observar
- ou desaparecer sem explicação

Quanto menor a sanidade, maior a chance de aparições falsas.

---

### 5.2 SpringBonnie

- Ataca pela porta lateral
- Tenta forçar a entrada

Mecânica principal:
- o jogador deve **segurar fisicamente a porta**

Consequências:
- segurar a porta por muito tempo reduz sanidade
- soltar cedo demais pode resultar em ataque

---

## 6. SISTEMA DE SANIDADE MENTAL

A sanidade representa o estado psicológico do protagonista.

### Fontes de perda:
- aparição de animatrônicos
- barulhos repentinos
- vultos nas câmeras
- tempo excessivo segurando a porta
- tempo excessivo escondido sob a mesa

### Recuperação:
- o jogador deve **parar todas as ações**
- abrir a gaveta
- olhar fixamente para a foto da filha

Durante esse tempo:
- o jogador fica completamente vulnerável

---

## 7. COLAPSO MENTAL

Quando a sanidade chega a zero:

1. comandos atrasam
2. ações podem ocorrer automaticamente
3. o jogador não distingue realidade de alucinação

Se o estado persistir:
- ocorre a morte por colapso psicológico / ataque cardíaco

---

## 8. SISTEMA DE CICLOS ("VIDAS")

O jogo não utiliza vidas tradicionais.

O jogador possui **3 ciclos mentais** ao longo de toda a semana.

Cada morte representa uma quebra psicológica.

### Primeira morte:
- tela preta
- respiração pesada
- corte para 6:00 AM
- personagem acorda na sala

### Segunda morte:
- despertar mais brusco
- pequenas falhas visuais
- ruído distante de animatrônico

### Terceira morte:
- personagem acorda
- levanta
- caminha até a saída
- para e encara o animatrônico responsável pela última morte
- sai definitivamente

Texto final:
> *Some memories don’t reset.*

---

## 9. OBJETIVOS SECUNDÁRIOS (PÓS-TURNO)

Ao final de algumas noites, o Phone Man propõe objetivos opcionais.

Exemplos:
- lavar louça na cozinha
- reparar caixa de fusíveis
- limpar o chão
- recolher objetos espalhados

Durante esses objetivos:
- animatrônicos continuam ativos
- a visibilidade é limitada

### Falha em um objetivo:

O jogador pode escolher:

**Reiniciar:**
- objetivo recomeça
- risco aumentado
- morte consome um ciclo mental

**Ignorar:**
- noite termina
- pagamento reduzido
- compromete o Final Bom

---

## 10. PROGRESSÃO DAS NOITES

- **Noite 1–2:** introdução e adaptação
- **Noite 3–4:** sanidade cai mais rápido
- **Noite 5–6:** animatrônicos mais agressivos
- **Noite 7:** ações quase simultâneas

---

## 11. FINAIS

### Final Ruim

O jogador sobrevive à semana, mas:
- não conclui todos os objetivos
- ou sofre colapso psicológico

Cena final:
- hospital
- protagonista ajoelhado ao lado da cama da filha
- monitor cardíaco zerado

---

### Final Bom

Requisitos:
- completar todos os objetivos
- não atingir o terceiro colapso

Cena final:
- praça ensolarada
- protagonista e filha tomando sorvete
- pizzaria reaberta ao fundo

Ambiguidade permanece.

---

## 12. TOM E IDENTIDADE

- terror psicológico acima de jumpscares
- foco em culpa, memória e negação
- atmosfera opressiva e silenciosa

Este jogo não trata monstros como vilões, mas como lembranças que se recusam a desaparecer.
