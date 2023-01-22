package fileManager.repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "`rest_api`.`events`")
public class EventEntity {

    public EventEntity() {
    }

    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    private UserEntity user;

    @ManyToOne(cascade = CascadeType.ALL)
    private FileEntity file;

    @Column(name = "operation")
    private String operation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public FileEntity getFile() {
        return file;
    }

    public void setFile(FileEntity file) {
        this.file = file;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "EventEntity{" +
                "id=" + id +
                ", file=" + file +
                ", operation='" + operation + '\'' +
                '}';
    }
}
