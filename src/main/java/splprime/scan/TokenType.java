package splprime.scan;

public enum TokenType {
    // Operators,
    NOT,
    PLUS,
    MINUS,
    STAR,
    DIVIDE,
    EQUAL,
    EQUAL_EQUAL,
    NOT_EQUAL,
    GREATER,
    LESS,
    GREATER_EQUAL,
    LESS_EQUAL,

    // Special characters,
    LEFT_PAREN,
    RIGHT_PAREN,
    LEFT_BRACE,
    RIGHT_BRACE,
    SEMICOLON,

    // Keywords
    TRUE,
    FALSE,
    AND,
    OR,
    PRINT,
    IF,
    ELSE,
    WHILE,

    // Strings
    STRING,

    // Numbers,
    NUMBER,

    // Identifiers
    IDENTIFIER
}