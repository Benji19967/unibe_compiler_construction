package splprime.scan;

public enum TokenType {
    // Operators,
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

    // Strings
    STRING,

    // Numbers,
    NUMBER,

    // Identifiers
    IDENTIFIER
}