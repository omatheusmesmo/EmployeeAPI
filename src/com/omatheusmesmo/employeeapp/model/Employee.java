/**
 * Represents an Employee entity in the database.
 * 
 * This class is annotated with JPA (Java Persistence API) to indicate it's a Java-based object-relational mapping tool for interacting with a relational database.
 */
@Entity
@Table(name = "employees")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    /**
     * Unique identifier for the employee, automatically incremented by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Full name of the employee.
     * 
     * This field is marked as non-nullable to ensure a valid value is always provided.
     */
    @Column(nullable = false)
    private String name;

    /**
     * Unique email address associated with the employee's account.
     * 
     * This field is marked as unique and non-nullable to prevent duplicate entries in the database.
     */
    @Column(nullable = false, unique = true)
    private String email;

    /**
     * Title or role of the employee within the organization.
     * 
     * This field is marked as non-nullable to ensure a valid value is always provided.
     */
    @Column(nullable = false)
    private String position;

    /**
     * Gross salary of the employee, represented as a double precision floating point number.
     * 
     * This field is marked as non- nullable to restrict the inclusion of null values in this attribute.
     */
    @Column(nullable = false)
    private Double salary;
}