# enable ANTLR support
antlr4 := java -jar /usr/local/lib/antlr-4.13.0-complete.jar

#########################################################
#                    example DSL
#########################################################

EXPPKGTARGETS = exampleDsl TestExprCore

# Release version used by release targets
EXPPACKAGE = example-dsl/exampleLSPServer
EXPVER = $(strip $(shell cat version))
EXPPYEXPVERDIR = $(EXPPACKAGE)-$(EXPVER)
EXPPYBUILDDIR = $(EXPPACKAGE)/../build/$(EXPPYEXPVERDIR)
EXPOBJDIR = $(EXPPACKAGE)/gen
EXPSRCDIR = $(EXPPACKAGE)/grammars
EXPGRAMMAR = $(EXPPACKAGE).g4

all_EXP: clean $(EXPOBJDIR)/python/$(EXPPACKAGE) $(EXPOBJDIR)/java/$(EXPPACKAGE)
	javac $(EXPOBJDIR)/java/$(EXPPACKAGE)/*.java

all_pkg_EXP: $(EXPPKGTARGETS)

$(EXPPKGTARGETS): %: $(EXPSRCDIR)/%.g4
	rm -rf $(EXPOBJDIR)/python/$@ $(EXPOBJDIR)/java/$@
	cd $(<D); $(antlr4) $(<F) -o ../../../$(EXPOBJDIR)/python/$@ -visitor -package $@ -Dlanguage=Python3
	cd $(<D); $(antlr4) $(<F) -o ../../../$(EXPOBJDIR)/java/$@ -visitor -package $@ 
	javac $(EXPOBJDIR)/java/$@/*.java

$(EXPOBJDIR)/python/$(EXPPACKAGE): $(EXPSRCDIR)/$(EXPGRAMMAR)
	cd $(<D); $(antlr4) $(<F) -o ../../../$(EXPOBJDIR)/python/$(EXPPACKAGE) -visitor -package $(EXPPACKAGE) -Dlanguage=Python3

$(EXPOBJDIR)/java/$(EXPPACKAGE): $(EXPSRCDIR)/$(EXPGRAMMAR)
	cd $(<D); $(antlr4) $(<F) -o ../../../$(EXPOBJDIR)/java/$(EXPPACKAGE) -visitor -package $(EXPPACKAGE)

$(EXPGRAMMAR).tar.gz: $(EXPOBJDIR)/python/$(EXPPACKAGE)
	mkdir -p $(EXPPYBUILDDIR)
	cp $(EXPOBJDIR)/python/$(EXPPACKAGE)/* $(EXPPYBUILDDIR)
	cp README.md $(EXPPYBUILDDIR)/README.md
	cp LICENSE $(EXPPYBUILDDIR)
	cd $(TDDPYBUILDDIR); tar -czf $@ $(EXPPYEXPVERDIR); cd ..

release_EXP: $(EXPGRAMMAR).tar.gz
	mkdir -p release
	mv $(TDDPYBUILDDIR)/$(EXPGRAMMAR).tar.gz release/$(EXPGRAMMAR)-$(EXPVER).tar.gz

#########################################################
#                    BGC DSL
#########################################################

BGCPKGTARGETS = BgcDsl

# Release version used by release targets
BGCPACKAGE = bgc-dsl/bgcLSPServer
BGCVER = $(strip $(shell cat version))
BGCPYBGCVERDIR = $(BGCPACKAGE)-$(BGCVER)
BGCPYBUILDDIR = $(BGCPACKAGE)/../build/$(BGCPYBGCVERDIR)
BGCOBJDIR = $(BGCPACKAGE)/gen
BGCSRCDIR = $(BGCPACKAGE)/grammars
BGCGRAMMAR = $(BGCPACKAGE).g4

all_BGC: clean $(BGCOBJDIR)/python/$(BGCPACKAGE) $(BGCOBJDIR)/java/$(BGCPACKAGE)
	javac $(BGCOBJDIR)/java/$(BGCPACKAGE)/*.java

all_pkg_BGC: $(BGCPKGTARGETS)

$(BGCPKGTARGETS): %: $(BGCSRCDIR)/%.g4
	rm -rf $(BGCOBJDIR)/python/$@ $(BGCOBJDIR)/java/$@
	cd $(<D); $(antlr4) $(<F) -o ../../../$(BGCOBJDIR)/python/$@ -visitor -package $@ -Dlanguage=Python3
	cd $(<D); $(antlr4) $(<F) -o ../../../$(BGCOBJDIR)/java/$@ -visitor -package $@ 
	javac $(BGCOBJDIR)/java/$@/*.java

$(BGCOBJDIR)/python/$(BGCPACKAGE): $(BGCSRCDIR)/$(BGCGRAMMAR)
	cd $(<D); $(antlr4) $(<F) -o ../../../$(BGCOBJDIR)/python/$(BGCPACKAGE) -visitor -package $(BGCPACKAGE) -Dlanguage=Python3

$(BGCOBJDIR)/java/$(BGCPACKAGE): $(BGCSRCDIR)/$(BGCGRAMMAR)
	cd $(<D); $(antlr4) $(<F) -o ../../../$(BGCOBJDIR)/java/$(BGCPACKAGE) -visitor -package $(BGCPACKAGE)

$(BGCGRAMMAR).tar.gz: $(BGCOBJDIR)/python/$(BGCPACKAGE)
	mkdir -p $(BGCPYBUILDDIR)
	cp $(BGCOBJDIR)/python/$(BGCPACKAGE)/* $(BGCPYBUILDDIR)
	cp README.md $(BGCPYBUILDDIR)/README.md
	cp LICENSE $(BGCPYBUILDDIR)
	cd $(TDDPYBUILDDIR); tar -czf $@ $(BGCPYBGCVERDIR); cd ..

release_BGC: $(BGCGRAMMAR).tar.gz
	mkdir -p release
	mv $(TDDPYBUILDDIR)/$(BGCGRAMMAR).tar.gz release/$(BGCGRAMMAR)-$(BGCVER).tar.gz

#########################################################
#                    CP DSL
#########################################################

CPPKGTARGETS = Terminals Expression Configuration Declaration

# Release version used by release targets
CPPACKAGE = cp-dsl/cpLSPServer
CPVER = $(strip $(shell cat version))
CPPYCPVERDIR = $(CPPACKAGE)-$(CPVER)
CPPYBUILDDIR = $(CPPACKAGE)/../build/$(CPPYCPVERDIR)
CPOBJDIR = $(CPPACKAGE)/gen
CPSRCDIR = $(CPPACKAGE)/grammars
CPGRAMMAR = $(CPPACKAGE).g4

all_CP: clean $(CPOBJDIR)/python/$(CPPACKAGE) $(CPOBJDIR)/java/$(CPPACKAGE)
	javac $(CPOBJDIR)/java/$(CPPACKAGE)/*.java

all_pkg_CP: $(CPPKGTARGETS)

$(CPPKGTARGETS): %: $(CPSRCDIR)/%.g4
	rm -rf $(CPOBJDIR)/python/$@ $(CPOBJDIR)/java/$@
	cd $(<D); $(antlr4) $(<F) -o ../../../$(CPOBJDIR)/python/$@ -visitor -package $@ -Dlanguage=Python3
	cd $(<D); $(antlr4) $(<F) -o ../../../$(CPOBJDIR)/java/$@ -visitor -package $@ 
	javac $(CPOBJDIR)/java/$@/*.java

$(CPOBJDIR)/python/$(CPPACKAGE): $(CPSRCDIR)/$(CPGRAMMAR)
	cd $(<D); $(antlr4) $(<F) -o ../../../$(CPOBJDIR)/python/$(CPPACKAGE) -visitor -package $(CPPACKAGE) -Dlanguage=Python3

$(CPOBJDIR)/java/$(CPPACKAGE): $(CPSRCDIR)/$(CPGRAMMAR)
	cd $(<D); $(antlr4) $(<F) -o ../../../$(CPOBJDIR)/java/$(CPPACKAGE) -visitor -package $(CPPACKAGE)

$(CPGRAMMAR).tar.gz: $(CPOBJDIR)/python/$(CPPACKAGE)
	mkdir -p $(CPPYBUILDDIR)
	cp $(CPOBJDIR)/python/$(CPPACKAGE)/* $(CPPYBUILDDIR)
	cp README.md $(CPPYBUILDDIR)/README.md
	cp LICENSE $(CPPYBUILDDIR)
	cd $(TDDPYBUILDDIR); tar -czf $@ $(CPPYCPVERDIR); cd ..

release_CP: $(CPGRAMMAR).tar.gz
	mkdir -p release
	mv $(TDDPYBUILDDIR)/$(CPGRAMMAR).tar.gz release/$(CPGRAMMAR)-$(CPVER).tar.gz

#########################################################
#                    TDD DSL
#########################################################

TDDPKGTARGETS = TestSuite

# Release version used by release targets
TDDPACKAGE = tdd-dsl/tddLSPServer
TDDVER = $(strip $(shell cat version))
TDDPYTDDVERDIR = $(TDDPACKAGE)-$(TDDVER)
TDDPYBUILDDIR = $(TDDPACKAGE)/../build/$(TDDPYTDDVERDIR)
TDDOBJDIR = $(TDDPACKAGE)/gen
TDDSRCDIR = $(TDDPACKAGE)/grammars
TDDGRAMMAR = $(TDDPACKAGE).g4

all_TDD: clean $(TDDOBJDIR)/python/$(TDDPACKAGE) $(TDDOBJDIR)/java/$(TDDPACKAGE)
	javac $(TDDOBJDIR)/java/$(TDDPACKAGE)/*.java

all_pkg_TDD: $(TDDPKGTARGETS)

$(TDDPKGTARGETS): %: $(TDDSRCDIR)/%.g4
	rm -rf $(TDDOBJDIR)/python/$@ $(TDDOBJDIR)/java/$@
	cd $(<D); $(antlr4) $(<F) -o ../../../$(TDDOBJDIR)/python/$@ -visitor -package $@ -Dlanguage=Python3
	cd $(<D); $(antlr4) $(<F) -o ../../../$(TDDOBJDIR)/java/$@ -visitor -package $@ 
	javac $(TDDOBJDIR)/java/$@/*.java

$(TDDOBJDIR)/python/$(TDDPACKAGE): $(TDDSRCDIR)/$(TDDGRAMMAR)
	cd $(<D); $(antlr4) $(<F) -o ../../../$(TDDOBJDIR)/python/$(TDDPACKAGE) -visitor -package $(TDDPACKAGE) -Dlanguage=Python3

$(TDDOBJDIR)/java/$(TDDPACKAGE): $(TDDSRCDIR)/$(TDDGRAMMAR)
	cd $(<D); $(antlr4) $(<F) -o ../../../$(TDDOBJDIR)/java/$(TDDPACKAGE) -visitor -package $(TDDPACKAGE)

$(TDDGRAMMAR).tar.gz: $(TDDOBJDIR)/python/$(TDDPACKAGE)
	mkdir -p $(TDDPYBUILDDIR)
	cp $(TDDOBJDIR)/python/$(TDDPACKAGE)/* $(TDDPYBUILDDIR)
	cp README.md $(TDDPYBUILDDIR)/README.md
	cp LICENSE $(TDDPYBUILDDIR)
	cd $(TDDPYBUILDDIR); tar -czf $@ $(TDDPYTDDVERDIR); cd ..

release_TDD: $(TDDGRAMMAR).tar.gz
	mkdir -p release
	mv $(TDDPYBUILDDIR)/$(TDDGRAMMAR).tar.gz release/$(TDDGRAMMAR)-$(TDDVER).tar.gz

#########################################################
#                    TODO
#########################################################

## TODO align separate rules into variables directory

#########################################################
#                    CLEAN
#########################################################

# echo "$(PWD)"

#.PHONY: clean
#clean:
#	rm -rf $(OBJDIR)/python/$(PACKAGE) $(OBJDIR)/java/$(PACKAGE)
#
#dist-clean:
#	rm -rf $(OBJDIR)/python $(OBJDIR)/java build release __pycache__