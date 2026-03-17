# Compiler vocabulary

## General

- **Lexical**: pertaining to words, speech, or vocabulary
- **Grammar**: system of rules that governs how a language works
  - **Syntax**: how are words arranged into sentences
  - **Semantics**: meaning of sentences

## Compiler design

- **Grammar**: formal, mathematical way to describe the structure of a (programming) language
  - Which strings of symbols are valid programs?
  - Definition:
    - **Terminals**: token types (e.g `IF`, `LBRACE`, `IDENTIFIER`)
    - **Non-terminals**: abstract symbols (e.g. `Expression`, `Statement`)
    - **Production rules**: how non-terminals expand
    - **Start symbol**: where parsing begins


- **Lexical analysis / Scanning** (done by lexer / scanner)
  - Code is broken into tokens


- **Syntax analysis / Parsing** (done by parser)
  - Check if tokens follow the grammar (rules)
  - Build a structure, like a parse tree, or AST (Abstract Syntax Tree)