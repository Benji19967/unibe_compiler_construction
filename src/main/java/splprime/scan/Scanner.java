package splprime.scan;

import splprime.SplPrime;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;


public class Scanner {

	// In and output
	private final String source;
	private final List<Token> tokens = new ArrayList<>();

	private final HashMap<String, TokenType> keywords = new HashMap<>(Map.of(
			"true", TokenType.TRUE,
			"false", TokenType.FALSE,
			"and", TokenType.AND,
			"or", TokenType.OR,
			"print", TokenType.PRINT,
			"if", TokenType.IF,
			"else", TokenType.ELSE,
			"while", TokenType.WHILE
	));

	private int start = 0;
	private int current = 0;
	private int line = 1;

	public Scanner(String source) {
		this.source = source;
	}

	// Scan tokens
	public List<Token> scanTokens() {
		while (!isAtEnd()) {
			start = current;
			char c = advance();
			switch (c) {
				case '(': addToken(TokenType.LEFT_PAREN, "(", line); break;
				case ')': addToken(TokenType.RIGHT_PAREN, ")", line); break;
				case '{': addToken(TokenType.LEFT_BRACE, "{", line); break;
				case '}': addToken(TokenType.RIGHT_BRACE, "}", line); break;
				case '+': addToken(TokenType.PLUS, "+", line); break;
				case '-': addToken(TokenType.MINUS, "-", line); break;
				case '*': addToken(TokenType.STAR, "*", line); break;
				case '!': addToken(TokenType.NOT, "!", line); break;
				case ';': addToken(TokenType.SEMICOLON, ";", line); break;
				case '=':
					if(peek() == '=') {
						addToken(TokenType.EQUAL_EQUAL, "==", line);
						advance();
					}
					else
						addToken(TokenType.EQUAL, "=", line); break;
				case '>':
					if(peek() == '=') {
						addToken(TokenType.GREATER_EQUAL, ">=", line);
						advance();
					}
					else
						addToken(TokenType.GREATER, ">", line); break;
				case '<':
					if(peek() == '=') {
						addToken(TokenType.LESS_EQUAL, "<=", line);
						advance();
					}
					else
						addToken(TokenType.LESS, "<", line); break;

				case '/':
					if (match('/')) {
						while (peek() != '\n' && !isAtEnd())
							advance();
					} else {
						addToken(TokenType.DIVIDE, "/", line);					}
					break;

				case '"':
					while (peek() != '"' && !isAtEnd())
						advance();

					if (isAtEnd()) {
						SplPrime.reportError(line, "Unterminated string."); break;
					}

					// Consume the closing "
					advance();

					// Trim the surrounding quotes
					String value = source.substring(start + 1, current - 1);
					addToken(TokenType.STRING, value, line);
					break;

				case ' ', '\t', '\r':
					break;
                case '\n':
					line++;
					break;

				default:
					if (isNumeric(c)) {
						while (isNumeric(peek()) || peek() == '.')
							advance();
						String text = source.substring(start, current);
						addToken(TokenType.NUMBER, text, line);
					}
					else if (isAlphaNumeric(c)) {
						while (isAlphaNumeric(peek()))
							advance();
						String text = source.substring(start, current);
						TokenType type = keywords.get(text);
						if (type == null)
							type = TokenType.IDENTIFIER;
						addToken(type, text, line);
					} else {
						// No case was matched
						System.out.println((int) c);
						SplPrime.reportError(line, "Unexpected character: " + c);
					}
			}
		}
		return tokens;
	}

	private boolean isNumeric(char c) {
		return Character.isDigit(c);
	}

	private boolean isAlphaNumeric(char c) {
		return Character.isLetterOrDigit(c);
	}

	private void addToken(TokenType type, String lexeme, int line) {
		tokens.add(new Token(type, lexeme, new Object(), line));
	}

	private char advance() {
		return source.charAt(current++);
	}

	private boolean match(char expected) {
		if (isAtEnd())
			return false;
		if (source.charAt(current) != expected)
			return false;
		current++;
		return true;
	}

	private char peek() {
		if (isAtEnd())
			return '\0';
		return source.charAt(current);
	}

	private boolean isAtEnd() {
		return current >= source.length();
	}
}