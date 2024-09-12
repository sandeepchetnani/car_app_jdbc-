import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.ty.dao.CarDao;
import com.ty.dto.Car;

class CarDaotest {
	@Test
	void testSaveLaptop() throws SQLException {
		Car car = new Car();
		car.setId(7);
		car.setName("dell");
		car.setBrand("intel");
		car.setCost(120);
		car.setManufactureYear(20);
		CarDao cardao = new CarDao();
		assertEquals(car, cardao.saveCar(car));
		// assertThrows(Exception.class,()-> {cardao.saveCar(car);});
	}

	@Test
	void testUpdateLaptop() throws SQLException {
		Car car = new Car();
		car.setId(3);
		car.setName("dell");
		car.setBrand("intel");
		car.setCost(120);
		car.setManufactureYear(20);
		CarDao cardao = new CarDao();
		assertEquals(car, cardao.updateCar(car));
		// assertThrows(Exception.class,()-> {cardao.saveCar(car);});
	}
	
	@Test
	void testDeleteLaptop() throws SQLException {
		Car car=new Car();
		car.setId(3);
		CarDao cardao = new CarDao();
		assertEquals(car, cardao.deleteCar(car.getId()));
	}
	

}
