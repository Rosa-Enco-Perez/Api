package com.tarea.generation.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//Anotaciones de Java orientada a objetos y la persistencia de datos, especialmente en el contexto de los frameworks de mapeo objeto-relacional (ORM) como Hibernate o JPA (Java Persistence API)
@Entity // Esta anotación se utiliza en el contexto de JPA para marcar una clase como una entidad. En el contexto de bases de datos, una entidad es una tabla. En otras palabras, la clase que lleva esta anotación se mapeará a una tabla en la base de datos.
@Table(name = "comentario") //Esta anotación se utiliza para especificar el nombre de la tabla en la base de datos a la que se debe asignar la clase anotada con @Entity. En este caso, la tabla se llamará "comentario" en la base de datos.
@Getter // Estas anotaciones son parte de Project Lombok, una biblioteca de Java que ayuda a reducir la verbosidad del código. @Getter se utiliza para generar automáticamente los métodos de getter para todos los campos de la clase,
@Setter //@Setter se utiliza para generar automáticamente los métodos de setter para todos los campos de la clase.
@NoArgsConstructor //genera un constructor sin argumentos,
@AllArgsConstructor //genera un constructor que acepta todos los campos de la clase como argumentos. Estas anotaciones son útiles para crear instancias de la clase sin tener que escribir los constructores manualmente.
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comentarioId;

    @Column(name = "texto")
    private String texto;

    @Column(name = "fecha_de_creacion", length = 40)
    private String fechaCreacion;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "tarea_id")
    private Tarea tarea;

    public Comentario(long comentarioId){
        this.comentarioId = comentarioId;
    }


}
