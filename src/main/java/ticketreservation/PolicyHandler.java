package ticketreservation;

import ticketreservation.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverAble_Payrequest(@Payload Able able){

        if(able.isMe()){
            System.out.println("##### listener Payrequest : " + able.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReservationcanceled_Cancelrequest(@Payload Reservationcanceled reservationcanceled){

        if(reservationcanceled.isMe()){
            System.out.println("##### listener Cancelrequest : " + reservationcanceled.toJson());
        }
    }

}
