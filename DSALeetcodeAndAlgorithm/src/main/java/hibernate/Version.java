package main.java.hibernate;

public class Version {

}
//
//---
//
//# 🔹 1️⃣ What is `@Version`?
//
//`@Version` is a **JPA annotation** that enables **optimistic locking**.
//
//* **Purpose:** Prevents **lost updates** when multiple transactions update the same entity concurrently.
//* **How it works:**
//
//  1. Adds a **version field** to the entity (numeric or timestamp).
//  2. Every time the entity is updated, JPA **increments the version** automatically.
//  3. If another transaction has updated the same entity before commit, **OptimisticLockException** is thrown.
//* **Supported types:** `Long`, `Integer`, `Timestamp`
//
//---
//
//# 🔹 2️⃣ Basic Example
//
//### 2.1 Entity with `@Version`
//
//```java
//import jakarta.persistence.*;
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
//    @Version
//    private Long version; // Optimistic locking field
//
//    public User() {}
//    public User(String name) { this.name = name; }
//
//    // getters/setters
//    public Long getId() { return id; }
//    public String getName() { return name; }
//    public void setName(String name) { this.name = name; }
//    public Long getVersion() { return version; }
//}
//```
//
//---
//
//### 2.2 Service Using Optimistic Lock
//
//```java
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.LockModeType;
//import jakarta.persistence.OptimisticLockException;
//import jakarta.transaction.Transactional;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserService {
//
//    private final EntityManager em;
//
//    public UserService(EntityManager em) {
//        this.em = em;
//    }
//
//    @Transactional
//    public void updateUserName(Long userId, String newName) {
//        try {
//            // Optionally can specify lock explicitly
//            User user = em.find(User.class, userId, LockModeType.OPTIMISTIC);
//            user.setName(newName);
//            // version automatically checked and incremented at commit
//        } catch (OptimisticLockException e) {
//            System.out.println("Conflict detected! Someone else updated this record.");
//            throw e;
//        }
//    }
//}
//```
//
//---
//
//# 🔹 3️⃣ How It Works
//
//1. Transaction 1 reads `User(id=1, version=1)`.
//2. Transaction 2 reads the same `User(id=1, version=1)`.
//3. Transaction 1 updates name → version becomes **2**.
//4. Transaction 2 tries to update → **OptimisticLockException** because version expected **1**, but DB has **2**.
//
//> This ensures **no updates are silently overwritten**.
//
//---
//
//# 🔹 4️⃣ Advantages of `@Version`
//
//* Simple to implement — just add `@Version` field.
//* Works well in **high-read, low-write scenarios**.
//* Prevents **lost updates** automatically.
//* Can combine with `LockModeType.OPTIMISTIC` or `OPTIMISTIC_FORCE_INCREMENT`.
//
//---
//
//# 🔹 5️⃣ Combining with Spring Boot Repository
//
//```java
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Lock;
//import jakarta.persistence.LockModeType;
//
//public interface UserRepository extends JpaRepository<User, Long> {
//
//    @Lock(LockModeType.OPTIMISTIC)
//    User findByIdAndName(Long id, String name);
//}
//```
//
//* Repository method uses **optimistic locking** automatically.
//* The **version field is checked at commit**.
//
//---
//
//# 🔹 6️⃣ Notes
//
//* **Do not modify the version manually**; JPA handles it.
//* **Optimistic locking** is better than **pessimistic** when conflicts are rare.
//* For **high contention**, consider **pessimistic locks** (`PESSIMISTIC_WRITE`).
//* Can be combined with **Spring Cache / transactions** safely.
//
//---
//
//If you want, I can create a **full Spring Boot demo** showing:
//
//* **Two threads / transactions updating the same entity**
//* How `@Version` **prevents lost updates**
//* Handling **OptimisticLockException** gracefully


