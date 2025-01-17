//■ Dir0
//  –  Dir1
//      ■ Dir11
//          – File1.txt
//          – File2.txt
//          – Dir111
//             ■ File3.txt
//  – Dir2
//      ■ File4.txt
//  – Dir3
//      ■ Dir31
//          – File5.txt
//      ■ Dir32

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

// Za pomocą odpowiednych metod stworzyć strukturę

        Path dir0 = Paths.get("Dir0");
        Path dir1 = dir0.resolve("Dir1");
        Path dir11 = dir1.resolve("Dir11");
        Path dir111 = dir11.resolve("Dir111");
        Path dir2 = dir0.resolve("Dir2");
        Path dir3 = dir0.resolve("Dir3");
        Path dir31 = dir3.resolve("Dir31");
        Path dir32 = dir3.resolve("Dir32");

        // Tworzenie struktury katalogów i plików

        try {
            Files.createDirectories(dir111);
            Files.createDirectories(dir2);
            Files.createDirectories(dir31);
            Files.createDirectories(dir32);

            System.out.println("Struktura katalogów i plików została pomyślnie utworzona.");
        } catch (IOException e) { // Input/Output Exception
            System.err.println("Błąd podczas tworzenia struktury: " + e.getMessage());
        }

        Path file1 = dir11.resolve("File1.txt");
        Path file2 = dir11.resolve("File2.txt");
        Path file3 = dir111.resolve("File3.txt");
        Path file4 = dir2.resolve("File4.txt");
        Path file5 = dir31.resolve("File5.txt");

        try {
            Files.createFile(file1);
        } catch (IOException e) {
            System.err.println("Błąd podczas tworzeniu File1.txt (FileAlreadyExistsException): " + e.getMessage());
        }

// Do pliku File1.txt wkleić dowolny tekst (min. 200 słów) (poza kodem)

        String text = "bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla " +
                "bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla " +
                "bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla " +
                "bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla " +
                "bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla " +
                "bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla " +
                "bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla " +
                "bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla " +
                "bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla " +
                "bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla " +
                "bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla bla " +
                "bla bla bla bla bla bla bla bla bla bla bla bla bla";

        Charset charset = StandardCharsets.UTF_8;
        try (BufferedWriter writer = Files.newBufferedWriter(file1, charset, StandardOpenOption.WRITE)) {
            writer.write(text);
            System.out.println("Tekst został zapisany do File1.txt.");
        } catch (IOException e) {
            System.err.println("Błąd podczas zapisu tekstu do File1.txt: " + e.getMessage());
        }

// Skopiować plik File1.txt do Dir32

        Path dir32File1 = dir32.resolve("File1.txt");
        try {
            Files.copy(file1, dir32File1, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File1.txt został skopiowany do Dir32.");
        } catch (IOException e) {
            System.err.println("Błąd podczas kopiowania File1.txt do Dir32: " + e.getMessage());
        }

// Skopiować zawartość pliku File1.txt do pliku File2.txt zamieniając wszystkie litery a na @

        try {
            List<String> lines = Files.readAllLines(file1, charset);
            for (int i = 0; i < lines.size(); i++) {
                lines.set(i, lines.get(i).replace('a', '@'));
            }
            Files.write(file2, lines, charset, StandardOpenOption.CREATE);
            System.out.println("Zawartość File1.txt została skopiowana do File2.txt z zamianą liter 'a' na '@'.");
        } catch (IOException e) {
            System.err.println("Błąd podczas kopiowania do File2.txt: " + e.getMessage());
        }

// Skopiować zawartość pliku File1.txt do pliku File3.txt od końca

        try {
            List<String> lines = Files.readAllLines(file1, charset);
            try (BufferedWriter writer = Files.newBufferedWriter(file3, charset, StandardOpenOption.CREATE)) {
                for (int i = lines.size() - 1; i >= 0; i--) {
                    writer.write(lines.get(i));
                    writer.newLine();
                }
            }
            System.out.println("Zawartość File1.txt została skopiowana do File3.txt od końca.");
        } catch (IOException e) {
            System.err.println("Błąd podczas kopiowania do File3.txt: " + e.getMessage());
        }

// Skopiować zawartość pliku File1.txt do pliku File4.txt a potem zamienić wszystkie parzyste pozycje od 0 do 200 na spacje

        try {
            List<String> lines = Files.readAllLines(file1, charset);
            Files.write(file4, lines, charset, StandardOpenOption.CREATE);
            try (RandomAccessFile raf = new RandomAccessFile (file4.toFile(), "rw")) {
                for (int i = 0; i < 200 && i < raf.length(); i++) {
                    if (i % 2 == 0) {
                        raf.seek(i);
                        raf.writeByte(' ');
                    }
                }
            }
            System.out.println("Zawartość File1.txt została skopiowana do File4.txt, a parzyste pozycje zostały zamienione na spacje.");
        } catch (IOException e) {
            System.err.println("Błąd podczas manipulacji w File4.txt: " + e.getMessage());
        }

// Wypisać rekurencyjne zawartość katalogu Dir0 wraz z rozmiarami plików

        try {
            Files.walk(dir0)
                    .forEach(path -> {
                        try {
                            if (Files.isRegularFile(path)) {
                                System.out.printf("Plik: %s, Rozmiar: %d bajtów%n", path, Files.size(path));
                            } else {
                                System.out.println("Katalog: " + path);
                            }
                        } catch (IOException e) {
                            System.err.println("Błąd podczas odczytu ścieżki: " + e.getMessage());
                        }
                    });
        } catch (IOException e) {
            System.err.println("Błąd podczas rekurencyjnego przeszukiwania katalogu: " + e.getMessage());
        }
    }
}

