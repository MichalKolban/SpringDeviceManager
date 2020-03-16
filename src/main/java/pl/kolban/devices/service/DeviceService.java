package pl.kolban.devices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kolban.devices.model.Device;
import pl.kolban.devices.repository.DeviceRepository;

import java.util.List;

@Service
public class DeviceService {

    DeviceRepository deviceRepository;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public List<Device> getAllDevices(){
        List<Device> allDevices = deviceRepository.findAll();
        return allDevices;
    }

    public Device getDeviceById(Long id){
        Device deviceDB = deviceRepository.getDeviceById(id);
        return deviceDB;
    }

    public void saveDevice(Device device){
        deviceRepository.save(device);
    }

    public void deleteDeviceById(Long id){
        deviceRepository.deleteById(id);
    }









}
