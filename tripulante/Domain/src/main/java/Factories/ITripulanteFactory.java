package Factories;

import Model.Tripulante.Cargo;
import Model.Tripulante.Tripulante;
import java.util.UUID;

public interface ITripulanteFactory {
	public Tripulante Create(
		String nombre,
		String apellido,
		String emailAddress,
		String estado,
		String tipo,
		Double horasVuelo,
		Double nroMillas,
		UUID keyCargo
	);
}
