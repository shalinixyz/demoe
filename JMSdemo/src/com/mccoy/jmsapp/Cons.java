package com.mccoy.jmsapp;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Cons {
	
	public static void main(String[] args)
	{
		try{
		 ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
         Connection connection = connectionFactory.createConnection();
         
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			Destination destination = session.createQueue("My_Queue1");
			
			MessageConsumer consumer = session.createConsumer(destination);
			
			System.out.println("Recieving message.......");
			consumer.setMessageListener(new MymessageListner());
			connection.start();
		
		
		}
		catch(JMSException e)
		{
			e.printStackTrace();
		}
		
	}

}
