package mira.dbproject.carrental.service.entityservice;

import javax.transaction.Transactional;
import mira.dbproject.carrental.domain.dto.CarDto;
import mira.dbproject.carrental.domain.entity.CarParameter;
import mira.dbproject.carrental.repository.dao.CarParameterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarParameterService {

  @Autowired
  CarParameterDao carParameterDao;

  @Autowired
  BodyTypeService bodyTypeService;

  @Autowired
  CarStatusService carStatusService;


  @Transactional
  public CarParameter save(CarParameter carParameter) {
    return carParameterDao.save(carParameter);
  }


  public CarParameter createNewParameter(CarDto carDto) {
    CarParameter carParameter = new CarParameter();

    carParameter.setBodyType(bodyTypeService.findById(carDto.getBodyTypeDtoId()).get());
    carParameter.setCarStatus(carStatusService.findById(carDto.getCarStatus()).get());
    carParameter.setYearOfProd(carDto.getYearOfProd());
    carParameter.setAverageFuelConsumption(carDto.getAverageFuelConsumption());
    carParameter.setCurrentMileage(carDto.getCurrentMileage());
    carParameter.setEngineSize(carDto.getEngineSize());
    carParameter.setDailyRate(carDto.getDailyRate());
    carParameter.setPower(carDto.getPower());
    return carParameter;
  }

}
