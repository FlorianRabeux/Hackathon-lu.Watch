package be.nrb.lu.Watch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import be.nrb.lu.Watch.entitiy.*;
import notification.sendNotification;

@RestController
@CrossOrigin
public class UserController {

    
    private Zone zone = new Zone("49.600491", "6.113635", "1000000");
    private Double position = Double.valueOf("0.0001");
    
    private List<Thing> things = new ArrayList<>();
    private List<Rule> rules = new ArrayList<>();
    
    private Rule rule;
    
    private List<Zone> zones;
    private int count = 0;
    
    private Boolean notificationSend = false;
    
    @PostConstruct
    public void initZones() {
    	zones = new ArrayList<>();
    	zones.add(new Zone("49.600481", "6.113635"));
    	zones.add(new Zone("49.600691", "6.113625"));
    	zones.add(new Zone("49.600285", "6.113603"));
    	zones.add(new Zone("49.600525", "6.114046"));
    	zones.add(new Zone("49.600021", "6.113182"));
    	zones.add(new Zone("49.600283", "6.111216"));
    	zones.add(new Zone("49.600548", "6.108143"));
    	
    }
    

    @CrossOrigin("login")
    @RequestMapping("/login")
    public Boolean login(@RequestParam(value="login", defaultValue="") String login, @RequestParam(value="password", defaultValue="") String password) {
        
    	HashMap<String,User> users = new HashMap<>();
    	
    	users.put("Florian",new User("Florian", "Flo"));
    	users.put("test",new User("test", "test"));
    	
    	if(users.containsKey(login) == true)
    	{
    		User user = users.get(login);
    		if(password.equals(user.getPassword()))
    		{
    			return true;
    		}
    		return false;
    	}
    	return false;
    }
    
    @RequestMapping("/getPosition")
    public Zone getPosition(@RequestParam(value="id", defaultValue="") String id) {
        
    	/*Double lat = Double.valueOf(zone.getLat());
    	Double lng = Double.valueOf(zone.getLng()); 
    	 
    	lat = lat - position;   
    	lng = lng - position;  
    	   
    	zone.setLat(lat.toString());   
    	zone.setLng(lng.toString());
    	        */
    	return zone;   
    }    
    
    @RequestMapping("/notification")
    public Boolean setNotification(@RequestParam(value="id", defaultValue="") String id,@RequestParam(value="state", defaultValue="") String state) {
        
    	System.out.println(id + " : " + state);
    	        
    	return true;   
    }       
 
    @RequestMapping("/things")     
    public List<Thing> things() {
         
    	
    	if(things.isEmpty())  
    	{
	    	things.add(new Thing("1", "Maurine", "In secure", "Dance", "13h00", "17h00", "My daughter's Sunday dance class                                     ","img2"));
	    	//things.add(new Thing("2", "Jean-Luc", "Out of way", "Trahomvail", "06h00", "14h00", "Profile permettant de surveiller les déplacements de mon enfant","user"));
	    	things.add(new Thing("3", "Ms Alzheimer", "In secure", "Home", "00h00", "00h00", "Mom must be always at home","img1"));
    	}
	    	System.out.println("things request");
    	return things;
    }
    
    @RequestMapping("/reset")
    public Boolean reset() {
    	zone = new Zone("49.600491", "6.113635", "1000000");
    	count =0;
    	notificationSend = false;
    	return true;
    }
    
    @RequestMapping("/newRule")
    public Boolean newRule(@RequestBody NewRule newRule) {
    	
    	System.out.println(newRule.getName());
    	Rule tmpRule = new Rule(UUID.randomUUID().toString(),newRule.getName(), newRule.getTimeFrom(), newRule.getTimeTo(), Day.getDays(newRule.getDaysMonday(), newRule.getDaysTuesday(), newRule.getDaysWednesday(), newRule.getDaysThursday(), newRule.getDaysFriday(), newRule.getDaysSaturday(), newRule.getDaysSunday()), newRule.getNotificationEmail().isEmpty() ? false : true, newRule.getNotificationSms().isEmpty() ? false : true, true, "Profile permettant de surveiller les déplacements de mon enfant Profile permettant de surveiller les déplacements de mon enfant", "secure", new Zone(newRule.getPositionAreaLat().toString(), newRule.getPositionAreaLng().toString(), newRule.getPositionAreaRadius().toString()),new Zone("30.509742", "-0.120850"));
    	if(newRule.getName().equals("Home"))
		{
			rule = tmpRule;
		}
    	rules.add(rule);
    	return true;
    }
    
    @RequestMapping("/newThing")
    public Boolean newThing(@RequestBody NewThing newThing) {
    	
    	System.out.println(newThing.getName());
    	
    	things.add(new Thing(UUID.randomUUID().toString(), newThing.getName(), "Unknown", "", "", "", newThing.getDescription(),newThing.getImage()));
    	//rules.add(new Rule(UUID.randomUUID().toString(),newRule.getName(), newRule.getTimeFrom(), newRule.getTimeTo(), Day.getDays(newRule.getDaysMonday(), newRule.getDaysTuesday(), newRule.getDaysWednesday(), newRule.getDaysThursday(), newRule.getDaysFriday(), newRule.getDaysSaturday(), newRule.getDaysSunday()), newRule.getNotificationEmail().isEmpty() ? false : true, newRule.getNotificationSms().isEmpty() ? false : true, true, "Profile permettant de surveiller les déplacements de mon enfant Profile permettant de surveiller les déplacements de mon enfant", "secure", new Zone(newRule.getPositionAreaLat().toString(), newRule.getPositionAreaLng().toString(), newRule.getPositionAreaRadius().toString()),new Zone("30.509742", "-0.120850")));
    	return true;
    }
    
    @RequestMapping("/rules")
    public List<Rule> rules(@RequestParam(value="id", defaultValue="") String id) throws IOException {
        
    	/*if(rules.isEmpty())
    	{
    		rules.add(new Rule("2","Basketball", "19h00", "21h00", Day.getDays(false, false, true, true, false, false, true), true, false, false, "Profile permettant de surveiller les déplacements de mon enfant Profile permettant de surveiller les déplacements de mon enfant", "inactive", new Zone("40.508742", "-0.120850", "100"),new Zone("40.509742", "-0.120850")));
        	rules.add(new Rule("3","Other", "08h00", "9h00", Day.getDays(true, false, false, false, false, false, false), false, true, false, "Profile permettant de surveiller les déplacements de mon enfant Profile permettant de surveiller les déplacements de mon enfant", "unsecure", new Zone("30.508742", "-0.120850", "100"),new Zone("30.509742", "-0.120850")));
    	}*/
    	
    	/*
    	 * this.name = name;
		this.dateFom = dateFom;
		this.dateTo = dateTo;
		this.days = days; list day
		this.notification = notification; list string
		this.notificationEnable = notificationEnable; 
		this.description = description;
		this.state = state;
		this.zone = zone;
    	 */
    	

    	/*Double lat = Double.valueOf(zone.getLat());
    	Double lng = Double.valueOf(zone.getLng());
    	
    	lat = lat - position;
    	lng = lng - position;
    	
    	zone.setLat(lat.toString());
    	zone.setLng(lng.toString());*/
    	
    	List<Rule> rulesTMP = new ArrayList<>(rules);
    	
    	if(id.equals("1"))
    	{
        	rulesTMP.add(new Rule("1","Dance", "13h00", "17h00", Day.getDays(false, false, false, false, false, false, true), true, true, true, "My daughter's Sunday dance class", "secure", new Zone("49.574447", "6.153368", "100"), new Zone("49.574547", "6.153368", "100")));
    	}
    	if(id.equals("3"))
    	{
    		Rule tmpRule = new Rule("1","Home", "00h00", "00h00", Day.getDays(true, true, true, true, true, true, true), true, true, true, "Mom must be always at home", "secure", new Zone("51.508742", "-0.120850", "1000"), zone);
    		
    		tmpRule.setZone(zone);
    		if(count < zones.size())
    		{
    			tmpRule.setUserPosition(zones.get(count));
    			count++;
    		}
    		else
    		{
    			tmpRule.setUserPosition(zones.get(count-1));
    		}
    		
    		if(count < 4)
    		{
    			System.out.println("secure");
    			tmpRule.setState("secure");
    		}
    		else
    		{
    			System.out.println("unsecure");
    			tmpRule.setState("unsecure");
    			if(notificationSend == false)
    			{
    				System.out.println("Notification send");
    				sendNotification.sendSMS("Ms Alzheimer is out of the safe zone", "0032475215492");
    				sendNotification.sendEmail("Ms Alzheimer is out of the safe zone", "florian.rabeux@nrb.be", "Alert");
    				notificationSend = true;
    			}
    		}
    		
    		
    		
    		rulesTMP = new ArrayList<>();
    		rulesTMP.add(tmpRule);
    		
    		
    	}
    	
    	
    	
    	
    	return rulesTMP;
    }
    
    
    
}
