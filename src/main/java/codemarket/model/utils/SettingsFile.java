/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codemarket.model.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Luis Resende
 */
public class SettingsFile {
    private static final Properties properties = new Properties();
    private static final String ARQUIVO_CONFIG = "./src/main/resources/config/config.properties";
    private static SettingsFile settingsFile;
    
    public SettingsFile(){
        loadSettings();
    }
    
    public static SettingsFile getInstance() {  
        if (settingsFile == null) {
            synchronized (SettingsFile.class) {
                if (settingsFile == null) {
                        settingsFile = new SettingsFile();                   
                }
            }
        }

        return settingsFile;
    }
    
    public void loadSettings() {
        try (FileInputStream input = new FileInputStream(ARQUIVO_CONFIG)) {
            properties.load(input);

            // Adicione aqui outros valores conforme necessário
        } catch (IOException e) {
            e.printStackTrace();
            // Lidar com exceções de leitura
        }
    }

    public static void saveSettings() {
        try (FileOutputStream output = new FileOutputStream(ARQUIVO_CONFIG)) {
            properties.store(output, null);
        } catch (IOException e) {
            e.printStackTrace();
            // Lidar com exceções de escrita
        }
    }
    
    public void updatePropertiesFile(String primaryThemeColor, String secondThemeColor, String primaryTextColor, String secondTextColor) {
        primaryTextColor = primaryTextColor.replace("#", "");
        primaryTextColor = secondTextColor.replace("#", "");
        primaryTextColor = primaryThemeColor.replace("#", "");
        primaryTextColor = secondThemeColor.replace("#", "");
        properties.setProperty("primaryThemeColor", primaryThemeColor);
        properties.setProperty("secondThemeColor", secondThemeColor);
        properties.setProperty("primaryTextColor", primaryTextColor);
        properties.setProperty("secondTextColor", secondTextColor);
        properties.setProperty("primaryIconColor", secondTextColor);
        saveSettings();
        updateCSSFile();
        
    }

    public void updateCSSFile() {
        CSSFile cssM = new CSSFile();
        boolean sucess = cssM.setSettings(properties.getProperty("primaryTextColor"), properties.getProperty("secondTextColor"), properties.getProperty("primaryThemeColor"), properties.getProperty("secondThemeColor"), properties.getProperty("primaryIconColor"));
        System.out.println(sucess);
    }
    

    public Properties getProperties() {
        return properties;
    }
}
