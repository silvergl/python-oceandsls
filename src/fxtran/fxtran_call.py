import fnmatch
import os.path
import subprocess

# Define the fxtran command
fxtran_cmd = [
    "/home/sgu/IdeaProjects/fxtran/bin/fxtran",
    "-g",
    "-o",
    "/home/sgu/IdeaProjects/antlr4-python/src/fxtran/example.gv",
    "/home/sgu/IdeaProjects/antlr4-python/src/fxtran/example.f90"
]

fxtran_cmd_for = [
    "/home/sgu/IdeaProjects/fxtran/bin/fxtran",
    "-line-length 200",
    "-no-cpp",
    "-no-include",
    "-construct-tag"
]

fxtran_cmd_tag = [
    "/home/sgu/IdeaProjects/fxtran/bin/fxtran",
    "-line-length 200",
    "-no-cpp",
    "-no-include",
    "-construct-tag",
    "/home/sgu/IdeaProjects/antlr4-python/src/fxtran/example.f90"
]

matches = []
root_dir = "/home/sgu/IdeaProjects/antlr4-python/src/fxtran"
for root, dirnames, filenames in os.walk(root_dir):
    for filename in fnmatch.filter(filenames, "*.[fF]90"):
        matches.append(os.path.join(root,filename))

for match in matches:
    print("run fxtran with  " + match)
    cmd = ' '.join(fxtran_cmd_tag) + " " + match
    print("run " + cmd)
    #subprocess.call(cmd, shell = True)

# Call fxtran via subprocess
subprocess.run(fxtran_cmd_tag, check=True)
