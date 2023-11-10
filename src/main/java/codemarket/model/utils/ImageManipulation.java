package codemarket.model.utils;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;

/**
 *
 * @author Luis Resende
 */
public class ImageManipulation {

    public byte[] convertToBytes(String path) {
        ByteArrayOutputStream bos = null;
        try {
            BufferedImage bImage = ImageIO.read(new File(path)); // Lendo a imagem
            bos = new ByteArrayOutputStream(); // Instanciando um objeto para o bytearray
            ImageIO.write(bImage, "png", bos); // Escrevendo a imagem no bytearray instanciado
        } catch (IOException ex) {
            Logger.getLogger(ImageManipulation.class.getName()).log(Level.SEVERE, null, ex);
        }

        byte[] data = bos.toByteArray(); // Atribuindo o bytearray para a váriavel data
        return data;
    }

    public Image convertToImage(byte[] data) {
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        BufferedImage originalImage = null;
        try {
            originalImage = ImageIO.read(bis);
        } catch (IOException e) {

        }
        BufferedImage circularImage = doCircle(originalImage); // Aplicando a mascara para deixar a imagem circular

        File tempFile;
        try {
            tempFile = File.createTempFile("tempImage", ".png"); // Inicializo um arquivo temporário
            ImageIO.write(circularImage, "png", tempFile);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        URL imageUrl = null;
        try {
            imageUrl = tempFile.toURI().toURL(); // Obtendo o URL da imagem temporária
        } catch (MalformedURLException ex) {
            Logger.getLogger(ImageManipulation.class.getName()).log(Level.SEVERE, null, ex);
        }

        Image userImage = new Image(imageUrl.toExternalForm()); // Crio a imagem a partir do URL

        tempFile.delete(); // Exclui o arquivo temporário

        return userImage;
    }

    // Autor: https://stackoverflow.com/questions/31423130/how-to-make-circle-image-label-in-java
    public BufferedImage doCircle(BufferedImage master) {
        int diameter = Math.min(master.getWidth(), master.getHeight());
        BufferedImage mask = new BufferedImage(master.getWidth(), master.getHeight(), BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = mask.createGraphics();
        applyQualityRenderingHints(g2d);
        g2d.fillOval(0, 0, diameter - 1, diameter - 1);
        g2d.dispose();

        BufferedImage masked = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);
        g2d = masked.createGraphics();
        applyQualityRenderingHints(g2d);
        int x = (diameter - master.getWidth()) / 2;
        int y = (diameter - master.getHeight()) / 2;
        g2d.drawImage(master, x, y, null);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.DST_IN));
        g2d.drawImage(mask, 0, 0, null);
        g2d.dispose();

        return masked;
    }

    public static void applyQualityRenderingHints(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
    }
}
