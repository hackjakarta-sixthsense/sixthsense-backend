package sixthsense.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sixthsense.backend.model.Menu;

@Repository
public interface MenuRepository extends JpaRepository< Menu,Long> {
}
