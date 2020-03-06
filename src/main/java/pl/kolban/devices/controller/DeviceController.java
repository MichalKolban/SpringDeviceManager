package pl.kolban.devices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kolban.devices.model.Device;
import pl.kolban.devices.service.DeviceService;

import java.util.List;

@Controller
public class DeviceController {

    DeviceService service;

    @Autowired
    public DeviceController(DeviceService service) {
        this.service = service;
    }



    @RequestMapping("/")
    public String viewHomePage(Model model){
        List<Device> allDevices = service.getAllDevices();
        model.addAttribute("allDevices", allDevices);
        return "index";
    }


}
