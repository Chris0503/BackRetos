/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.CUATRIMOTO.Cuatrimoto;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author 57318
 */
public interface InterfaceReservation extends CrudRepository<Reservation, Integer>{
      //buscar todo por fecha de inicio después y fecha de inicio antes
  public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);

  //Cantidad de reservas completas vs canceladas.
  public List<Reservation> findAllByStatus(String status);

  //Top de los clientes que más dinero le han dejado a la compañía
  //SELECT clientid, COUNT(*) AS total FROM reservacion group by clientid order by desc;
  @Query("SELECT c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client)DESC")
  public List<Object[]> countTotalReservationsByClient();
}
    

