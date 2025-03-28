package za.ac.cput.Repository;

import za.ac.cput.Domain.Admin;
import za.ac.cput.util.Helper;

/**
 * AdminFactory.java
 * Factory class for creating Admin instances
 * Author: Lwazi Shozi (230220061)
 * Date: 27 March 2025
 */
public class AdminFactory {

    public static Admin createAdmin(String firstName, String lastName, String email, String department) {
        if (Helper.isNullOrEmpty(firstName) ||
                Helper.isNullOrEmpty(lastName) ||
                Helper.isNullOrEmpty(email) ||
                Helper.isNullOrEmpty(department)) {
            throw new IllegalArgumentException("All fields are required");
        }

        String adminId = Helper.generateId();

        return new Admin.Builder()
                .adminId(adminId)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .department(department)
                .build();
    }

    /**
     * Creates an Admin instance with a specific ID (for testing or special cases)
     * @param adminId The admin's ID
     * @param firstName The admin's first name
     * @param lastName The admin's last name
     * @param email The admin's email
     * @param department The admin's department
     * @return A new Admin instance
     * @throws IllegalArgumentException if any required field is null or empty
     */
    public static Admin createAdminWithId(String adminId, String firstName, String lastName,
                                          String email, String department) {
        if (Helper.isNullOrEmpty(adminId) ||
                Helper.isNullOrEmpty(firstName) ||
                Helper.isNullOrEmpty(lastName) ||
                Helper.isNullOrEmpty(email) ||
                Helper.isNullOrEmpty(department)) {
            throw new IllegalArgumentException("All fields are required");
        }

        return new Admin.Builder()
                .adminId(adminId)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .department(department)
                .build();
    }
}