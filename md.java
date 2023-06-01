import java.io.FileInputStream;
import java.security.MessageDigest;

public class md {

    private static final String ALGORITHM = "SHA-256";
    private static final int BUFFER_SIZE = 8192;

    public static void main(String[] args) {
        String filePath = "path/to/your/file";

        try {
            byte[] digest = computeFileDigest(filePath);
            String digestHex = bytesToHex(digest);
            System.out.println("File Digest (SHA-256): " + digestHex);
        } catch (Exception e) {
            System.err.println("Error computing file digest: " + e.getMessage());
        }
    }

    public static byte[] computeFileDigest(String filePath) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM);
        byte[] buffer = new byte[BUFFER_SIZE];

        FileInputStream fileInputStream = new FileInputStream(filePath);
        int bytesRead;
        while ((bytesRead = fileInputStream.read(buffer)) != -1) {
            messageDigest.update(buffer, 0, bytesRead);
        }
        fileInputStream.close();

        return messageDigest.digest();
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
