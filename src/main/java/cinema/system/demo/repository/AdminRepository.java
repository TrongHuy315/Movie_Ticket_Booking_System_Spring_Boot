package cinema.system.demo.repository;

import cinema.system.demo.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    // Tìm admin bằng email
    Optional<Admin> findByEmail(String email);
}
