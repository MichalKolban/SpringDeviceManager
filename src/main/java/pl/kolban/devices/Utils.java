package pl.kolban.devices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.kolban.devices.repository.DeviceRepository;
import pl.kolban.devices.service.DeviceService;

import java.util.List;

@Controller
public class Utils {

    DeviceRepository deviceRepository;

    @Autowired
    public Utils(DeviceService deviceService, DeviceRepository deviceRepository) {
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

}
