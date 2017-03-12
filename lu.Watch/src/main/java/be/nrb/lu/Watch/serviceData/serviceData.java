package be.nrb.lu.Watch.serviceData;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import be.nrb.lu.Watch.entitiy.Address;
import be.nrb.lu.Watch.entitiy.SearchServicePOI;
import be.nrb.lu.Watch.entitiy.Service;
import be.nrb.lu.Watch.entitiy.Zone;

@Component
public class serviceData {

	private List<Service> services;
	
	@PostConstruct
	public void initData()
	{
		services = new ArrayList<>();
		
		services.add(new Service("chl luxembourg", "hospital",new Address("Rue du Fort Olisy", "2", 2261, "", "Luxembourg", new Zone("49.612624", "6.137868", "300")) ));
		
	}
	
	public List<Service> search(SearchServicePOI search)
	{
		List<Service> serviceSearch = new ArrayList<>();
		
		for(Service service : services)
		{
			if(service.getCategory().isEmpty() == false)
			{
				if(service.getCategory().toLowerCase().contains(search.getCategory().toLowerCase()) == true)
				{	
					if(service.getName().toLowerCase().isEmpty())
					{
						serviceSearch.add(service);
					}
					else
					{
						if(service.getName().toLowerCase().contains(search.getName().toLowerCase()) == true)
						{
							serviceSearch.add(service);
						}
					}
				}
			} else {
				if(service.getName().toLowerCase().isEmpty())
				{
					serviceSearch.add(service);
				}
				else
				{
					if(service.getName().toLowerCase().contains(search.getName().toLowerCase()) == true)
					{
						serviceSearch.add(service);
					}
				}
			}
		}
		
		return serviceSearch;
	}
}
