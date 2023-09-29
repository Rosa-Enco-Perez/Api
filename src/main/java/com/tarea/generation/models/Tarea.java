package com.tarea.generation.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tarea")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tarea {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tareaId;

   @Column(name = "titulo", length = 25)
   private String titulo;

   @Column(name = "descripcion", length = 90)
   private String descripcion;

   @Column(name = "fecha_vencimiento", length = 30)
   private String fechaVencimiento;

   @JsonBackReference
   @ManyToOne
   @JoinColumn(name = "usuario_id")
   private Usuario usuario;

   @JsonManagedReference
   //Para borrar los comentarios de una tarea
   @OneToMany(mappedBy = "tarea", cascade = CascadeType.ALL)
   private List<Comentario> comentarios;

   public Tarea(long tareaId){
      this.tareaId = tareaId;
   }

}
