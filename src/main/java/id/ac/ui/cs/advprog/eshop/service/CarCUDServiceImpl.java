package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarCUDServiceImpl implements CarCUDService {
    @Autowired
    private CarRepository carRepository;

    @Override
    public Car create(Car car) {
        // TODO Auto-generated method stub
        carRepository.create(car);
        return car;
    }

    @Override
    public void update(String carId, Car car) {
        // TODO Auto-generated method stub
        carRepository.update(carId, car);
    }

    @Override
    public void deleteCarById(String carId) {
        // TODO Auto-generated method stub
        carRepository.delete(carId);
    }
}