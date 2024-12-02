package com.nt.response;

import lombok.Data;

@Data
public class Ticket {
   
	private Integer ticketId;
	private String  from;
	private String to;
	private String  trainNum;
	private String ticketCost;
	private String  ticketStatus;
	
}
