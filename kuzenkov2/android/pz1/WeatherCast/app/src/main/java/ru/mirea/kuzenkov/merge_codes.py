import os

def read_files_recursively(root_dir, output_file):
    # Список расширений файлов, которые нужно игнорировать
    #ignored_extensions = {'.jpg', '.jpeg', '.png', '.gif', '.bmp', '.svg', '.ico', '.webp', '.sql', '.css'}
    #ignored_directories = {'node_modules'}
    #ignored_files = {'package-lock.json', 'package.json', 'files.txt'}

    with open(output_file, 'w', encoding='utf-8') as outfile:
        for subdir, dirs, files in os.walk(root_dir):
            # Игнорировать папки из списка ignored_directories
            #dirs[:] = [d for d in dirs if d not in ignored_directories]
            
            for file in files:
                # Игнорировать файлы из списка ignored_files и файлы с игнорируемыми расширениями
                #if file in ignored_files or os.path.splitext(file)[1].lower() in ignored_extensions:
                    #continue
                
                file_path = os.path.join(subdir, file)
                try:
                    with open(file_path, 'r', encoding='utf-8') as infile:
                        outfile.write(f"{file_path}\n")
                        outfile.write(infile.read())
                        outfile.write("\n\n")
                except Exception as e:
                    print(f"Error reading {file_path}: {e}")

root_directory = "weathercast"
output_file = "all_codes.txt"

read_files_recursively(root_directory, output_file)

print(f"All codes have been written to {output_file}")
