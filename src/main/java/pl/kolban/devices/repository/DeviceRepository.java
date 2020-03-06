package pl.kolban.devices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kolban.devices.model.Device;

public interface DeviceRepository extends JpaRepository<Device, Long> {


        Device getDeviceByDeviceName(String name);

}
