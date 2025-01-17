#### **TASK**

■ Za pomocą odpowiednych metod stworzyć następującą strukturę:
■ Dir0
  –  Dir1
      ■ Dir11
          – File1.txt
          – File2.txt
          – Dir111
             ■ File3.txt
  – Dir2
      ■ File4.txt
  – Dir3
      ■ Dir31
          – File5.txt
      ■ Dir32
■ Do pliku File1.txt wkleić dowolny tekst (min. 200 słów) (poza kodem).
■ W kodzie wykonać następujące operacje:
– Skopiować plik File1.txt do Dir32
– Skopiować zawartość pliku File1.txt do pliku File2.txt zamieniając wszystkie litery a
na @.
– Skopiować zawartość pliku File1.txt do pliku File3.txt od końca.
– Skopiować zawartość pliku File1.txt do pliku File4.txt a potem korzystając z
losowego dostępu do pliku zamienić wszystkie parzyste pozycje od 0 do 200 w pliku
na spacje.
– Wypisać rekurencyjne zawartość katalogu Dir0 wraz z rozmiarami plików.

<br>

```
Struktura katalogów i plików została pomyślnie utworzona.
Tekst został zapisany do File1.txt.
File1.txt został skopiowany do Dir32.
Błąd podczas tworzeniu File1.txt (FileAlreadyExistsException): Dir0/Dir1/Dir11/File1.txt
Zawartość File1.txt została skopiowana do File2.txt z zamianą liter 'a' na '@'.
Zawartość File1.txt została skopiowana do File3.txt od końca.
Zawartość File1.txt została skopiowana do File4.txt, a parzyste pozycje zostały zamienione na spacje.
Katalog: Dir0
Katalog: Dir0/Dir2
Plik: Dir0/Dir2/File4.txt, Rozmiar: 924 bajtów
Katalog: Dir0/Dir3
Katalog: Dir0/Dir3/Dir31
Katalog: Dir0/Dir3/Dir32
Plik: Dir0/Dir3/Dir32/File1.txt, Rozmiar: 923 bajtów
Katalog: Dir0/Dir1
Katalog: Dir0/Dir1/Dir11
Plik: Dir0/Dir1/Dir11/File2.txt, Rozmiar: 924 bajtów
Plik: Dir0/Dir1/Dir11/File1.txt, Rozmiar: 923 bajtów
Katalog: Dir0/Dir1/Dir11/Dir111
Plik: Dir0/Dir1/Dir11/Dir111/File3.txt, Rozmiar: 924 bajtów
```
