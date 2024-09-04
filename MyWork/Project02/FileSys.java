import java.util.*;

// file system object class
class FileSystemObject {
    String name;

    public FileSystemObject(String name) {
        this.name = name;
    }
}

// file class, extends from FileSystemObject and contains content
class File extends FileSystemObject {
    StringBuilder content;

    public File(String name, String content) {
        super(name);
        this.content = new StringBuilder(content);
    }

    // get the content of the file
    public String getContent() {
        return content.toString();
    }
}

// directory class, extends from FileSystemObject and contains children
class Directory extends FileSystemObject {
    Map<String, FileSystemObject> children;
    Directory parent;

    public Directory(String name, Directory parent) {
        super(name);
        this.children = new HashMap<>();
        this.parent = parent;
    }

    // add a file or sub-directory to the directory
    public void add(FileSystemObject fso) {
        children.put(fso.name, fso);
    }

    // remove a file or sub-directory from the directory
    public void remove(String name) {
        children.remove(name);
    }

    // get a child file or sub-directory by name
    public FileSystemObject getChild(String name) {
        return children.get(name);
    }

    // get all children of the directory
    public Collection<FileSystemObject> getChildren() {
        return new ArrayList<>(children.values());
    }
}

public class FileSys {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Directory root = new Directory("root", null);
    private static Directory currentDirectory = root;

    public static void main(String[] args) {
        System.out.print("prompt> ");
        String input;
        while (!(input = scanner.nextLine()).trim().equals("exit")) {
            processCommand(input);
            System.out.print("prompt> ");
        }
        scanner.close();
    }

    // command processing method
    private static void processCommand(String input) {
        String[] parts = input.split(" ", 2);
        String command = parts[0];
        String argument = parts.length > 1 ? parts[1].trim() : "";

        // switch statement to process different commands
        switch (command) {
            case "create":
                if (!argument.isEmpty()) createFile(argument);
                else System.out.println("ERROR: Missing file name.");
                break;
            case "cat":
                if (!argument.isEmpty()) catFile(argument);
                else System.out.println("ERROR: Missing file name.");
                break;
            case "rm":
                if (!argument.isEmpty()) removeFile(argument);
                else System.out.println("ERROR: Missing file name.");
                break;
            case "mkdir":
                if (!argument.isEmpty()) makeDirectory(argument);
                else System.out.println("ERROR: Missing directory name.");
                break;
            case "rmdir":
                if (!argument.isEmpty()) removeDirectory(argument);
                else System.out.println("ERROR: Missing directory name.");
                break;
            case "cd":
                if (!argument.isEmpty()) changeDirectory(argument);
                else System.out.println("ERROR: Missing directory name.");
                break;
            case "ls":
                listDirectory();
                break;
            case "du":
                System.out.println("Total size: " + diskUsage(currentDirectory) + " characters");
                break;
            case "pwd":
                printWorkingDirectory();
                break;
            case "find":
                if (!argument.isEmpty()) find(argument);
                else System.out.println("ERROR: Missing file or directory name.");
                break;
            default:
                System.out.println("ERROR: Unknown command.");
        }
    }

    // create file method
    private static void createFile(String fileName) {
        if (currentDirectory.getChild(fileName) != null) {
            System.out.println("ERROR: File or directory with this name already exists.");
            return;
        }
        System.out.println("Enter content (end with ~): ");
        StringBuilder content = new StringBuilder();
        String line;
        while (!(line = scanner.nextLine()).equals("~")) {
            content.append(line).append("\n");
        }
        currentDirectory.add(new File(fileName, content.toString()));
        System.out.println("File '" + fileName + "' created.");
    }

    // cat file method
    private static void catFile(String fileName) {
        FileSystemObject fso = currentDirectory.getChild(fileName);
        if (fso instanceof File file) {
            System.out.println(file.getContent());
        } else {
            System.out.println("ERROR: File does not exist.");
        }
    }

    // delete file method
    private static void removeFile(String fileName) {
        if (currentDirectory.getChild(fileName) instanceof File) {
            currentDirectory.remove(fileName);
            System.out.println("File '" + fileName + "' removed.");
        } else {
            System.out.println("ERROR: File does not exist or is a directory.");
        }
    }

    // create directory method
    private static void makeDirectory(String dirName) {
        if (currentDirectory.getChild(dirName) != null) {
            System.out.println("ERROR: Directory or file with this name already exists.");
            return;
        }
        Directory newDir = new Directory(dirName, currentDirectory);
        currentDirectory.add(newDir);
        System.out.println("Directory '" + dirName + "' created.");
    }

    // delete directory method (and all its contents)
    private static void removeDirectory(String dirName) {
        FileSystemObject fso = currentDirectory.getChild(dirName);
        if (fso instanceof Directory) {
            removeDirectoryRecursively((Directory) fso);
            currentDirectory.remove(dirName);
            System.out.println("Directory '" + dirName + "' and all its contents removed.");
        } else {
            System.out.println("ERROR: Directory does not exist or is a file.");
        }
    }

    // recursive method to remove a directory and all its contents
    private static void removeDirectoryRecursively(Directory dir) {
        for (FileSystemObject child : dir.getChildren()) {
            if (child instanceof Directory) {
                removeDirectoryRecursively((Directory) child);
            }
            dir.remove(child.name);
        }
    }

    // change directory method
    private static void changeDirectory(String path) {
        if (path.equals("..")) {
            if (currentDirectory.parent != null) {
                currentDirectory = currentDirectory.parent;
            }
        } else if (path.equals("/")) {
            currentDirectory = root;
        } else {
            FileSystemObject nextDir = currentDirectory.getChild(path);
            if (nextDir instanceof Directory) {
                currentDirectory = (Directory) nextDir;
            } else {
                System.out.println("ERROR: Directory does not exist.");
            }
        }
    }

    // list directory contents method
    private static void listDirectory() {
        for (FileSystemObject fso : currentDirectory.getChildren()) {
            if (fso instanceof Directory) {
                System.out.println(fso.name + "/");
            } else {
                System.out.println(fso.name);
            }
        }
    }

    // calculate disk usage method
    private static int diskUsage(Directory dir) {
        int totalSize = 0;
        for (FileSystemObject fso : dir.getChildren()) {
            if (fso instanceof File) {
                totalSize += ((File) fso).getContent().length();
            } else if (fso instanceof Directory) {
                totalSize += diskUsage((Directory) fso);
            }
        }
        return totalSize;
    }

    // print working directory method
    private static void printWorkingDirectory() {
        List<String> paths = new ArrayList<>();
        Directory temp = currentDirectory;
        while (temp != null && temp != root) {
            paths.add(temp.name);
            temp = temp.parent;  // backtrace to root directory
        }
        Collections.reverse(paths);  // reverse the list to get the correct path
        if (paths.isEmpty()) {
            System.out.println("/");
        } else {
            System.out.println("/" + String.join("/", paths));
        }
    }

    // find file or directory method
    private static void find(String name) {
        findRecursive(name, currentDirectory, "/");
    }

    // recursive method to find a file or directory
    private static void findRecursive(String name, Directory dir, String path) {
        for (FileSystemObject fso : dir.getChildren()) {
            String currentPath = path + (path.equals("/") ? "" : "/") + dir.name;
            if (fso.name.equals(name)) {
                System.out.println(currentPath + "/" + fso.name);
            }
            if (fso instanceof Directory) {
                findRecursive(name, (Directory) fso, currentPath);
            }
        }
    }
}