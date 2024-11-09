package com.restonic4.serverdaw;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.fabricmc.api.ModInitializer;

import javax.swing.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ServerDaw implements ModInitializer {
    public static String customName = null;

    @Override
    public void onInitialize() {
        try {
            String path = new File("config/username_config.json").getAbsolutePath();
            String content = new String(Files.readAllBytes(Paths.get(path)));
            JsonObject json = JsonParser.parseString(content).getAsJsonObject();
            customName = json.get("username").getAsString();
        } catch (Exception e) {
            System.err.println("Could not read the file. " + e.getMessage());
            customName = "Guest";
        }
        System.out.println("Name changed: " + customName);
    }

    public static String getName() {
        return customName;
    }
}
