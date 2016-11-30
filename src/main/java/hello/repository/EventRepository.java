package hello.repository;

import hello.model.EventModel;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by kevin on 22/11/2016.
 */
public interface EventRepository extends CrudRepository<EventModel, Long> {


}
