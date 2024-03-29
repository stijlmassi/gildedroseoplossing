**#GILDED ROSE JAVA OPLOSSING - WILLIAM DE CLERCQ 15/01/2024**

In het refactoren van deze klasse moest ik een balans vinden tussen efficiëntie, het verminderen van redundantie, het maximaliseren van leesbaarheid en het vermijden van het creëren van technical debt.

Het belangrijkste idee is om alles zo plat en zelf-ingesloten mogelijk te houden:

- Een andere programmeur moet onmiddellijk begrijpen wat er gebeurt.
- Het verwijderen van een handler is eenvoudig en heeft geen invloed op
  andere handlers.
- Het creëren en toevoegen van handlers (voor nieuwe soorten items) volgens dezelfde logica is ook eenvoudig.
- Geen else statements.
- Zo min mogelijk geneste statements.
- Met als doel self-encapsulation te bevorderen, heb ik ook geen constanten bovenaan de klasse of enums gebruikt.


Ik overweeg hier dat het vermijden van technical debt kosteneffectiever is dan eventuele kleine inefficiënties en redundanties die ik zou kunnen hebben geïntroduceerd.
