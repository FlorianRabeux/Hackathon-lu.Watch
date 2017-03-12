package be.nrb.lu.Watch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.nrb.lu.Watch.entitiy.*;
import be.nrb.lu.Watch.serviceData.serviceData;

@RestController
@CrossOrigin
public class ServiceController {
	
	@Autowired serviceData serviceData;

    @RequestMapping("/getService")
    public List<Service> getService(@RequestBody SearchServicePOI search) {
    	
    	System.out.println("Search service : " + search.getName() + " : " + search.getCategory());
    	
    	return serviceData.search(search);
    }
}
