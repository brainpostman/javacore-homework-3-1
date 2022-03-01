package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        StringBuilder temptxt = new StringBuilder();
        List<File> folders = Arrays.asList(
                new File("D://Games/Game/src"),
                new File("D://Games/Game/res"),
                new File("D://Games/Game/savegames"),
                new File("D://Games/Game/temp"),
                new File("D://Games/Game/src/main"),
                new File("D://Games/Game/src/test"),
                new File("D://Games/Game/res/drawables"),
                new File("D://Games/Game/res/vectors"),
                new File("D://Games/Game/res/icons"));
        List<File> files = Arrays.asList(
                new File("D://Games/Game/src/main", "Main.java"),
                new File("D://Games/Game/src/main", "Utils.java"));
        for (File folder : folders) {
            makeDir(folder, temptxt);
            if (folder.getPath().contains("main")) {
                for (File file : files) {
                    createFile(file, temptxt);
                }
            }
        }
        try (FileWriter writer = new FileWriter(new File("D://Games/Game/temp", "temp.txt"), false)) {
            writer.write(temptxt.toString());
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void makeDir(File dir, StringBuilder sb) {
        String message = dir.mkdir() ? "Папка " + dir.getName() + " успешно создана." : "Не удалось создать папку " + dir.getName() + ".";
        sb.append(message).append("\n");
    }

    public static void createFile(File file, StringBuilder sb) {
        try {
            String message = file.createNewFile() ? "Файл " + file.getName() + " успешно создан." : "Не удалось создать файл " + file.getName() + ".";
            sb.append(message).append("\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
