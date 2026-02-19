package main.java.hibernate;
//OneToOne
//
//OneToMany / ManyToOne
//
//ManyToMany with mappedBy
//
//@JoinColumn, @JoinTable
//
//Fetch types (EAGER / LAZY)
//
//Cascade types (ALL, PERSIST, MERGE, REMOVE)
//
//Locking (@Lock(LockModeType.PESSIMISTIC_WRITE))
//
//…and also an explanation of what each annotation does in code, all in one working example.
//
//Let’s go step by step with full working code.
//
//✅ Full JPA Example with Multiple Relationships
//import jakarta.persistence.*;
//import java.util.*;
//
//@Entity
//@Table(name = "users")
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String name;
//
//    // ----------------------------
//    // One-to-One relationship
//    // ----------------------------
//    // Cascade ALL → save/delete Address automatically with User
//    // FetchType.EAGER → load Address immediately with User
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "address_id") // foreign key in users table
//    private Address address;
//
//    // ----------------------------
//    // One-to-Many relationship
//    // ----------------------------
//    // A user can have multiple orders
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Order> orders = new ArrayList<>();
//
//    // ----------------------------
//    // Many-to-Many relationship
//    // ----------------------------
//    // Users can have multiple roles, roles can have multiple users
//    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
//    @JoinTable(
//        name = "user_role",
//        joinColumns = @JoinColumn(name = "user_id"),
//        inverseJoinColumns = @JoinColumn(name = "role_id")
//    )
//    private Set<Role> roles = new HashSet<>();
//
//    // ----------------------------
//    // Locking example
//    // ----------------------------
//    @Version
//    private Long version; // Optimistic locking example
//
//    // Constructors, getters, setters
//    public User() {}
//    public User(String name) { this.name = name; }
//
//    // Helper methods for relationships
//    public void addOrder(Order order) {
//        orders.add(order);
//        order.setUser(this);
//    }
//
//    public void addRole(Role role) {
//        roles.add(role);
//        role.getUsers().add(this);
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }
//
//    // getters/setters omitted for brevity
//}
//
//@Entity
//@Table(name = "addresses")
//class Address {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String street;
//
//    // Constructors, getters, setters
//    public Address() {}
//    public Address(String street) { this.street = street; }
//
//    // getters/setters omitted for brevity
//}
//
//@Entity
//@Table(name = "orders")
//class Order {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String product;
//
//    // Many orders belong to one user
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    // Constructors, getters, setters
//    public Order() {}
//    public Order(String product) { this.product = product; }
//
//    public void setUser(User user) { this.user = user; }
//
//    // getters/setters omitted for brevity
//}
//
//@Entity
//@Table(name = "roles")
//class Role {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String name;
//
//    // Many-to-many mappedBy
//    @ManyToMany(mappedBy = "roles")
//    private Set<User> users = new HashSet<>();
//
//    // Constructors, getters, setters
//    public Role() {}
//    public Role(String name) { this.name = name; }
//
//    public Set<User> getUsers() { return users; }
//
//    // getters/setters omitted for brevity
//}
//
//🔹 Explanation of Annotations in This Code
//Annotation	What it does
//@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)	One-to-one relationship; cascades all operations; fetched immediately with parent
//@JoinColumn(name = "address_id")	Specifies foreign key column in users table for the one-to-one relationship
//@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)	One user can have many orders; mappedBy defines owner side in Order entity
//@ManyToOne(fetch = FetchType.LAZY)	Many orders belong to one user; LAZY fetch delays DB query until needed
//@ManyToMany(cascade = {PERSIST, MERGE}, fetch = FetchType.EAGER)	Users ↔ Roles; cascade persist/merge; fetch eagerly
//@JoinTable(...)	Defines junction table for many-to-many relationship (user_role)
//@ManyToMany(mappedBy = "roles")	Inverse side of Many-to-Many in Role entity
//@Version	Optimistic locking (prevents concurrent update conflicts)
//
//⚠️ Pessimistic Locking (@Lock(LockModeType.PESSIMISTIC_WRITE)) is typically used on repository query methods, e.g.:
//
//@Lock(LockModeType.PESSIMISTIC_WRITE)
//@Query("SELECT u FROM User u WHERE u.id = :id")
//User findUserForUpdate(@Param("id") Long id);
//
//
//Locks the selected row in DB to prevent concurrent writes.
//
//🔹 How It Works Together
//
//User + Address → One-to-One; saving user cascades to address.
//
//User + Orders → One-to-Many; adding order automatically sets the user reference.
//
//User + Role → Many-to-Many; using a user_role junction table.
//
//Versioning / Locking → prevents concurrent updates conflicts.
//
//FetchType controls when data is loaded:
//
//EAGER → loads immediately
//
//LAZY → loads on access
//
//🔹 Example Usage in Service
//@Service
//@Transactional
//public class UserService {
//
//    @PersistenceContext
//    private EntityManager em;
//
//    public User createUser() {
//        User user = new User("Alice");
//        Address address = new Address("123 Main St");
//        user.setAddress(address);
//
//        Order order1 = new Order("Laptop");
//        Order order2 = new Order("Phone");
//        user.addOrder(order1);
//        user.addOrder(order2);
//
//        Role role = new Role("ADMIN");
//        user.addRole(role);
//
//        em.persist(user); // cascades address, orders, roles (if new)
//        return user;
//    }
//
//    @Lock(LockModeType.PESSIMISTIC_WRITE)
//    public User updateUserName(Long id, String newName) {
//        User user = em.find(User.class, id);
//        user.setName(newName);
//        return user;
//    }
//}
//
//
//em.persist(user) → cascades all relationships that have CascadeType.ALL.
//
//@Lock(LockModeType.PESSIMISTIC_WRITE) → locks user row in DB until transaction commits.
//
//This one example shows everything you asked:
//
//One-to-One with CascadeType.ALL & FetchType.EAGER
//
//One-to-Many / Many-to-One with mappedBy
//
//Many-to-Many with @JoinTable and inverse side mappedBy
//
//Versioning for optimistic locking
//
//Example of pessimistic locking in query
//
//Full cascade and fetch behavior explained in code