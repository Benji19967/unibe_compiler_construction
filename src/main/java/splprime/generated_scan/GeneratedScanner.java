package splprime.generated_scan;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

public class GeneratedScanner {
    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream("inputs/sample.spl");
            SPLPrime parser = new SPLPrime(inputStream);

            Token token;
            while ((token = parser.getNextToken()).kind != SPLPrimeConstants.EOF) {
                System.out.println("Token: " + SPLPrimeConstants.tokenImage[token.kind]);
            }

            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}