package ru.job4j.io;

import java.io.*;

public class SaveContent {
    private final File file;

    public SaveContent(File file) {
        this.file = file;
    }

    public synchronized void saveContent(String content) {
        try (BufferedOutputStream output = new BufferedOutputStream(
                new FileOutputStream(file))) {
            output.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
