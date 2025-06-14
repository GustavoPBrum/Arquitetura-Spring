package io.spring.arquiteturaspring.montadora.configuration;

import io.spring.arquiteturaspring.montadora.Motor;
import io.spring.arquiteturaspring.montadora.TipoMotor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration // Essa classe vai ser scaneada, tambem para dizer que essa classe vai ter alguns Beans
public class MontadoraConfiguration {

    @Bean(name="motorAspirado")  // Bean eh quando criamos um metodo que retorna um objeto construido
    // Estamos injetando via CONSTRUTOR a nossa propriedade customizada
    public Motor motorAspirado(@Value("${app.montadora.motor-padrao}") Integer cavalos){  // cavalos definidos no application
        var motor = new Motor();
        motor.setCavalos(cavalos);
        motor.setCilindros(4);
        motor.setModelo("XPTO-0");
        motor.setLitragem(2.0);
        motor.setTipoMotor(TipoMotor.ASPIRADO);
        return motor;
    }

    @Bean(name="motorEletrico")
    public Motor motorEletrico(){
        var motor = new Motor();
        motor.setCavalos(110);
        motor.setCilindros(3);
        motor.setModelo("TH-40");
        motor.setLitragem(1.4);
        motor.setTipoMotor(TipoMotor.ELETRICO);
        return motor;
    }

    @Bean(name="motorTurbo")
    @Primary  //Bean primario do tipo Motor(bean padrao deste tipo, caso nao seja especificado pelo Dev qual o motor)
    public Motor motorTurbo(){
        var motor = new Motor();
        motor.setCavalos(180);
        motor.setCilindros(4);
        motor.setModelo("XPTO-01");
        motor.setLitragem(1.5);
        motor.setTipoMotor(TipoMotor.TURBO);
        return motor;
    }
}
