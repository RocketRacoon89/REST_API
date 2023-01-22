package fileManager.model;

public class Event {

    int id;
    User user;
    File file;
    Operation operation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", file=" + file.getName() +
                ", operation=" + operation +
                '}';
    }
}
