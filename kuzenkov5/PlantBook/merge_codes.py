import os

def read_files_recursively(paths_to_walk, output_file):
    with open(output_file, 'w', encoding='utf-8') as outfile:
        for root_dir in paths_to_walk:
            for subdir, dirs, files in os.walk(root_dir):
                for file in files:
                    file_path = os.path.join(subdir, file)
                    try:
                        with open(file_path, 'r', encoding='utf-8') as infile:
                            outfile.write(f"{file_path}\n")
                            outfile.write(infile.read())
                            outfile.write("\n\n")
                    except Exception as e:
                        print(f"Error reading {file_path}: {e}")


paths_to_walk = [
    r"C:\Users\User\Documents\VUZ41\VedroII\pz5\PlantBook\app\src\main\java\ru\mirea\kuzenkov",
    r"C:\Users\User\Documents\VUZ41\VedroII\pz5\PlantBook\data\src\main\java\ru\mirea\kuzenkov", 
    r"C:\Users\User\Documents\VUZ41\VedroII\pz5\PlantBook\domain\src\main\java\ru\mirea\kuzenkov"
]

root_directory = "kuzenkov"
output_file = "all_codes.txt"

read_files_recursively(paths_to_walk, output_file)

print(f"All codes have been written to {output_file}")
