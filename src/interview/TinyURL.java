package interview;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class TinyURL {
    public static void main(String[] args) throws NoSuchAlgorithmException, MalformedURLException, URISyntaxException {
        TinyURL tinyURL = new TinyURL();
        String testString="https://stackoverflow.com/questions/39637036/java-convert-string-to-md5-and-vise-versa";
        String stringToHash= tinyURL.getHashMd5(testString);
        System.out.println(stringToHash);
        String hashToBase64Encoder = tinyURL.base64Encoder(tinyURL.getHashMd5(testString));
        System.out.println(hashToBase64Encoder);
        String base64ToHashDecoder= tinyURL.base64decoder(hashToBase64Encoder);
        System.out.println(base64ToHashDecoder);


        String originalUrl = "https://www.google.co.nz/?gfe_rd=cr&ei=dzbFV&gws_rd=ssl#q=java";
        String encodedUrl = Base64.getUrlEncoder().encodeToString(originalUrl.getBytes());
        System.out.println(encodedUrl);

        byte[] decodedBytes = Base64.getUrlDecoder().decode(encodedUrl);
        String decodedUrl = new String(decodedBytes);
        System.out.println(decodedUrl);

        URL u = new URL("http://localhost:8080/ZGJkYzg"); // this would check for the protocol
        System.out.println(u.getPath());
        
    }

    public String getHashMd5(String text) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(text.getBytes());
        BigInteger number = new BigInteger(1, messageDigest);
        return number.toString(16);
    }

    public String base64Encoder(String text){
        String encodedString = Base64.getEncoder().encodeToString(text.getBytes());
        return encodedString;

    }
    public String base64decoder(String text){
        byte[] decodedBytes = Base64.getDecoder().decode(text.getBytes());
        return new String(decodedBytes);

    }
}
