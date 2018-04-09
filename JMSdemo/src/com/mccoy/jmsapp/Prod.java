package com.mccoy.jmsapp;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Prod 
{
	public static void main(String[] args) 
	{
		try{
			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
			Connection connection = connectionFactory.createConnection();
			connection.start();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue("My_Queue1");
			MessageProducer producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		
			
			MapMessage message = session.createMapMessage();
			
			message.setString("Name", "Shalini");
			message.setString("Role", "Developer");
			message.setDouble("Salary", 25000);
		
			System.out.println("sending message.....");
			producer.send(message);
			System.out.println("Message sent..!!");
			session.close();
			connection.close();
		}
		catch(JMSException e)
		{
			e.printStackTrace();
		}
		
	}

}
