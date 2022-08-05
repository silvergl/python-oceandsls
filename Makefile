# enable ANTLR support
antlr4 := java -jar /usr/local/lib/antlr-4.10.1-complete.jar

PKGTARGETS = Terminals Expression Configuration Declaration 

# Release version used by release targets
PACKAGE = Terminals
VER = $(strip $(shell cat version))
PYVERDIR = $(PACKAGE)-$(VER)
PYBUILDDIR = build/$(PYVERDIR)
SRCDIR = build
GRAMMAR = $(PACKAGE).g4

all: clean $(SRCDIR)-python/$(PACKAGE) $(SRCDIR)-java/$(PACKAGE)
	javac $(SRCDIR)-java/$(PACKAGE)/*.java

all_pkg: $(PKGTARGETS)

$(PKGTARGETS): %: %.g4
	$(antlr4) $< -o $(SRCDIR)-python/$@ -visitor -Dlanguage=Python3
	$(antlr4) $< -o $(SRCDIR)-java/$@
	# javac $(SRCDIR)-java/$@/*.java

$(SRCDIR)-python/$(PACKAGE): $(GRAMMAR)
	$(antlr4) $< -o $(SRCDIR)-python/$(PACKAGE) -visitor -Dlanguage=Python3

$(SRCDIR)-java/$(PACKAGE): $(GRAMMAR)
	$(antlr4) $< -o $(SRCDIR)-java/$(PACKAGE)

$(GRAMMAR).tar.gz: $(SRCDIR)-python/$(PACKAGE)
	mkdir -p $(PYBUILDDIR)
	cp $(SRCDIR)-python/$(PACKAGE)/* $(PYBUILDDIR)
	cp README.md $(PYBUILDDIR)/README.md
	cp LICENSE $(PYBUILDDIR)
	cd build; tar -czf $@ $(PYVERDIR); cd ..

release: $(GRAMMAR).tar.gz
	mkdir -p release
	mv build/$(GRAMMAR).tar.gz release/$(GRAMMAR)-$(VER).tar.gz

.PHONY: clean
clean:
	rm -rf $(SRCDIR)-python/$(PACKAGE) $(SRCDIR)-java/$(PACKAGE) build/

dist-clean:
	rm -rf $(SRCDIR)-python $(SRCDIR)-java build release