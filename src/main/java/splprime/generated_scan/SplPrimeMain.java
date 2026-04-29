package splprime.generated_scan;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import splprime.ast_generated.InterpreterVisitor;
import splprime.ast_generated.Stmt;

public class SplPrimeMain {
    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream(args[0]);
            SPLPrime parser = new SPLPrime(inputStream);

            // Token token;
            // while ((token = parser.getNextToken()).kind != SPLPrimeConstants.EOF) {
            // System.out.println("Token: " + SPLPrimeConstants.tokenImage[token.kind]);
            // }

            List<Stmt> statements = parser.program();
            // ASTPrinterVisitor visitor = new ASTPrinterVisitor();
            // for (Stmt s : statements) {
            // s.accept(visitor);
            // }

            InterpreterVisitor interpreter = new InterpreterVisitor();
            interpreter.interpret(statements);

            inputStream.close();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}