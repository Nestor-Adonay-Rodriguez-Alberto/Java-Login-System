package Proj.Login.Acceso_Datos.Repositorios;

import Proj.Login.Entidades.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRolRepository extends JpaRepository<Rol,Integer>
{
}
