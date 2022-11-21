package cl.generation.web.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="autos_ventas")
public class AutosVentas {
	
	
	//tabla relacional para agregar columnas adicionales
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer cantidad;
	
	private Float valorUnitario; //cantidad*valorunitario
	
	//Relaciones ManyToMany = 2 relaciones ManyToOne
	
	//1° relacion ManyToOne
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="auto_id")
	
	private Auto auto;
	

	//2° relacion ManyToOne
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="venta_id")
	
	private Venta venta;
	
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt; //inserción de un registro
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt; //update de un registro


	public AutosVentas() {
		super();
	}


	public AutosVentas(Long id, Integer cantidad, Float valorUnitario, Auto auto, Venta venta) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.valorUnitario = valorUnitario;
		this.auto = auto;
		this.venta = venta;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}


	public Float getValorUnitario() {
		return valorUnitario;
	}


	public void setValorUnitario(Float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}


	public Auto getAuto() {
		return auto;
	}


	public void setAuto(Auto auto) {
		this.auto = auto;
	}


	public Venta getVenta() {
		return venta;
	}


	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
	

}
