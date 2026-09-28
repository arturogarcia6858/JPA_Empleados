package com.example.jpa_empleos.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Vacantes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vacante {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;

    @Column(name = "descripcion", nullable = false, columnDefinition = "text")
    private String description;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "salario", nullable = false)
    private Double salario;

    @Enumerated(EnumType.STRING)
    @Column(name = "estatus", nullable = false)
    private EstatusVacante estatus;

    @Column(name = "destacado", nullable = false)
    private Integer destacado;

    @Column(name = "imagen", nullable = false, length = 250)
    private String imagen;

    @Column(name = "detalles", columnDefinition = "text")
    private String detalles;

    @ManyToOne 
    @JoinColumn (name = "idCategoria")
    private Categoria categoria;

}
