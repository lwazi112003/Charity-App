package za.ac.cput;

import org.charity.domain.*;
import org.charity.repository.*;
import org.charity.repository.impl.*;
import org.charity.util.Helper;

import java.time.LocalDate;
import java.math.BigDecimal;

public class CharityApplicationCompiler {
    private UserRepository userRepository;
    private DonorRepository donorRepository;
    private DonationRepository donationRepository;
    private BeneficiaryRepository beneficiaryRepository;
    private EventOrganizerRepository eventOrganizerRepository;

    public CharityApplicationCompiler() {
        initializeRepositories();
    }

    private void initializeRepositories() {
        userRepository = new UserRepositoryImpl();
        donorRepository = new DonorRepositoryImpl();
        donationRepository = new DonationRepositoryImpl();
        beneficiaryRepository = new BeneficiaryRepositoryImpl();
        eventOrganizerRepository = new EventOrganizerRepositoryImpl();
    }

    public void runApplication() {
        // Demonstrate User and Admin Creation
        createUsers();

        // Demonstrate Donor Creation
        createDonors();

        // Demonstrate Donation Creation
        createDonations();

        // Demonstrate Beneficiary Creation
        createBeneficiaries();

        // Demonstrate Event Organizer Creation
        createEventOrganizers();

        // Display Application Summary
        displayApplicationSummary();
    }

    private void createUsers() {
        // Create Admin
        Admin admin = new Admin.Builder()
                .userId(Helper.generateUniqueId())
                .adminId(Helper.generateUniqueId())
                .firstName("John")
                .lastName("Doe")
                .email("admin@charityapp.org")
                .phoneNumber("+1234567890")
                .registrationDate(LocalDate.now())
                .accessLevel(Admin.AdminLevel.SUPER_ADMIN)
                .build();
        userRepository.create(admin);

        // Create Regular User
        User regularUser = new User.Builder()
                .userId(Helper.generateUniqueId())
                .firstName("Jane")
                .lastName("Smith")
                .email("jane.smith@example.com")
                .phoneNumber("+0987654321")
                .registrationDate(LocalDate.now())
                .role(User.UserRole.DONOR)
                .build();
        userRepository.create(regularUser);
    }

    private void createDonors() {
        // Donor class would be similar to the pattern we've established
        Donor donor = new Donor.Builder()
                .donorId(Helper.generateUniqueId())
                .userId(Helper.generateUniqueId())
                .firstName("Alice")
                .lastName("Johnson")
                .email("alice.johnson@donor.com")
                .phoneNumber("+1122334455")
                .registrationDate(LocalDate.now())
                .donationType(Donor.DonorType.INDIVIDUAL)
                .totalDonationAmount(BigDecimal.valueOf(5000))
                .build();
        donorRepository.create(donor);
    }

    private void createDonations() {
        // Donation class creation
        Donation donation = new Donation.Builder()
                .donationId(Helper.generateUniqueId())
                .donorId(Helper.generateUniqueId())
                .amount(BigDecimal.valueOf(500))
                .donationDate(LocalDate.now())
                .donationType(Donation.DonationType.MONETARY)
                .build();
        donationRepository.create(donation);
    }

    private void createBeneficiaries() {
        // Beneficiary class creation
        Beneficiary beneficiary = new Beneficiary.Builder()
                .beneficiaryId(Helper.generateUniqueId())
                .userId(Helper.generateUniqueId())
                .firstName("Bob")
                .lastName("Williams")
                .email("bob.williams@beneficiary.org")
                .phoneNumber("+9988776655")
                .registrationDate(LocalDate.now())
                .beneficiaryType(Beneficiary.BeneficiaryType.INDIVIDUAL)
                .build();
        beneficiaryRepository.create(beneficiary);
    }

    private void createEventOrganizers() {
        // Event Organizer class creation
        EventOrganizer eventOrganizer = new EventOrganizer.Builder()
                .organizerId(Helper.generateUniqueId())
                .userId(Helper.generateUniqueId())
                .firstName("Charlie")
                .lastName("Brown")
                .email("charlie.brown@events.com")
                .phoneNumber("+1234987654")
                .registrationDate(LocalDate.now())
                .organizerLevel(EventOrganizer.OrganizerLevel.SENIOR)
                .build();
        eventOrganizerRepository.create(eventOrganizer);
    }

    private void displayApplicationSummary() {
        System.out.println("Charity Application Summary:");
        System.out.println("----------------------------");
        System.out.println("Total Users: " + userRepository.read().size());
        System.out.println("Total Donors: " + donorRepository.read().size());
        System.out.println("Total Donations: " + donationRepository.read().size());
        System.out.println("Total Beneficiaries: " + beneficiaryRepository.read().size());
        System.out.println("Total Event Organizers: " + eventOrganizerRepository.read().size());
    }

    public static void main(String[] args) {
        CharityApplicationCompiler compiler = new CharityApplicationCompiler();
        compiler.runApplication();
    }
}