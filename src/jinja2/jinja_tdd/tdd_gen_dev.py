from jinja2 import Environment, FileSystemLoader

import os

# Define the number of variable occurrences for each test
num_files = 5
num_mods = 2
num_ass = 2
list_tests = []
for i in range( num_files ):
    list_mods = []
    for j in range( num_mods ):
        list_mods.append( {'name': f"module_{i}_{j}"} )

    list_ass = []
    for j in range( num_mods ):
        list_ass.append( {'name': f"assertion_{i}_{j}", 'input': i, 'output': j} )

    list_tests.append( {'fn': f"file_{i}", 'sub': {'name': f"sub_{i}"}, 'mods': list_mods, 'assertions': list_ass} )

# Load Jinja2 template
environment = Environment( loader=FileSystemLoader( 'templates/' ) )
# Use test_template.txt
template = environment.get_template( 'tdd_pf_template.txt' )

# Loop through each test
for test in list_tests:
    # Render template
    content = template.render( test=test )

    # Define the folder and filename
    path = os.path.join( os.getcwd(), 'gen', 'test' )

    # Create folder if it doesn't exist
    if not os.path.isdir( path ):
        os.makedirs( path )

    # Create file if it doesn't exist
    filename = f"test_{test['fn'].lower()}.pf"
    path = os.path.join( os.getcwd(), path, filename )
    if not os.path.exists( path ):
        # Write rendered content to file
        with open( path, mode='w', encoding='utf-8' ) as f:
            f.write( content )
            print( f'... wrote {filename}' )
