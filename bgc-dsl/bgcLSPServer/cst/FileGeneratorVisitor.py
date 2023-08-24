class FileGeneratorVisitor(BgcDslVisitor):
    fileTemplates: Dict[ int, str ]
    templatePath: str
    Path: str
    Folder: str
    FilePredicate: str
    environment: Environment