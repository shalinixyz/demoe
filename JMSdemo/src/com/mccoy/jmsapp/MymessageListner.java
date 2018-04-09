package com.mccoy.jmsapp;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

public class MymessageListner implements MessageListener{

	@Override
	public void onMessage(Message message) 
	{
		
		if (message instanceof MapMessage)
		{
			MapMessage mapMessage = (MapMessage)message;
			
			try
			{
				String name = mapMessage.getString("Name");
				System.out.println("Name : " + name);
				String role = mapMessage.getString("Role");
				System.out.println("Role : " + role);
				Double sal = mapMessage.getDouble("Salary");
				System.out.println("Salary : " + sal);
				System.out.println("Message recieved");
			}
			catch (JMSException e)
			{
				throw new RuntimeException(e);
			}
		}
		else
		{
			System.out.println("Invalid Message Received");
		}
	}
	}

