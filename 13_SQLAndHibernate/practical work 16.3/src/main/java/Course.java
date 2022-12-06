import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Courses")
public class Course {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private  int duration;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum", name = "type")
    private CourseType courseType;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    @ManyToOne(cascade = CascadeType.ALL)
    private Teacher teacher;

    @Getter
    @Setter
    @Column(name = "students_count")
    private int studentsCount;

    @Getter
    @Setter
    private int price;

    @Getter
    @Setter
    @Column(name = "price_per_hour")
    private float pricePerHour;

    @Getter
    @Setter
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private List<Subscription> subscriptions;
}
