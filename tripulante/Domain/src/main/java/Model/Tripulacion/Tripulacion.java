package Model.Tripulacion;

import Event.TripulacionChange;
import Event.TripulacionRegistrado;
import Model.Tripulante.Tripulante;
import core.AggregateRoot;
import core.BussinessRuleValidateExeption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Tripulacion extends AggregateRoot<UUID> {

	private String Descripcion;
	private Integer Estado;
	private LocalDateTime FechaOn;
	public List<Tripulante> Tripulantes;

	public Tripulacion() {}

	public Tripulacion(String descripcion) {

		key = UUID.randomUUID();

		this.Descripcion = descripcion;
		this.Estado = 1;
		this.FechaOn = LocalDateTime.now();
		this.Tripulantes = new ArrayList<Tripulante>();
	}

	public void eventCreado() {
		addDomainEvent(
			new TripulacionRegistrado(key, Descripcion, this.Tripulantes)
		);
	}

	public void eventChange() {
		addDomainEvent(
			new TripulacionChange(key, Descripcion, this.Tripulantes)
		);
	}

	public void agregarTripulante(Tripulante tripulante) throws Exception {

		Tripulantes
			.parallelStream()
			.filter(p -> p.key == tripulante.key)
			.findFirst()
			.ifPresent(p -> {
				throw new RuntimeException("El tripulante ya existe");
			});
		this.Tripulantes.add(tripulante);
		eventChange();
	}

	public void eliminarTripulante(UUID key) throws Exception {

		Tripulantes
			.parallelStream()
			.filter(p -> p.key == key)
			.findFirst()
			.ifPresent(p -> {
				throw new RuntimeException("El tripulante ya existe");
			});

		this.Tripulantes.removeIf(t -> t.key.equals(key));
		eventChange();
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.Descripcion = descripcion;
	}

	public Integer getEstado() {
		return Estado;
	}

	public void setEstado(Integer estado) {
		this.Estado = estado;
	}

	public LocalDateTime getFechaOn() {
		return this.FechaOn;
	}

	public void setFechaOn(LocalDateTime fechaOn) {
		this.FechaOn = fechaOn;
	}

	public List<Tripulante> getTripulantes() {
		return this.Tripulantes;
	}

	public void setTripulantes(List<Tripulante> tripulantes) {
		this.Tripulantes = tripulantes;
	}


}
