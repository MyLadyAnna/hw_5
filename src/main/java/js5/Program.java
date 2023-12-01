package js5;

import java.io.File;
import java.nio.file.Path;

public class Program {
    public static void main(String[] args) {

        System.out.println("\nИдет резервное копирование файлов...\n");
        Backup backUpper = new Backup();
        backUpper.filesBackup(Path.of("."));

        System.out.println("\nДерево директорий и файлов:\n");
        Tree.print(new File("."), "", true); // Вызываем метод вывода на печать.
    }
}
