package com.adepuu.exercises.session7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

public class Event
{
    private final String ID;
    private final HashMap<String, EventTicket> availableTickets = new HashMap<>();
    private final HashSet<String> bookingList = new HashSet<>();
    private int ticketQuota = 0;
    private int ticketSold = 0;

    public Event(int maxTickets)
    {
        UUID uuid = UUID.randomUUID();

        this.ticketQuota = maxTickets;
        this.ID = uuid.toString();
    }

    public HashMap<String, EventTicket> getTicketList()
    {
        return availableTickets;
    }


    public boolean bookTicket(String userId)
    {
        if (ticketSold >= ticketQuota)
        {
            System.out.println("Tickets sold!");
            return false;
        }

        if ( !bookingList.add(userId) )
        {
            System.out.println("Only allowed to book 1 ticket");
            return false;
        }
        return true;
    }

    public EventTicket confirmTicket(String userId)
    {
        if (bookingList.contains(userId) && ticketSold <= ticketQuota)
        {
            ticketSold++;
            EventTicket ticket = new EventTicket(this.ID);
            availableTickets.put(ticket.getID(), ticket);

            return ticket;
        }
        return null;
    }
}