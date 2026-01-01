# THOSE ANIMATRONICS MEMORIES

## Game Design Document (GDD)

---

## 1. OVERVIEW

**Title:** Those Animatronics Memories
**Genre:** Psychological Horror / Survival
**Style:** Static Gameplay (inspired by classic FNAF games)
**Target Platform:** PC
**Engine:** Clickteam Fusion Developer 25
***Development Note:** The initial prototype was created in Java (IntelliJ IDEA) using Object-Oriented Programming (OOP).*

---

## 2. NARRATIVE PREMISE

The player assumes the role of an ordinary man hired as a **night guard following the "Bite of '83" incident** at the old Fazbear’s Family Diner.

The pizzeria is **closed for police investigation**, but Fazbear Entertainment is pressuring to reopen the location as quickly as possible.

The protagonist accepts the job despite knowing the rumors because he needs to support and pay for the medical treatment of his daughter, who is in a **terminal state**.

The narrative is not delivered explicitly, but fragmented through:

* Phone Man messages
* Noises
* Visual glitches
* Animatronic behavior
* The sanity mechanics themselves

---

## 3. SETTING

**Location:** Security room of an abandoned pizzeria.

Visual and Audio Elements:

* Dim and unstable lighting
* Cameras with glitches and static
* Isolated areas with traces of the incident
* Silence broken by footsteps, creaks, and static

The general feeling is of **recent abandonment**, not ancient ruin.

---

## 4. SECURITY ROOM (CORE GAMEPLAY)

The player remains fixed in the room during the nights.

### Interactive Elements:

* **Computer:** Access to cameras
* **Left Door:** Can be held manually
* **Front Glass Panel:** Direct view of a corridor
* **Desk:** Hiding spot
* **Lights:** Can be turned off
* **Photo:** Viewable while hiding under the desk

---

## 5. ANIMATRONICS

### 5.1 Fredbear

* Approaches through the front corridor
* Appears at the glass panel
* When seen, requires the player to:
  * Turn off the light
  * Hide under the desk

Fredbear may:

* Attack
* Just observe
* Or disappear without explanation

The lower the sanity, the higher the chance of false apparitions.

---

### 5.2 SpringBonnie

* Attacks through the side door
* Tries to force entry

**Core Mechanic:**

* The player must **physically hold the door shut**

**Consequences:**

* Holding the door for too long reduces sanity
* Releasing too early may result in an attack

---

## 6. MENTAL SANITY SYSTEM

Sanity represents the protagonist's psychological state.

### Sources of Sanity Loss:

* Animatronic apparitions
* Sudden noises
* Shadows on the cameras
* Excessive time holding the door
* Excessive time hidden under the desk (without focusing on the photo)

### Recovery:

* The player must **hide under the desk**.
* The photo of the daughter is already with the protagonist.
* While under the desk, the player can view the photo to restore calm.

**During this time:**

* The player is completely vulnerable to outside threats if timed poorly.

---

## 7. MENTAL COLLAPSE

When sanity reaches zero:

1. Commands lag/delay
2. Actions may occur automatically
3. The player cannot distinguish reality from hallucination

If this state persists:

* Death occurs via psychological collapse / heart attack.

---

## 8. CYCLE SYSTEM ("LIVES")

The game **does not use traditional lives**, and this system **does not apply to the office gameplay**.

**Mental Cycles** are linked **exclusively to post-shift minigames** (optional objectives).

During the main gameplay (12 AM–6 AM), there is no limit on attempts: failure simply results in restarting the night.

---

### 8.1 Cycles per Minigame (Normal Mode)

Each post-shift minigame has **up to 3 specific mental cycles**.

These cycles represent the protagonist's capacity to "mentally force himself" to continue dangerous tasks after an exhausting shift.

**Mechanics:**

* Each death within the minigame consumes **1 cycle**.
* Upon losing all 3 cycles in that specific minigame:
  * The protagonist gives up on the task.
  * The objective is automatically ignored.
  * The night ends.
  * **Theme Phrase:** *Some memories don’t reset.*

---

### 8.2 Narrative Representation of Deaths

Deaths in minigames are **not shown as explicit failures**.

Each collapse follows dream logic:

**First Collapse:**

* Black screen
* Heavy breathing
* Direct cut to 6:00 AM
* Protagonist wakes up in the room

**Second Collapse:**

* Abrupt waking
* Small visual glitches in the environment
* Distant animatronic noise

**Third Collapse (Resignation):**

* Protagonist wakes up
* Sits for a few seconds
* Stands up slowly
* Decides not to continue the task

No death is confirmed as real.

---

### 8.3 Nightmare Mode

**Nightmare Mode** completely alters the psychological weight of the cycles.

In this mode:

* There is a **global limit of 3 mental cycles**.
* These cycles are shared across **all post-shift minigames for the entire week**.
* Losing 3 cycles prevents any future attempts at optional objectives.

**Narrative Consequences:**

* The protagonist shows clear signs of extreme exhaustion.
* Phone Man dialogues become shorter or absent.
* Some *Memories* become inaccessible.

Nightmare Mode does not alter the standard endings but **drastically increases the difficulty** of accessing the Good Ending and the Secret Ending.

Text displayed when activating the mode:

> *You won’t wake up the same way twice.*

---

---

## 9. SECONDARY OBJECTIVES (POST-SHIFT)

At the end of some nights, the Phone Man proposes optional objectives.

Examples:

* Washing dishes in the kitchen
* Repairing the fuse box
* Cleaning the floor
* Collecting scattered objects

During these objectives:

* Animatronics remain active
* Visibility is limited

### Failure in an objective:

The player can choose:

**Restart:**

* Objective starts over
* Increased risk
* Death consumes a mental cycle

**Ignore:**

* Night ends
* Reduced payment
* Compromises the Good Ending

---

## 10. NIGHT PROGRESSION

* **Night 1–2:** Introduction and adaptation
* **Night 3–4:** Sanity drops faster
* **Night 5–6:** Animatronics more aggressive
* **Night 7:** Actions are almost simultaneous

---

## 11. ENDINGS

### Bad Ending

The player survives the week, but:

* Does not complete all objectives
* Or suffers a psychological collapse

**Final Scene:**

* Hospital
* Protagonist kneeling beside his daughter's bed
* Heart monitor flatlined

---

### Good Ending

**Requirements:**

* Complete all objectives
* Do not reach the third collapse

**Final Scene:**

* Sunny plaza
* Protagonist and daughter eating ice cream
* Reopened pizzeria in the background

Ambiguity remains.

---

### Secret Ending — *Those Memories That Never Slept*

This ending does not depend on money or direct survival, but on the **reconstruction of fragmented memories**.

During nights in the office and in some minigames, the player can find **Memories**—playable or observable fragments of memories trapped in the location.

These memories belong primarily to the **Crying Child**, victim of the Bite of '83.

---

## 11.1 MEMORY SYSTEM

Memories are not common collectibles. They only appear when:

* Sanity is above a certain limit (mental clarity)
* The player remains observing something for too long
* Or when deciding to investigate instead of protecting oneself

Each Memory is presented as:

* A brief minigame
* A distorted static scene
* Or a playable segment in a different perspective

There is no interface indicating progress.

---

## 11.2 TYPES OF MEMORIES

### Crying Child Memories (Main)

* Muffled adult arguments
* The stage seen from below
* Intense fear of Fredbear
* Feeling of abandonment

These memories are **emotional**, not factual.

---

### Animatronic Memories (Rare)

* Movement glitches
* Overlapping commands
* Sensation of being trapped

There is no clear human language.

---

### Witness Memories (Optional)

* Shadows in the distance
* Doors closing
* Someone watching without acting

Never shows faces.

---

## 11.3 CONDITION FOR THE SECRET ENDING

To unlock the Secret Ending, the player must:

* Activate all Crying Child Memories
* Survive until the end of Night 7
* Not abandon the location via the third psychological break

Money and secondary objectives **do not interfere**.

---

## 11.4 SECRET ENDING SCENE

Unique Scene:

* Black screen
* Distant sounds of the operating pizzeria
* Childish laughter echoing slowly

The image appears:

* The empty stage
* Fredbear powered down
* SpringBonnie motionless in the background

In the center of the stage:

* The Crying Child
* Now calm
* Looking directly at the player

He takes a step back.

The lights go out.

Last phrase on the screen:

> *Some memories don’t reset.*
> *Some memories finally rest.*

---

---

## 12. TONE AND IDENTITY

* Psychological horror over jumpscares
* Focus on guilt, memory, and denial
* Oppressive and silent atmosphere

This game does not treat monsters as villains, but as memories that refuse to disappear.
