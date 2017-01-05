package x595;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

	public List<Car> findByOrderByMakerAsc();
	
	public List<Car> findByLicenseInfoOwnerName(String ownerName);
	
	public List<Car> findByMaker(String maker);
	
	public List<Car> findByMakeYearBetween(int start, int end);
	
	public Car findByLicenseInfoLicensePlateNumber(String licensePlate);
}
