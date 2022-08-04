# enable ANTLR support
antlr4 := java -jar /usr/local/lib/antlr-4.10-complete.jar

# Release version used by release targets
PACKAGE = Declaration
VER = $(strip $(shell cat version))
PYVERDIR = $(PACKAGE)-$(VER)
PYBUILDDIR = build/$(PYVERDIR)
SRCDIR = build
GRAMMAR = $(PACKAGE).g4

all: clean build-python/$(PACKAGE) build-java/$(PACKAGE)
	javac $(SRCDIR)-java/$(PACKAGE)/*.java

build-python/$(PACKAGE): $(GRAMMAR)
	$(antlr4) $(GRAMMAR) -o $(SRCDIR)-python/$(PACKAGE) -visitor -Dlanguage=Python3

build-java/$(PACKAGE): $(GRAMMAR)
	$(antlr4) $(GRAMMAR) -o $(SRCDIR)-java/$(PACKAGE)

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
