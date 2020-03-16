package pl.kolban.devices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.kolban.devices.utils.Utils;
import pl.kolban.devices.model.Device;
import pl.kolban.devices.service.DeviceService;

import java.util.List;

@Controller
public class DeviceController {

    DeviceService service;
    Utils utils;


    @Autowired
    public DeviceController(DeviceService service, Utils utils) {
        this.service = service;
        this.utils = utils;
    }

    @RequestMapping("/")
    public String viewHomePage(Model model){
        List<Device> allDevices = service.getAllDevices();
        model.addAttribute("allDevices", allDevices);
        return "index";
    }

    @RequestMapping("/addnewdevice")
    public String addNewDevice(Model model){
        Device newDevice = new Device();
        model.addAttribute("device", newDevice);
        return "addnewdevice";

    }

    @RequestMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("edit");

        Device device = service.getDeviceById(id);
        modelAndView.addObject("device", device);
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("device") Device device){

        Boolean deviceNameExists = utils.ifDeviceExists(device.getDeviceName());
        Boolean brandExists = utils.ifBrandExists(device.getBrandName());
        if(!deviceNameExists && brandExists) {
            service.saveDevice(device);
            return "redirect:/";
        } else {
            System.out.println("Device name exists : " + device.getDeviceName() + " or brand doesn't exists " + device.getBrandName());
            return "redirect:/";
        }
    }

    @RequestMapping(value = "delete/{id}")
    public String deleteDevice(@PathVariable Long id){
        service.deleteDeviceById(id);
        return "redirect:/";
    }

}
