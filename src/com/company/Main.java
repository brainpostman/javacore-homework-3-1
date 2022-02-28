package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        StringBuilder temptxt = new StringBuilder();
        File src = new File("D://Games/Game/src");
        makeDir(src, temptxt);
        File res = new File("D://Games/Game/res");
        makeDir(res, temptxt);
        File savegames = new File("D://Games/Game/savegames");
        makeDir(savegames, temptxt);
        File temp = new File("D://Games/Game/temp");
        makeDir(temp, temptxt);
        File srcMain = new File("D://Games/Game/src/main");
        makeDir(srcMain, temptxt);
        File srcTest = new File("D://Games/Game/src/test");
        makeDir(srcTest, temptxt);
        File fileMain = new File("D://Games/Game/src/main", "Main.java");
        createFile(fileMain, temptxt);
        File fileUtils = new File("D://Games/Game/src/main", "Utils.java");
        createFile(fileUtils, temptxt);
        File resDrawables = new File("D://Games/Game/res/drawables");
        makeDir(resDrawables, temptxt);
        File resVectors = new File("D://Games/Game/res/vectors");
        makeDir(resVectors, temptxt);
        File resIcons = new File("D://Games/Game/res/icons");
        makeDir(resIcons, temptxt);
        File tempTemp = new File("D://Games/Game/temp", "temp.txt");
        try (FileWriter writer = new FileWriter(tempTemp, false)) {
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
