package pl.kolban.devices.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.kolban.devices.repository.DeviceRepository;

import java.util.List;

@Controller
public class Utils {

    DeviceRepository deviceRepository;

    @Autowired
    public Utils(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public Boolean ifDeviceExists(String deviceName){
        List<String> deviceNames = deviceRepository.getDeviceNamesList();
        for(String s : deviceNames){
            if(s.equals(deviceName)){
                return true;
            }
        }
        return false;
    }

    public Boolean ifBrandExists(String brandName) {
        for (CompanyNameEnum company : CompanyNameEnum.values()) {
            if(brandName.equalsIgnoreCase(String.valueOf(company))){
                return true;
            }
        }
        return false;
    }


}
