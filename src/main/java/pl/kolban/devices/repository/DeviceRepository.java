package pl.kolban.devices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.kolban.devices.model.Device;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {


        Device getDeviceById(Long id);

        @Query(value = DEVICE_NAMES, nativeQuery = true)
        List<String> getDeviceNamesList();

        @Modifying(clearAutomatically = true)
        @Transactional
        @Query(value = UPDATE_DEVICE, nativeQuery = true)
        void updateDevice(@Param("id") long id, @Param("deviceName") String deviceName, @Param("brandName") String brandName, @Param("production") String production, @Param("price") float price);

        @Modifying(clearAutomatically = true)
        @Transactional
        @Query(value = RESET_DB, nativeQuery = true)
        void reset();

        String DEVICE_NAMES = " SELECT device_name FROM devices ";

        String UPDATE_DEVICE = " UPDATE devices d SET d.device_name = :deviceName, d.brand_name = :brandName, d.production = :production, d.price = :price" +
                " WHERE d.device_id = :id ";

        String RESET_DB = " ALTER TABLE devices AUTO_INCREMENT = 1 ";



        // Postgresql Setup

//        String UPDATE_DEVICE = " UPDATE devices SET device_name = :deviceName, brand_name = :brandName, production = :production, price = :price" +
//                " WHERE device_id = :id ";

//        String RESET_DB = " TRUNCATE TABLE devices RESTART IDENTITY; ";

}
