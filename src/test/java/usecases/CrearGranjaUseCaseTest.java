package usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import domain.granja.command.CrearGranja;
import domain.granja.event.GranjaCreada;
import domain.granja.value.GranjaID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearGranjaUseCaseTest {

    @Test
    void crearGranja(){
        // patron de pruebas triple a 1-arrange 2-act 3-assert

        //arrange
        GranjaID granjaID = GranjaID.of("valor"); //de esta forma se crea un id quemado por el usuario
        var command = new CrearGranja(granjaID);
        var usecase= new CrearGranjaUseCase();
        //act

        var events =UseCaseHandler.getInstance()
                .syncExecutor(usecase,new RequestCommand<>(command))
                .orElseThrow()//En caso de no haber respuesta lanza exepcion
                .getDomainEvents();
        //asert

        var event = (GranjaCreada)events.get(0);
        Assertions.assertEquals("granja.granjacreada",event.type);
        Assertions.assertEquals("valor",event.getGranjaID().value());

    }
}