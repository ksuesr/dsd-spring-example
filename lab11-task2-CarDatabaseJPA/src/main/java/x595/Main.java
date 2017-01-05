package x595;

import java.util.Date;
import java.util.Iterator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String... args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JpaConfig.class);
		
		CarRepository repo = ctx.getBean(CarRepository.class);
		
		log("Start testing CarRepository");
		
		LicenceInfo info1 = new LicenceInfo("Jane Doe", "jane@corp.com", new Date(), "N17D3E");
		LicenceInfo info2 = new LicenceInfo("Josh Maxwell", "josh@googol.com", new Date(), "G99331");
		LicenceInfo info3 = new LicenceInfo("JD", "saxe@me.com", new Date(), "HL9010");
		LicenceInfo info4 = new LicenceInfo("Triple corp", "triple@doodle.org", new Date(), "JDC13X");
		LicenceInfo info5 = new LicenceInfo("JD", "pro4@k5.com", new Date(), "A75Dc1");
		
		Car c1 = new Car("AMG", "A4", 2012, 110, info1);
		Car c2 = new Car("Genesis", "G20", 2008, 170, info2);
		Car c3 = new Car("Lena", "sigma", 2015, 150, info3);
		Car c4 = new Car("AMG", "A7", 2010, 130, info4);
		Car c5 = new Car("Tesla", "T1", 2011, 90, info5);
		
		
		log("Part 0. insert cars");
		repo.save(c1);
		repo.save(c2);
		repo.save(c3);
		repo.save(c4);
		repo.save(c5);
		
		Iterator<Car> it = repo.findAll().iterator();
		log("Part 0. result of inserted car: ");
		while(it.hasNext()) {
			log(it.next().toString());
		}
		
		log("Part 1. findByOrderByMakerAsc");
		it = repo.findByOrderByMakerAsc().iterator();
		log("Result: ");
		while(it.hasNext()) {
			log(it.next().toString());
		}
		
		log("Part 2. findByLicenseInfoOwnerName");
		it = repo.findByLicenseInfoOwnerName("JD").iterator();
		log("Result: ");
		while(it.hasNext()) {
			log(it.next().toString());
		}
		
		log("Part 3. findByMaker");
		it = repo.findByMaker("AMG").iterator();
		log("Result: ");
		while(it.hasNext()) {
			log(it.next().toString());
		}
		
		log("Part 4. findByMakeYearBetween");
		it = repo.findByMakeYearBetween(2010, 2013).iterator();
		log("Result: ");
		while(it.hasNext()) {
			log(it.next().toString());
		}
		
		log("Part 5. findByLicenseInfoLicensePlateNumber");
		Car c = repo.findByLicenseInfoLicensePlateNumber("HL9010");
		log("Result: ");
		log(c.toString());
		
	}
	
	private static void log(String msg) {
		try { 
			throw new Exception();
		} catch(Exception e) {
			StackTraceElement head = e.getStackTrace()[1];
			System.out.println("[" + head.getClassName() + "." + head.getMethodName() + "()] > " + msg);
		}
	}
}
