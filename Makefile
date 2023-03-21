# enable ANTLR support
antlr4 := java -jar /usr/local/lib/antlr-4.12.0-complete.jar

PKGTARGETS = Terminals Expression Configuration Declaration TestExprCore TestGrammar allstar TestDrivenDev_DSL

# Release version used by release targets
PACKAGE = TestGrammar
VER = $(strip $(shell cat version))
PYVERDIR = $(PACKAGE)-$(VER)
PYBUILDDIR = build/$(PYVERDIR)
OBJDIR = build
SRCDIR = grammars/dev
GRAMMAR = $(PACKAGE).g4

all: clean $(OBJDIR)-python/$(PACKAGE) $(OBJDIR)-java/$(PACKAGE)
	javac $(OBJDIR)-java/$(PACKAGE)/*.java

all_pkg: $(PKGTARGETS)

$(PKGTARGETS): %: $(SRCDIR)/%.g4
	cd $(<D); $(antlr4) $(<F) -o ../../$(OBJDIR)-python/$@ -visitor -package $@ -Dlanguage=Python3
	cd $(<D); $(antlr4) $(<F) -o ../../$(OBJDIR)-java/$@ -visitor -package $@ 
	javac $(OBJDIR)-java/$@/*.java

$(OBJDIR)-python/$(PACKAGE): $(SRCDIR)/$(GRAMMAR)
	cd $(<D); $(antlr4) $(<F) -o ../../$(OBJDIR)-python/$(PACKAGE) -visitor -package $(PACKAGE) -Dlanguage=Python3

$(OBJDIR)-java/$(PACKAGE): $(SRCDIR)/$(GRAMMAR)
	cd $(<D); $(antlr4) $(<F) -o ../../$(OBJDIR)-java/$(PACKAGE) -visitor -package $(PACKAGE)

$(GRAMMAR).tar.gz: $(OBJDIR)-python/$(PACKAGE)
	mkdir -p $(PYBUILDDIR)
	cp $(OBJDIR)-python/$(PACKAGE)/* $(PYBUILDDIR)
	cp README.md $(PYBUILDDIR)/README.md
	cp LICENSE $(PYBUILDDIR)
	cd build; tar -czf $@ $(PYVERDIR); cd ..

release: $(GRAMMAR).tar.gz
	mkdir -p release
	mv build/$(GRAMMAR).tar.gz release/$(GRAMMAR)-$(VER).tar.gz

## TODO move source code into separate directory
#.PHONY: clean
#clean:
#	rm -rf $(OBJDIR)-python/$(PACKAGE) $(OBJDIR)-java/$(PACKAGE) build/
#
#dist-clean:
#	rm -rf $(OBJDIR)-python $(OBJDIR)-java build release __pycache__