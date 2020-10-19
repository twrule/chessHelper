JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	ChessHelper.java \
	KnightHelper.java \
	Pos.java \
	PieceMovements.java

default: classes

classes: $(CLASSES:.java=.class)

run: 
	java ChessHelper

spotless:
	$(RM) *.class
