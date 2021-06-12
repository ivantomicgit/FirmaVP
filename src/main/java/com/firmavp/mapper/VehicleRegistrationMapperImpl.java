package com.firmavp.mapper;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.firmavp.dto.VehicleRegistrationDTO;
import com.firmavp.entity.VehicleRegistration;

@Component
public class VehicleRegistrationMapperImpl implements VehicleRegistrationMapper {



	@Override
	public VehicleRegistration toVehicleRegistration(VehicleRegistrationDTO vehicleRegistrationDTO) {
		VehicleRegistration vehicleRegistration = new VehicleRegistration();
		vehicleRegistration.setId(vehicleRegistrationDTO.getId());
		vehicleRegistration.setVehicleRegistrationNumber(vehicleRegistrationDTO.getVehicleRegistrationNumber());
		vehicleRegistration.setOwnersName(vehicleRegistrationDTO.getOwnersName());
		vehicleRegistration.setVehicleModel(vehicleRegistrationDTO.getVehicleModel());
		vehicleRegistration.setVehicleBodyType(vehicleRegistrationDTO.getVehicleBodyType());
		vehicleRegistration.setDateOfManufacture(vehicleRegistrationDTO.getDateOfManufacture());
		vehicleRegistration.setFuelUsed(vehicleRegistrationDTO.getFuelUsed());
		vehicleRegistration.setEngineNumber(vehicleRegistrationDTO.getEngineNumber());
		vehicleRegistration.setChassisNumber(vehicleRegistrationDTO.getChassisNumber());
		vehicleRegistration.setCubicCapacity(vehicleRegistrationDTO.getCubicCapacity());
		vehicleRegistration.setSeatingCapacity(vehicleRegistrationDTO.getSeatingCapacity());
		vehicleRegistration.setVehicleColor(vehicleRegistrationDTO.getVehicleColor());
		vehicleRegistration.setUnladenWeight(vehicleRegistrationDTO.getUnladenWeight());
		vehicleRegistration.setDateOfRegistration(vehicleRegistrationDTO.getDateOfRegistration());
		vehicleRegistration.setDateOfRegistrationExpiry(vehicleRegistrationDTO.getDateOfRegistrationExpiry());
		vehicleRegistration.setOwnersSignature(vehicleRegistrationDTO.getOwnersSignature());

		return vehicleRegistration;
	}

	@Override
	public VehicleRegistrationDTO toVehicleregistrationDTO(VehicleRegistration vehicleRegistration) {
		VehicleRegistrationDTO vehicleRegistrationDTO = new VehicleRegistrationDTO();
		vehicleRegistrationDTO.setId(vehicleRegistration.getId());
		vehicleRegistrationDTO.setVehicleRegistrationNumber(vehicleRegistration.getVehicleRegistrationNumber());
		vehicleRegistrationDTO.setOwnersName(vehicleRegistration.getOwnersName());
		vehicleRegistrationDTO.setVehicleModel(vehicleRegistration.getVehicleModel());
		vehicleRegistrationDTO.setVehicleBodyType(vehicleRegistration.getVehicleBodyType());
		vehicleRegistrationDTO.setDateOfManufacture(vehicleRegistration.getDateOfManufacture());
		vehicleRegistrationDTO.setFuelUsed(vehicleRegistration.getFuelUsed());
		vehicleRegistrationDTO.setEngineNumber(vehicleRegistration.getEngineNumber());
		vehicleRegistrationDTO.setChassisNumber(vehicleRegistration.getChassisNumber());
		vehicleRegistrationDTO.setCubicCapacity(vehicleRegistration.getCubicCapacity());
		vehicleRegistrationDTO.setSeatingCapacity(vehicleRegistration.getSeatingCapacity());
		vehicleRegistrationDTO.setVehicleColor(vehicleRegistration.getVehicleColor());
		vehicleRegistrationDTO.setUnladenWeight(vehicleRegistration.getUnladenWeight());
		vehicleRegistrationDTO.setDateOfRegistration(vehicleRegistration.getDateOfRegistration());
		vehicleRegistrationDTO.setDateOfRegistrationExpiry(vehicleRegistration.getDateOfRegistrationExpiry());
		vehicleRegistrationDTO.setOwnersSignature(vehicleRegistration.getOwnersSignature());

		return vehicleRegistrationDTO;
	}

	@Override
	public List<VehicleRegistration> toListVehicleRegistrations(
			List<VehicleRegistrationDTO> lsitVehicleRegistrationsDTO) {
		List<VehicleRegistration> vrList = new ArrayList<VehicleRegistration>();
		for (VehicleRegistrationDTO vehicleRegistrationDTO : lsitVehicleRegistrationsDTO) {
			VehicleRegistration vehicleRegistration = new VehicleRegistration();
			vehicleRegistration.setId(vehicleRegistrationDTO.getId());
			vehicleRegistration.setVehicleRegistrationNumber(vehicleRegistrationDTO.getVehicleRegistrationNumber());
			vehicleRegistration.setOwnersName(vehicleRegistrationDTO.getOwnersName());
			vehicleRegistration.setVehicleModel(vehicleRegistrationDTO.getVehicleModel());
			vehicleRegistration.setVehicleBodyType(vehicleRegistrationDTO.getVehicleBodyType());
			vehicleRegistration.setDateOfManufacture(vehicleRegistrationDTO.getDateOfManufacture());
			vehicleRegistration.setFuelUsed(vehicleRegistrationDTO.getFuelUsed());
			vehicleRegistration.setEngineNumber(vehicleRegistrationDTO.getEngineNumber());
			vehicleRegistration.setChassisNumber(vehicleRegistrationDTO.getChassisNumber());
			vehicleRegistration.setCubicCapacity(vehicleRegistrationDTO.getCubicCapacity());
			vehicleRegistration.setSeatingCapacity(vehicleRegistrationDTO.getSeatingCapacity());
			vehicleRegistration.setVehicleColor(vehicleRegistrationDTO.getVehicleColor());
			vehicleRegistration.setUnladenWeight(vehicleRegistrationDTO.getUnladenWeight());
			vehicleRegistration.setDateOfRegistration(vehicleRegistrationDTO.getDateOfRegistration());
			vehicleRegistration.setDateOfRegistrationExpiry(vehicleRegistrationDTO.getDateOfRegistrationExpiry());
			vehicleRegistration.setOwnersSignature(vehicleRegistrationDTO.getOwnersSignature());

			vrList.add(vehicleRegistration);
		}
		return vrList;
	}

	@Override
	public List<VehicleRegistrationDTO> toListVehicleRegistrationsDTO(
			List<VehicleRegistration> lsitVehicleRegistrations) {
		List<VehicleRegistrationDTO> vrDTOList = new ArrayList<VehicleRegistrationDTO>();
		for (VehicleRegistration vehicleRegistration : lsitVehicleRegistrations) {
			VehicleRegistrationDTO vehicleRegistrationDTO = new VehicleRegistrationDTO();
			vehicleRegistrationDTO.setId(vehicleRegistration.getId());
			vehicleRegistrationDTO.setVehicleRegistrationNumber(vehicleRegistration.getVehicleRegistrationNumber());
			vehicleRegistrationDTO.setOwnersName(vehicleRegistration.getOwnersName());
			vehicleRegistrationDTO.setVehicleModel(vehicleRegistration.getVehicleModel());
			vehicleRegistrationDTO.setVehicleBodyType(vehicleRegistration.getVehicleBodyType());
			vehicleRegistrationDTO.setDateOfManufacture(vehicleRegistration.getDateOfManufacture());
			vehicleRegistrationDTO.setFuelUsed(vehicleRegistration.getFuelUsed());
			vehicleRegistrationDTO.setEngineNumber(vehicleRegistration.getEngineNumber());
			vehicleRegistrationDTO.setChassisNumber(vehicleRegistration.getChassisNumber());
			vehicleRegistrationDTO.setCubicCapacity(vehicleRegistration.getCubicCapacity());
			vehicleRegistrationDTO.setSeatingCapacity(vehicleRegistration.getSeatingCapacity());
			vehicleRegistrationDTO.setVehicleColor(vehicleRegistration.getVehicleColor());
			vehicleRegistrationDTO.setUnladenWeight(vehicleRegistration.getUnladenWeight());
			vehicleRegistrationDTO.setDateOfRegistration(vehicleRegistration.getDateOfRegistration());
			vehicleRegistrationDTO.setDateOfRegistrationExpiry(vehicleRegistration.getDateOfRegistrationExpiry());
			vehicleRegistrationDTO.setOwnersSignature(vehicleRegistration.getOwnersSignature());
			
			vrDTOList.add(vehicleRegistrationDTO);
		}
		return vrDTOList;
	}

}
