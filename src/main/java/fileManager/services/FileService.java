package fileManager.services;

import fileManager.model.File;
import fileManager.repository.repo.FileRepo;

import java.util.List;

public class FileService {
    private FileRepo fileRepo = new FileRepo();

    public File saveFile(File file) {
        fileRepo.fileCreate(file);
        return file;
    }

    public File updateFile(File file) {
        fileRepo.updateFile(file);
        return file;
    }

    public void deleteFile(Integer id) {
        fileRepo.deleteFile(id);
    }

    public List<File> getAllFiles() {
        return fileRepo.getAllFiles();
    }

    public File getByIdFile(Integer id) {
        return fileRepo.getByIdFile(id);
    }
}
