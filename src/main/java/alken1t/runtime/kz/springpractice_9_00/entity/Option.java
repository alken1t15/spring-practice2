package alken1t.runtime.kz.springpractice_9_00.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@Table(name = "options")
@NoArgsConstructor
@Getter
@Setter
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "option")
    private List<Value> values;

    private String name;

    public Option(Category category, String name) {
        this.category = category;
        this.name = name;
    }

    public List<Value> uniqResult(){
        List<Value> uniqueOptions = values.stream()
                .distinct()
                .toList();
        return uniqueOptions;
    }

}