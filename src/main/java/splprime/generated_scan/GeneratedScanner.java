package splprime.generated_scan;

import splprime.ast_generated.Stmt;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.List;

public class GeneratedScanner {
    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream("inputs/sample.spl");
            SPLPrime parser = new SPLPrime(inputStream);

//            Token token;
//            while ((token = parser.getNextToken()).kind != SPLPrimeConstants.EOF) {
//                System.out.println("Token: " + SPLPrimeConstants.tokenImage[token.kind]);
//            }

            List<Stmt> statements = parser.program();
            for (Stmt s : statements) {
                System.out.println(s);
            }

            inputStream.close();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}