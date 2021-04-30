package com.pe.mosip.Config;

import com.pe.mosip.Listener.PushResToOutbound;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.store.kahadb.KahaDBPersistenceAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.management.Query;
import java.util.jar.JarEntry;

@Configuration
public class JmsConfig {


    public String in_brokerUrl = "tcp://localhost:5673";
    public String out_brokerUrl = "tcp://localhost:5674";


    @Bean
    public BrokerService in_broker() throws Exception {
        final BrokerService broker = new BrokerService();
        broker.addConnector(in_brokerUrl);
        broker.setBrokerName("in_broker");
        broker.setUseJmx(false);
        broker.setPersistent(false);
        return broker;
    }

    @Bean
    public BrokerService out_broker() throws Exception {
        final BrokerService broker = new BrokerService();
        broker.addConnector(out_brokerUrl);
        broker.setBrokerName("out_broker");
        broker.setUseJmx(false);
        broker.setPersistent(false);
        return broker;
    }

//
//    @Bean
//    public ConnectionFactory in_jmsConnectionFactory() {
//        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:5673");
//        return connectionFactory;
//    }
//
//    @Bean
//    public ConnectionFactory out_jmsConnectionFactory() {
//        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:5674");
//        return connectionFactory;
//    }
//
//    @Bean
//    public JmsTemplate in_jmsTemplate() {
//        JmsTemplate jmsTemplate = new JmsTemplate();
//        jmsTemplate.setConnectionFactory(in_jmsConnectionFactory());
//        jmsTemplate.setDefaultDestinationName("inbound.queue");
//        return jmsTemplate;
//    }
//
//    @Bean
//    public JmsTemplate out_jmsTemplate() {
//        JmsTemplate jmsTemplate = new JmsTemplate();
//        jmsTemplate.setConnectionFactory(out_jmsConnectionFactory());
//        jmsTemplate.setDefaultDestinationName("outbound.queue");
//        return jmsTemplate;
//    }
//
//    @Bean
//    public JmsListenerContainerFactory<?> jmsListenerContainerFactory(@Qualifier("in_jmsConnectionFactory") ConnectionFactory connectionFactory,
//                                                                      DefaultJmsListenerContainerFactoryConfigurer configurer) {
//        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
//        configurer.configure(factory, connectionFactory);
//        return factory;
//    }
//
//    @Bean
//    public JmsListenerContainerFactory<?> jmsListenerContainerFactory2(
//            @Qualifier("out_jmsConnectionFactory") ConnectionFactory connectionFactory,
//            DefaultJmsListenerContainerFactoryConfigurer configurer) {
//        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
//        configurer.configure(factory, connectionFactory);
//        return factory;
//    }


    @Bean
    public Queue getInboundQueue() {
        return new ActiveMQQueue("inbound.queue");
    }


    @Bean
    public Queue getOutboundQueue() {
        ActiveMQQueue activeMQQueue = new ActiveMQQueue("outbound.queue");
        PushResToOutbound pushResToOutbound = new PushResToOutbound();
        pushResToOutbound.setGetOutboundQueue(activeMQQueue);
        return activeMQQueue;
    }


    @Bean
    public ActiveMQConnectionFactory in_activeMQConnectionFactory(){
        ActiveMQConnectionFactory activeMQConnectionFactory=new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(in_brokerUrl);
        activeMQConnectionFactory.setTrustAllPackages(true);
        return activeMQConnectionFactory;
    }

    @Bean
    public ActiveMQConnectionFactory out_activeMQConnectionFactory(){
        ActiveMQConnectionFactory activeMQConnectionFactory=new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(out_brokerUrl);
        activeMQConnectionFactory.setTrustAllPackages(true);
        return activeMQConnectionFactory;
    }

    @Bean
    public JmsTemplate in_jmsTemplate(){
        return new JmsTemplate(in_activeMQConnectionFactory());
    }

    @Bean
    public JmsTemplate out_jmsTemplate(){
        JmsTemplate jmsTemplate = new JmsTemplate(out_activeMQConnectionFactory());
        PushResToOutbound pushResToOutbound = new PushResToOutbound();
        pushResToOutbound.setOut_jmsTemplate(jmsTemplate);
        return jmsTemplate;
    }


    @Bean
    public JmsListenerContainerFactory<?> in_jmsListenerContainerFactory(@Qualifier("in_activeMQConnectionFactory") ConnectionFactory connectionFactory,
                                                                      DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        return factory;
    }

    @Bean
    public JmsListenerContainerFactory<?> out_jmsListenerContainerFactory(@Qualifier("out_activeMQConnectionFactory") ConnectionFactory connectionFactory,
                                                                         DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        return factory;
    }
}
