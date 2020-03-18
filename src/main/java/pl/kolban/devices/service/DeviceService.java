package pl.kolban.devices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kolban.devices.model.Device;
import pl.kolban.devices.repository.DeviceRepository;

import java.util.ArrayList;
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

    public void updateDevice(Device device) {

        long id = device.getId();
        String deviceName = device.getDeviceName();
        String brandName = device.getBrandName();
        String production = device.getProductionPlace();
        float price = device.getPrice();

        deviceRepository.updateDevice(id, deviceName, brandName, production, price);
    }


    public void deleteAll(){
        deviceRepository.deleteAll();
    }


    public void addNewDevicesToDB(){

        List<Device> devicesList = new ArrayList<>();

        devicesList.add(new Device(1l,"Playstation 4 Pro","Sony","Japan",1699f));
        devicesList.add(new Device(2l,"Xbox One X","Microsoft","USA",1299f));
        devicesList.add(new Device(3l,"Iphone 11 Pro Max","Apple","USA",5599f));
        devicesList.add(new Device(4l,"Nintendo Switch","Nintendo","Japan",1469f));
        devicesList.add(new Device(5l,"LG V40","LG","Korea",2999f));
        devicesList.add(new Device(6l,"MSI GF75 Thin 9SC","MSI","Taiwan",4999f));
        devicesList.add(new Device(7l,"Pixel 4XL","Google","USA",3599f));
        devicesList.add(new Device(8l,"Lenovo Legion Y7000","Lenovo","China",4298f));
        devicesList.add(new Device(9l,"Oneplus 7T","Oneplus","China",2349f));
        devicesList.add(new Device(10l,"OPPO Reno Z","Oppo","China",1199f));
        devicesList.add(new Device(11l,"Xiaomi Mi Note 10 Pro","Xiaomi","China",2799f));

        deviceRepository.saveAll(devicesList);
    }

    public void reset() {
        deviceRepository.reset();
    }
}
