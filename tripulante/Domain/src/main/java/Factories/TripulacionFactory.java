package Factories;

import Model.Tripulacion.Tripulacion;
import Model.Tripulante.Cargo;
import Model.Tripulante.Tripulante;
import java.util.List;

public class TripulacionFactory implements ITripulacionFactory {

	public TripulacionFactory() {}

	@Override

	public Tripulacion Create(String descripcion) {
		return new Tripulacion(descripcion);
	}
}
