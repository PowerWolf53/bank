package by.bsuir.vtb.repository.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "credit")
@ToString
@EqualsAndHashCode
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "sum")
    private double sum;

    @Column(name = "percent")
    private Integer percent;

    @Column(name = "title")
    private String title;
}
