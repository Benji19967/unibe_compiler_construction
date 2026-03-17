SRC_DIR = src/main/java
OUT_DIR = out
MAIN = splprime.SplPrime

SOURCES := $(shell find $(SRC_DIR) -name "*.java")

all: compile

compile:
	mkdir -p $(OUT_DIR)
	javac -d $(OUT_DIR) $(SOURCES)

run: compile
	java -cp $(OUT_DIR) $(MAIN) inputs/sample.spl

clean:
	rm -rf $(OUT_DIR)

splprime:
	java src/main/java/splprime/SplPrime.java inputs/sample.spl

cc_generated_scanner:
	java -cp /usr/local/lib/javacc-7.0.13.jar javacc src/main/javacc/spl_prime.jj

generated_scanner:
	java src/main/java/splprime/generated_scan/GeneratedScanner.java
