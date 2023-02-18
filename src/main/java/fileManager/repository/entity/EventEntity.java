package fileManager.repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "`rest_api`.`events`")
public class EventEntity {

    public EventEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    private UserEntity user;

    @ManyToOne
    private FileEntity file;


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

    @Override
    public String toString() {
        return "EventEntity{" +
                "id=" + id +
                ", file=" + file +
                '}';
    }
}
