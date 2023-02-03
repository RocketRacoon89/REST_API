package fileManager.controller;

import fileManager.model.File;
import fileManager.services.FileService;

import java.util.List;

public class FileController {
    FileService fileService = new FileService();

    public File createFile(String name, String filePath) {
        File file = new File();
        file.setName(name);
        file.setFilePath(filePath);
        return fileService.saveFile(file);
    }

    public File updateFile(Integer id, String name, String filePath) {
        File file = new File();
        file.setId(id);
        file.setName(name);
        file.setFilePath(filePath);
        return fileService.updateFile(file);
    }

    public void deleteFile(Integer id) {
        fileService.deleteFile(id);
    }

    public File getByIdFile(Integer id) {
        return fileService.getByIdFile(id);
    }

    public List<File> getAllFiles() {
        return fileService.getAllFiles();
    }
}
