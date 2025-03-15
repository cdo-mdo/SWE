package org.edu.miu.cs.cs425.eregistrar;

import org.edu.miu.cs.cs425.eregistrar.model.Role;
import org.edu.miu.cs.cs425.eregistrar.model.RoleName;
import org.edu.miu.cs.cs425.eregistrar.model.Student;
import org.edu.miu.cs.cs425.eregistrar.model.User;
import org.edu.miu.cs.cs425.eregistrar.repository.RoleRepository;
import org.edu.miu.cs.cs425.eregistrar.repository.StudentRepository;
import org.edu.miu.cs.cs425.eregistrar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Component
public class InitData implements CommandLineRunner {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private void initializeRoles() {
        if (roleRepository.findByName(RoleName.ADMIN).isEmpty()) {
            roleRepository.save(new Role(RoleName.ADMIN));
        }
        if (roleRepository.findByName(RoleName.REGISTRAR).isEmpty()) {
            roleRepository.save(new Role(RoleName.REGISTRAR));
        }
        if (roleRepository.findByName(RoleName.STUDENT).isEmpty()) {
            roleRepository.save(new Role(RoleName.STUDENT));
        }
    }

    private void initializeUsers() {
        createUserIfNotExists("admin", "admin123", RoleName.ADMIN);
        createUserIfNotExists("registrar", "registrar123", RoleName.REGISTRAR);
        createUserIfNotExists("student", "student123", RoleName.STUDENT);
    }

    private void createUserIfNotExists(String username, String rawPassword, RoleName roleName) {
        if (userRepository.findByUsername(username).isEmpty()) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(passwordEncoder.encode(rawPassword));

            Set<Role> roles = new HashSet<>();
            roleRepository.findByName(roleName).ifPresent(roles::add);
            user.setRoles(roles);

            userRepository.save(user);
            System.out.println("Created user: " + username + " with role " + roleName);
        }
    }

    private void createStudents() {
        for (int i = 0; i < 50; i++) {
            Student student = generateStudent(i);
            studentRepository.save(student);
        }
    }

    private static final String[] FIRST_NAMES = {
            "John", "Emma", "Michael", "Sophia", "Daniel", "Olivia", "James", "Charlotte",
            "Ethan", "Ava", "Liam", "Isabella", "Benjamin", "Mia", "Lucas", "Amelia",
            "Henry", "Harper", "William", "Evelyn", "Alexander", "Sofia", "David", "Scarlett",
            "Matthew", "Ella", "Joseph", "Luna", "Samuel", "Grace", "Sebastian", "Chloe",
            "Jack", "Victoria", "Owen", "Aria", "Julian", "Lily", "Wyatt", "Zoey",
            "Daniel", "Penelope", "Levi", "Madison", "Isaac", "Layla", "Gabriel", "Nova",
            "Carter", "Hannah"
    };

    private static final String[] LAST_NAMES = {
            "Doe", "Johnson", "Smith", "Brown", "Miller", "Wilson", "Taylor", "Anderson",
            "Thomas", "Martinez", "Hernandez", "Lopez", "Gonzalez", "Perez", "White", "Harris",
            "Clark", "Lewis", "Young", "Walker", "Hall", "Allen", "King", "Wright",
            "Scott", "Green", "Adams", "Baker", "Nelson", "Carter", "Mitchell", "Evans",
            "Garcia", "Rodriguez", "Moore", "Stewart", "Thompson", "Hughes", "Sanders", "Price",
            "Bell", "Kelly", "Bryant", "Ward", "Coleman", "Jenkins", "Reed", "Bailey"
    };

    private static final String[] MIDDLE_NAMES = { "A.", "B.", "C.", "D.", "E.", "F.", "G.", "H.", "I.", "J.", null };

    private static final Random random = new Random();


    private static Student generateStudent(int index) {
        String studentNumber = "S2024" + String.format("%03d", index);
        String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        String middleName = MIDDLE_NAMES[random.nextInt(MIDDLE_NAMES.length)];
        String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
        Double cgpa = random.nextBoolean() ? (2.5 + (random.nextDouble() * 1.5)) : 0.0; // Some students have null CGPA
        LocalDate enrollmentDate = LocalDate.of(2020 + random.nextInt(4), 1 + random.nextInt(12), 1 + random.nextInt(28));
        boolean isInternational = random.nextBoolean();

        return new Student(studentNumber, firstName, middleName, lastName, cgpa, enrollmentDate, isInternational);
    }

    @Override
    public void run(String... args) throws Exception {
        createStudents();
        initializeUsers();
        initializeRoles();
    }
}
