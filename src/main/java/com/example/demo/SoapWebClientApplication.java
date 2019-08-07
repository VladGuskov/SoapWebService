package com.example.demo;

import com.example.demo.model.NdsRequest2;
import com.example.demo.model.NdsResponse2;
import com.example.demo.model.ObjectFactory;
import com.example.demo.service.Connector;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoapWebClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoapWebClientApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(Connector connector) {
        return args -> {
            String[] strings = new String[]{
                    "3664069395",
                    "3664069396",
                    "3664069397",
                    "3664069398",
                    "3664069399"};
            if (args.length > 0) {
                System.arraycopy(args, 0, strings, 0, strings.length);
            }
            ObjectFactory objectFactory = new ObjectFactory();
            NdsRequest2 ndsRequest2 = objectFactory.createNdsRequest2();
            for (String string : strings) {
                NdsRequest2.NP ndsRequest2NP = objectFactory.createNdsRequest2NP();
                ndsRequest2NP.setINN(string);
                ndsRequest2.getNP().add(ndsRequest2NP);
            }
            NdsResponse2 ndsResponse2 = (NdsResponse2) connector.callWebService("http://npchk.nalog.ru:80/FNSNDSCAWS_2", ndsRequest2);
            for (NdsResponse2.NP np : ndsResponse2.getNP()) {
                System.out.println(np.getState());
            }
        };
    }
}
