# Compiler Construction

Building an interpreter from scratch as part of the course compiler construction at the University of Bern.

## Getting Started

Create an SPL Prime program here: `inputs/<program-name>.spl`.

Run it:

```shell
./spl <program-name>
```

For example:

```shell
./spl fibonacci
```

## Folder Structure

    .
    │
    ├── inputs                                      # Sample SPL Prime programs
    │   
    ├── notes                                       # Notes about the course content
    │   
    ├── reports                                     # Exercises reports
    │
    ├── src
    │   ├── main / java / splprime / ast_generated
    │       ├── ASTPrinterVisitor.java              # Abstract Syntax Tree Printer
    │       ├── Environment.java                    # Symbol table for the interpreter
    │       ├── InterpreterVisitor.java             # Interpreter for SPL Prime
    │       ├── *Stmt.java                          # Statement nodes
    │       ├── *Expr.java                          # Expression nodes
    │       └── Visitor.java                        # Visitor interface for visitor design pattern
    │   ├── main / java / splprime / generated_scan
    │       ├── SplPrimeMain.java                   # Entry point for the interpreter
    |       ...
    │   ├── main / java / splprime / parser
    │       └── Parser.java                         # Handwritten parser
    │   ├── main / java / splprime / scan
    │       └── Scanner.java                        # Handwritten scanner
    │   ├── main / java / splprime
    │       └── SplPrime.java                       # Entrypoint for handwritten parser
    │   └── main / javacc 
    │       └── spl_prime.jj                        # JavaCC parser for SPL Prime
    │
    ├── makefile                                    # Commands to compile and run JavaCC code
    │
    ├── README.md
    │
    └── spl                                         # Script to simplify running SPL Prime programs
