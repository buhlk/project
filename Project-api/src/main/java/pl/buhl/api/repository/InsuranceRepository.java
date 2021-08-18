package pl.buhl.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.buhl.api.model.Insurance;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {

}