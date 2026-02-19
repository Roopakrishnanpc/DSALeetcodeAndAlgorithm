package main.java.hibernate;

public class Locks {

}
//
//Perfect! Let’s go **step by step** — I’ll explain **Persistence Context**, all types of **locks in JPA/Hibernate**, and give **examples** for each, so you get a full picture.
//
//---
//
//# 🔹 1️⃣ What is Persistence Context?
//
//**Persistence Context** in JPA is essentially **a first-level cache** managed by the EntityManager.
//
//* **Scope:** The lifecycle of the persistence context is typically the **transaction**.
//* **Purpose:** Tracks all **managed entities**, changes, and ensures **automatic synchronization** with the database at flush/commit time.
//* **Key points:**
//
//  1. **Managed entities:** When you `em.find()` or `em.persist()`, the entity becomes **managed**.
//  2. **Dirty checking:** JPA automatically detects changes to managed entities and updates the DB at commit (`flush`).
//  3. **Identity guarantee:** Within the same persistence context, `em.find(User.class, id)` always returns **the same Java object**.
//  4. **Caching:** It caches entities locally (first-level cache).
//
//**Example:**
//
//```java
//@Transactional
//public void persistenceContextExample() {
//    // EntityManager injected
//    User u1 = em.find(User.class, 1L);  // Loads user from DB
//    User u2 = em.find(User.class, 1L);  // Returns the same object from persistence context
//
//    u1.setName("Alice Updated");        // Change tracked automatically
//    // No need to call em.merge()
//    // DB will be updated when transaction commits
//}
//```
//
//✅ In this example, both `u1` and `u2` refer to the **same managed entity**. Any changes are automatically persisted.
//
//---
//
//# 🔹 2️⃣ Locking in JPA / Hibernate
//
//Locks are used to **control concurrent access** to entities in the database.
//
//### 2.1 Types of Locks
//
//| Lock Type                       | JPA LockMode                               | Description                                                                  |
//| ------------------------------- | ------------------------------------------ | ---------------------------------------------------------------------------- |
//| **Optimistic (Version-based)**  | `LockModeType.OPTIMISTIC`                  | Checks version at commit. Fails if another transaction modified the entity.  |
//| **Optimistic Force Increment**  | `LockModeType.OPTIMISTIC_FORCE_INCREMENT`  | Same as optimistic, but also increments version immediately.                 |
//| **Pessimistic Read**            | `LockModeType.PESSIMISTIC_READ`            | Locks row for read; other transactions **cannot write** until released.      |
//| **Pessimistic Write**           | `LockModeType.PESSIMISTIC_WRITE`           | Locks row for write; **no other reads/writes** can access it until released. |
//| **Pessimistic Force Increment** | `LockModeType.PESSIMISTIC_FORCE_INCREMENT` | Locks row and **increments version** for optimistic concurrency.             |
//| **None**                        | `LockModeType.NONE`                        | No locking, default behavior.                                                |
//
//---
//
//# 🔹 3️⃣ Examples of Each Lock
//
//Assume we have `User` entity with `@Version Long version` (for optimistic locking):
//
//### 3.1 Optimistic Lock
//
//```java
//@Transactional
//public void optimisticLockExample(Long id) {
//    User user = em.find(User.class, id, LockModeType.OPTIMISTIC);
//    user.setName("Optimistic Updated");
//    // Version checked at commit; if another transaction updated it, exception thrown
//}
//```
//
//* **Use case:** High-read, low-write scenarios.
//
//---
//
//### 3.2 Optimistic Force Increment
//
//```java
//@Transactional
//public void optimisticForceIncrement(Long id) {
//    User user = em.find(User.class, id, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
//    // Immediately increments version even if no changes
//}
//```
//
//* Forces **version increment** to signal changes to concurrent transactions.
//
//---
//
//### 3.3 Pessimistic Read
//
//```java
//@Transactional
//public void pessimisticReadExample(Long id) {
//    User user = em.find(User.class, id, LockModeType.PESSIMISTIC_READ);
//    // Other transactions cannot write until this transaction commits
//}
//```
//
//* **Use case:** Reading shared data, prevent dirty writes.
//
//---
//
//### 3.4 Pessimistic Write
//
//```java
//@Transactional
//public void pessimisticWriteExample(Long id) {
//    User user = em.find(User.class, id, LockModeType.PESSIMISTIC_WRITE);
//    user.setName("Pessimistic Write Update");
//    // Locks row for writing; prevents other reads/writes
//}
//```
//
//* **Use case:** High contention on critical rows.
//
//---
//
//### 3.5 Pessimistic Force Increment
//
//```java
//@Transactional
//public void pessimisticForceIncrementExample(Long id) {
//    User user = em.find(User.class, id, LockModeType.PESSIMISTIC_FORCE_INCREMENT);
//    // Locks row and increments version
//}
//```
//
//* Combines **pessimistic locking** and **version increment** to signal updates.
//
//---
//
//# 🔹 4️⃣ Key Notes on Locks
//
//| Lock                        | Transaction Behavior     | Pros               | Cons                               |
//| --------------------------- | ------------------------ | ------------------ | ---------------------------------- |
//| Optimistic                  | Checks version at commit | High concurrency   | May fail if conflicts occur        |
//| Optimistic Force            | Force version increment  | Signals changes    | Extra version bumps                |
//| Pessimistic Read            | Locks row for reads      | Safe reads         | Can block others                   |
//| Pessimistic Write           | Locks row for write      | Prevents conflicts | Can cause deadlocks                |
//| Pessimistic Force Increment | Locks + version bump     | Strong protection  | Heavyweight, may reduce throughput |
//
//---
//
//# 🔹 5️⃣ Real-World Use Case
//
//Imagine a banking system:
//
//* Optimistic Lock → `Account balance` updated rarely, high reads
//* Pessimistic Write → `Transfer operation` to ensure no other transactions modify balance simultaneously
//
//---
//
//If you want, I can create a **full Spring Boot demo** that:
//
//* Shows **Persistence Context in action**
//* Uses **all lock types (optimistic + pessimistic)**
//* Shows **what happens when concurrent transactions update the same entity**
//

