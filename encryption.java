import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class encryption {

    private static final String SECRET_KEY = "mySecretKey";
    private static final String ALGORITHM = "AES";

    public static void main(String[] args) {
        String originalMessage = "Hello, World!";
        System.out.println("Original message: " + originalMessage);

        String encryptedMessage = encrypt(originalMessage);
        System.out.println("Encrypted message: " + encryptedMessage);

        String decryptedMessage = decrypt(encryptedMessage);
        System.out.println("Decrypted message: " + decryptedMessage);
    }

    public static String encrypt(String message) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] encryptedBytes = cipher.doFinal(message.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            System.err.println("Encryption failed: " + e.getMessage());
            return null;
        }
    }

    public static String decrypt(String encryptedMessage) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedMessage));
            return new String(decryptedBytes);
        } catch (Exception e) {
            System.err.println("Decryption failed: " + e.getMessage());
            return null;
        }
    }
}
