package Lorem_Software.Library_Maintenance_System.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Lorem_Software.Library_Maintenance_System.business.entity.Autor;


@Repository
public interface AutorDAO extends JpaRepository<Autor, Long> {
/*
* Se hereda de JpaRepository operaciones de acceso a datos comunes a todas las 
entidades:
* E save(E)
* List<E> saveAll(List<E>)
* List<E> findAll()
* E findById(id)
* delete(E)
* deleteById(id)
* ...
* 
* Aquí se podrían definir consultas de selección más específicas y complejas
**/
}
