package pl.kolban.devices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.kolban.devices.model.Device;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {


        Device getDeviceByDeviceName(String name);

        Device getDeviceById(Long id);

        @Query(value = DEVICE_NAMES, nativeQuery = true)
        List<String> getDeviceNamesList();


        String DEVICE_NAMES = " SELECT device_name FROM devices ";

}
