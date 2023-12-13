/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codemarket.model.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Luis Resende
 */
public class CSSFile {

    private final String CSSFilePath = "./src/main/resources/view/styleSettings.css";
    public boolean setSettings(String primaryTextColor, String secondTextColor, String primaryThemeColor, String secondThemeColor, String primaryIconColor) {
        if (hexaColorValidate(primaryTextColor) || hexaColorValidate(secondTextColor) || hexaColorValidate(primaryThemeColor) || hexaColorValidate(secondThemeColor) || hexaColorValidate(primaryIconColor)) {
            return false;
        }
        // Caminho para o arquivo CSS
        

        // Ler conteúdo do arquivo
        try {
            String newCSSContent = new String(
                    ".primaryTextColor{-fx-text-fill: #" + primaryTextColor + "; -fx-fill: #" + primaryTextColor + ";}\n"
                    + ".secondTextColor{-fx-text-fill: #" + secondTextColor + "; -fx-fill: #" + secondTextColor + ";}\n"
                    + ".thirdTextColor{-fx-text-fill: #" + primaryThemeColor + "; -fx-fill: #" + primaryThemeColor + ";}\n"
                    + ".primaryThemeColor{-fx-background-color: #" + primaryThemeColor + ";}\n"
                    + ".secondThemeColor{-fx-background-color: #" + secondThemeColor + ";}\n"
                    + ".sublimedTextField{-fx-border-color: #" + primaryThemeColor + ";}\n"
                    + ".primaryIconColor{-fx-fill: #" + primaryIconColor + ";}\n"
                    + ".secondIconColor{-fx-fill: #" + primaryThemeColor + ";}\n");
            // Gravavando o arquivos css com os novos elementos setados
            Files.write(Paths.get(CSSFilePath), newCSSContent.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean hexaColorValidate(String cor) {
        // Expressão regular para validar cor hexadecimal
        String expressaoRegular = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";

        // Compilar a expressão regular
        Pattern padrao = Pattern.compile(expressaoRegular);

        // Criar um Matcher com a string fornecida
        Matcher matcher = padrao.matcher(cor);

        // Verificar se há correspondência
        return matcher.matches();
    }


}
