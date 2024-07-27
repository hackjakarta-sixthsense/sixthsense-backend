package sixthsense.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import sixthsense.backend.model.Promo;

@Repository
public interface PromoRepository extends JpaRepository< Promo,Long> {



}
