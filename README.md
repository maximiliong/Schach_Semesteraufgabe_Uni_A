# Semesteraufgabe - Schach
Als Teil des Bachelor Studiengangs Informatik an der Uni Augburg, kann während der Vorlesung "Informatik 2" eine Semesteraufgabe absolviert werden, bei der drei Aufgaben zur Auswahl stehen. Wir haben uns für die Aufgabe entschieden, bei dem das Spiel "Schach" als Videospiel nachgebaut werden muss.
## Systemanforderungen
### Mindestens:
System ist modular und leicht erweiterbar.
 - Zu zweit am selben PC spielbar
 - Vorschau der spielbaren Züge (wenn Mouse-over o. ausgewählt)
 - Siegesbedienung: König wird geschlagen
 - Speichern/Laden des aktuellen Spielstands
### Zusätzlich:
- Besondere Regelungen: "Rochade" & "Bauernumwandlung"
- Mechanismus zur Prävention von "Schachmatt"-Zügen
- Zusätzlicher Spielmodus gegen Computergegner
  (z.B.: Computer wählt zufällige Züge)
### Einschränkungen:
- Implementierung mit Hilfe der Java Version 21
- Benutzung der Standartbibliothek (Ausnahmen: wenn in Aufgabenstellung erwähnt)
- Code orientiert sich an den Vorgaben der Vorlesung
- 3-Schichten-Architektur:
	- grafische Benutzeroberfläche
	- Fachkonzeptschicht
	- persistente Datenhaltung (frei wählbar)
- Designentscheidungen sind begründbar (für spätere Präsentation)
- Dokumentation mit JavaDoc der öffentlichen Schnittstellen
