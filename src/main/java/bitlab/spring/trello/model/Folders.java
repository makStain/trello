package bitlab.spring.trello.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "folders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Folders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 200)
    private String name;

    @ManyToMany
    @Column(name = "categories", length = 200)
    List<TaskCategories> categories;
}
