JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	ChessHelper.java 

default: classes

classes: $(CLASSES:.java=.class)

run: 
	java ChessHelper
	

spotless:
	$(RM) *.class
