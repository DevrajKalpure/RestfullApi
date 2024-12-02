package com.nt.rest;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.request.Passenger;
import com.nt.response.Ticket;

@RestController
public class ERailRestController {
	
	private Map<Integer,Ticket> ticket=new HashMap<>();
	
	@PostMapping(
			value="/ticket",
			produces= {"application/xml", "application/json"},
			consumes= {"application/xml", "application/json"}

			)
	private Ticket bookTicket(@RequestBody Passenger passenger) {
		
		Random r=new Random();
		int ticketId =r.nextInt();
		
		Ticket t=new Ticket();
		t.setTicketId(ticketId);
		t.setFrom(passenger.getFrom());
		t.setTo(passenger.getTo());
		t.setTicketStatus("confirmed");
		t.setTrainNum(passenger.getTrainNum());
		t.setTicketCost("1500.00 INR");
		
		ticket.put(ticketId, t);
		
		return t;
	}
	
	@GetMapping(
			value="/ticket/{ticketId}",
			produces= {"application/xml", "application/json"}
			)
	public Ticket getTicket(@PathVariable  Integer ticketId) {
		
		if(ticket.containsKey(ticketId)) {
			return ticket.get(ticketId);
		}
		
		return null;
		
	}

}
