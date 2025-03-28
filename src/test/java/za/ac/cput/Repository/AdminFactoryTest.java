package za.ac.cput.Repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Admin;
import static org.junit.jupiter.api.Assertions.*;

/**
 * AdminFactoryTest.java
 * Test class for AdminFactory
 * Author: Lwazi Shozi (230220061)
 * Date: 27 March 2025
 */
class AdminFactoryTest {

    @Test
    void testCreateAdminSuccess() {
        Admin admin = AdminFactory.createAdmin("John", "Doe", "john.doe@example.com", "IT");
        assertNotNull(admin);
        assertNotNull(admin.getAdminId());
        assertEquals("John", admin.getFirstName());
        assertEquals("Doe", admin.getLastName());
        assertEquals("john.doe@example.com", admin.getEmail());
        assertEquals("IT", admin.getDepartment());
        System.out.println("Created admin: " + admin);
    }

    @Test
    void testCreateAdminWithIdSuccess() {
        Admin admin = AdminFactory.createAdminWithId("A123", "Jane", "Smith",
                "jane.smith@example.com", "HR");
        assertNotNull(admin);
        assertEquals("A123", admin.getAdminId());
        assertEquals("Jane", admin.getFirstName());
        assertEquals("Smith", admin.getLastName());
        assertEquals("jane.smith@example.com", admin.getEmail());
        assertEquals("HR", admin.getDepartment());
        System.out.println("Created admin with ID: " + admin);
    }

    @Test
    void testCreateAdminWithNullFirstName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            AdminFactory.createAdmin(null, "Doe", "john.doe@example.com", "IT");
        });
        assertEquals("All fields are required", exception.getMessage());
        System.out.println("Test passed: " + exception.getMessage());
    }

    @Test
    void testCreateAdminWithEmptyLastName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            AdminFactory.createAdmin("John", "", "john.doe@example.com", "IT");
        });
        assertEquals("All fields are required", exception.getMessage());
        System.out.println("Test passed: " + exception.getMessage());
    }

    @Test
    void testCreateAdminWithInvalidEmail() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            AdminFactory.createAdmin("John", "Doe", "invalid-email", "IT");
        });
        // Note: This test assumes email validation is done in the builder
        // You might want to add proper email validation in the factory
        System.out.println("Test passed: " + exception.getMessage());
    }

    @Test
    void testCreateAdminWithIdWithNullDepartment() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            AdminFactory.createAdminWithId("A123", "John", "Doe", "john.doe@example.com", null);
        });
        assertEquals("All fields are required", exception.getMessage());
        System.out.println("Test passed: " + exception.getMessage());
    }
}