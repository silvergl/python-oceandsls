# enable ANTLR support
if [ -f /usr/local/lib/antlr-4.10.1-complete.jar ]; then
    export CLASSPATH=".:/usr/local/lib/antlr-4.10.1-complete.jar:$CLASSPATH"
    alias antlr4='java -jar /usr/local/lib/antlr-4.10.1-complete.jar'
    alias grun='java org.antlr.v4.gui.TestRig'

    export GRUN_CMD='java org.antlr.v4.gui.TestRig'


    #Shows diagnostic output from lexer and parser if any
    diagrun() {
      srcdir=`readlink -f $1`
      grammar="${2}"
      testfile=`readlink -f $3`
      cd "${srcdir}"/ && ${GRUN_CMD} "${grammar}" label -diagnostics < "${testfile}"
      cd ../..
    }

    #Shows GUI parse tree browser
    guirun() {
      srcdir=`readlink -f $1`
      grammar="${2}"
      testfile=`readlink -f $3`
      cd "${srcdir}"/ && ${GRUN_CMD} "${grammar}" label -gui < "${testfile}"
      cd ../..
    }

    #Generates a PS of the parsetree
    psrun() {
      srcdir=`readlink -f $1`
      grammar="${2}"
      testfile=`readlink -f $3`
      cd "${srcdir}"/ && ${GRUN_CMD} "${grammar}" label -ps "${testfile}".ps < "${testfile}"
      cd ../..
    }

    #Shows tokens detected by lexer
    tokenrun() {
      srcdir=`readlink -f $1`
      grammar="${2}"
      testfile=`readlink -f $3`
      cd "${srcdir}"/ && ${GRUN_CMD} "${grammar}" label -tokens < "${testfile}"
      cd ../..
    }

    #Prints text tree output of parse tree
    treerun() {
      srcdir=`readlink -f $1`
      grammar="${2}"
      testfile=`readlink -f $3`
      cd "${srcdir}"/ && ${GRUN_CMD} "${grammar}" label -tree < "${testfile}"
      cd ../..
    }
    
    #Shows trace information when parsing input file
    tracerun() {
      srcdir=`readlink -f $1`
      grammar="${2}"
      testfile=`readlink -f $3`
      cd "${srcdir}"/ && ${GRUN_CMD} "${grammar}" label -trace < "${testfile}"
      cd ../..
    }
fi