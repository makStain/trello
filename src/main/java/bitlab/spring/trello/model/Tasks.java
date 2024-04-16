package bitlab.spring.trello.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tasks")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", length = 200)
    private String title;

    @Column(name = "description", length = 200)
    private String description;

    @Column(name = "status")
    int status;

    @ManyToOne
    @Column(name = "folders", length = 200)
    Folders folders;

    @OneToMany(mappedBy = "tasks", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comments> comments;
}
