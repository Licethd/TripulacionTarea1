package UsesCases.Command.Cargo.Crear;

import Factories.ICargoFactory;
import Fourteam.mediator.RequestHandler;
import Model.Tripulante.Cargo;
import Repositories.ICargoRepository;
import Repositories.IUnitOfWork;
import java.util.UUID;

public class CrearCargoHandler
	implements RequestHandler<CrearCargoCommand, UUID> {

	private ICargoFactory _cargoFactory;
	private ICargoRepository _cargoRepository;
	private IUnitOfWork _unitOfWork;

	public CrearCargoHandler(
		ICargoFactory cargoFactory,
		ICargoRepository cargoRepository,
		IUnitOfWork _unitOfWork
	) {
		this._cargoFactory = cargoFactory;
		this._cargoRepository = cargoRepository;
		this._unitOfWork = _unitOfWork;
	}

	@Override
	public UUID handle(CrearCargoCommand request) throws Exception {
		Cargo cargo = _cargoFactory.Create(request.cargoDto.Descripcion);

		// cargo.eventCreado();

		_cargoRepository.Create(cargo);
		_unitOfWork.commit();
		return cargo.key;
	}
}
