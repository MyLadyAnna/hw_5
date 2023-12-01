package js5;

import java.io.File;

public class Tree {
    public static void main(String[] args) {
        print(new File("."), "", true);
    }

    static void print(File file, String indent, boolean isLast){

        System.out.print(indent);       //отступ
        if (isLast){                    //завершающая ветвь
            System.out.print("└─");
            indent += "  ";             //отступ
        }
        else {                          // промежуточная ветвь
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();
        if (files == null)
            return;

        int subDirTotal = 0;                        // директории
        for (int i = 0; i < files.length; i++){
            if (files[i].isDirectory())
                subDirTotal++;
        }

        int subDirCounter = 0;
        for (int i = 0; i < files.length; i++){
            if (files[i].isDirectory()){
                print(files[i], indent, subDirTotal == ++subDirCounter);
            }
        }

        int subFileTotal = 0;                       // файлы
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile())
                subFileTotal++;
        }

        int subFileCounter = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                print(files[i], indent, subFileTotal == ++subFileCounter);
            }
        }
    }
}
