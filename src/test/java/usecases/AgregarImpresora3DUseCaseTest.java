package usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.granja.command.AgregarImpresora3D;
import domain.granja.event.GranjaCreada;
import domain.granja.event.ImpresoraIncluida;
import domain.granja.value.GranjaID;
import domain.granja.value.Impresora3DID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;
import java.util.logging.Handler;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class AgregarImpresora3DUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void crearOrden(){
        //arrange
        GranjaID granjaID = GranjaID.of("migranjita");
        Impresora3DID impresora3DID = Impresora3DID.of("mimpresora");
        var command = new AgregarImpresora3D(granjaID,impresora3DID);

        var usecase= new AgregarImpresora3DUseCase();
        Mockito.when(repository.getEventsBy("migranjita")).thenReturn(history());
        usecase.addRepository(repository);
        //act

        var events=UseCaseHandler.getInstance()
                                    .setIdentifyExecutor(granjaID.value())
                                    .syncExecutor(usecase, new RequestCommand<>(command))
                                    .orElseThrow()
                                    .getDomainEvents();
        //asert

        var event = (ImpresoraIncluida) events.get(0);
        Assertions.assertEquals("granja.impresoraincluida",event.type);
        Assertions.assertEquals("mimpresora",event.Impresora3DID().value());
    }

    private List<DomainEvent> history() {
        return List.of(new GranjaCreada(GranjaID.of("miGranjita2")));
    }

}