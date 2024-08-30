package Proj.Login.Entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;



@Entity
@Table(name = "Empleados")
public class Empleado
{
    // ATRIBUTOS:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdEmpleado;


    @NotBlank(message = "El Nombre Es Requerido")
    private String Nombre;


    @NotNull
    @Column(nullable = false)
    private Double Sueldo;


    @NotBlank(message = "El Email Es Requerido")
    @Email(message = "El Email Debe Ser Válido")
    private String Email;


    @NotBlank(message = "La Contraseña Es Requerida")
    @Size(min = 5, message = "La Contraseña Debe Tener Al Menos 5 Caracteres")
    private String Contraseña;


    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date Fecha_Contratado;


    // Referencia A La Tabla Rol:
    @ManyToOne
    @JoinColumn(name = "IdRolEnEmpleado", nullable = false)
    private Rol Objeto_Rol;



    // ACCESORS:
    public Integer getIdEmpleado() {
        return IdEmpleado;
    }
    public void setIdEmpleado(Integer idEmpleado) {
        IdEmpleado = idEmpleado;
    }

    public @NotBlank(message = "El Nombre Es Requerido") String getNombre() {
        return Nombre;
    }
    public void setNombre(@NotBlank(message = "El Nombre Es Requerido") String nombre) {
        Nombre = nombre;
    }

    public @NotNull Double getSueldo() {
        return Sueldo;
    }
    public void setSueldo(@NotNull Double sueldo) {
        Sueldo = sueldo;
    }

    public @NotBlank(message = "El Email Es Requerido") @jakarta.validation.constraints.Email(message = "El Email Debe Ser Válido") String getEmail() {
        return Email;
    }
    public void setEmail(@NotBlank(message = "El Email Es Requerido") @jakarta.validation.constraints.Email(message = "El Email Debe Ser Válido") String email) {
        Email = email;
    }

    public @NotBlank(message = "La Contraseña Es Requerida") @Size(min = 5, message = "La Contraseña Debe Tener Al Menos 5 Caracteres") String getContraseña() {
        return Contraseña;
    }
    public void setContraseña(@NotBlank(message = "La Contraseña Es Requerida") @Size(min = 5, message = "La Contraseña Debe Tener Al Menos 5 Caracteres") String contraseña) {
        Contraseña = contraseña;
    }

    public @NotNull Date getFecha_Contratado() {
        return Fecha_Contratado;
    }
    public void setFecha_Contratado(@NotNull Date fecha_Contratado) {
        Fecha_Contratado = fecha_Contratado;
    }

    public Rol getObjeto_Rol() {
        return Objeto_Rol;
    }
    public void setObjeto_Rol(Rol objeto_Rol) {
        Objeto_Rol = objeto_Rol;
    }


}
