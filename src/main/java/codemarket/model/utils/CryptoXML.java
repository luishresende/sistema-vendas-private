package codemarket.model.utils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class CryptoXML {
    private static final String ALGORITMO = "AES";
    private SecretKeySpec secretKey;
    private Cipher cipher;
    private static CryptoXML instance;

    private CryptoXML() throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        this.secretKey = new SecretKeySpec("TtA|97x(YxM9L=F!|cQslgqBwsq)d7nv".getBytes("UTF-8"), ALGORITMO);
        this.cipher = Cipher.getInstance(ALGORITMO);
        this.cipher.init(Cipher.ENCRYPT_MODE, this.secretKey);
    }

    public static CryptoXML getInstance() {
        if (instance == null) {
            try {
                instance = new CryptoXML();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    // Métodos de criptografia e descriptografia...

    public String decryptText(String input) throws Exception {
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] encryptedBytes = Base64.getDecoder().decode(input);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }

    public String encryptText(String input) throws Exception {
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] inputBytes = input.getBytes(StandardCharsets.UTF_8);
        byte[] encryptedBytes = cipher.doFinal(inputBytes);
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
}
