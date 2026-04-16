# Dons musikkspill :)

> **Merk:** Alt under er skrevet av KI. Det er bare for at folk skal forstå hva faen som skjer i programmet.

---

## 🎧 Latency (Forsinkelse)



> [!IMPORTANT]
> Hvis du spiller med headset (særlig trådløse), kan det oppstå en forsinkelse mellom lyden og det du ser på skjermen. Du kan justere dette manuelt i koden. Gå til klassen `GameStateData` og finn det statiske feltet for **latency**. Endre verdien her for å synkronisere lyden. 
> 
> * **Negative verdier:** Notene kommer tidligere.
> * **Positive verdier:** Notene kommer senere.
> * **Høyttalere:** Det anbefales **-100** på nivåene som er forhåndslaget av meg.
> * **Egne nivåer:** Du kan sette latency til **0** dersom du bruker samme lydkilde når du spiller som da du lagde nivået.

Beklager for at det er sånn, men jeg orker ikke å lage et system for det. 

---

## ⌨️ Keybinds

| Hånd | Taster |
| :--- | :--- |
| **Høyre hånd** | `Q`, `W`, `E`, `R`, `V` |
| **Venstre hånd** | `B`, `U`, `I`, `O`, `P` |

---

## 🎮 Om spillet

Dette er et musikk‑rytmespill inspirert av **Guitar Hero** og **Osu**. Brukeren kan legge til egne sanger i **MP3‑format** og lage nivåer basert på disse. 

* Under spillingen faller kuler i ulike farger nedover skjermen i takt med musikken. 
* For å få poeng må spilleren trykke på riktig tast til riktig tid, avhengig av kulens farge og posisjon.
* Kulene beveger seg ned mot en linje med fargede, statiske kuler som representerer et gitarbånd. 
* Når en fallende kule ligger over riktig posisjon på båndet, må spilleren trykke på tilsvarende tast.

---

## 🎹 Lage egne nivåer

Spilleren kan lage egne nivåer ved å spille av en sang og trykke på tastene mens musikken spilles. 

* Programmet registrerer tastetrykkene og lagrer dem i en tekstfil. 
* **Viktig:** Du må manuelt opprette en ny `.txt`-fil dersom du ikke ønsker å overskrive et nivå du allerede har mappet tidligere. Denne tekstfilen må inneholde tittelen på sangen i navnet sitt. F.eks. hvis sangen heter "Baby", må .txt filen ha strengen "Baby" i seg. F.eks. "Baby 1.txt" fungerer. 