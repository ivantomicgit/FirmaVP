package com.firmavp.controller.employee;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.firmavp.dto.StaffDTO;

import com.firmavp.dto.UserDTO;

import com.firmavp.entity.Role;
import com.firmavp.entity.Staff;
import com.firmavp.enums.PictureCategory;
import com.firmavp.fasada.StaffFacade;
import com.firmavp.service.PicturesService;
import com.firmavp.service.StaffService;

@RestController
@RequestMapping("/api/staff")
public class StaffControler {
	
	private final StaffService staffService;
	private final StaffFacade staffFacade;
	private PicturesService picturesService;
	
	@Autowired
	public StaffControler(StaffService staffService,StaffFacade staffFacade, PicturesService picturesService) {
		super();
		this.staffService =staffService;
		this.staffFacade=staffFacade;
		this.picturesService = picturesService;

	}

	@PostMapping("/create/{idCompany}/{idWorkplace}/{idPlace}")

	public ResponseEntity<StaffDTO> createStaff(@PathVariable Integer idCompany, @PathVariable Integer idWorkplace,
			@PathVariable Integer idPlace, @RequestBody StaffDTO staffDTO) {
		staffDTO = staffFacade.save(staffDTO, idCompany, idWorkplace, idPlace);

		return new ResponseEntity<StaffDTO>(staffDTO, HttpStatus.OK);

	}




	
	
	@RequestMapping(value = "/insertPictureForEmployee", method = RequestMethod.POST,  consumes = { "multipart/form-data" })
	public ResponseEntity<String> insertPictureForEmployee(@RequestParam Integer staff_id, @RequestParam("files") MultipartFile [] files) throws IllegalStateException, IOException{
		
		picturesService.save(PictureCategory.STAFF, staff_id, files);
		
		
		return new ResponseEntity<String>("Pictures added.", HttpStatus.OK);
	}
	


	@GetMapping("/listOfPictures/staff/{staff_id}")
	public ResponseEntity<List<String>> findAllPicturesForProduct(@PathVariable Integer staff_id) {
		List<String> list = picturesService.findPicturesForEntity(PictureCategory.STAFF, staff_id);
		
		return new ResponseEntity<List<String>>(list, HttpStatus.OK);

	}
	
	@PostMapping("/register")
	public ResponseEntity<String> createNewUser(@RequestBody UserDTO userDTO){
		staffService.saveUser(userDTO);
		return new ResponseEntity<String>("User is added.", HttpStatus.OK);
	}

	

	      @DeleteMapping("/delete/{id}")
	     public ResponseEntity<?>deleteStaff(@PathVariable Integer id) {
			staffService.delete(id);
			return new ResponseEntity<String>("staff sa "+id+ "is deleted",HttpStatus.OK);
		}

	      @PutMapping("/update/{id}")
	 	 public ResponseEntity<Staff>updateStaff(@PathVariable Integer id,@RequestBody Staff staff)  {
	 		return new ResponseEntity<Staff>(staffService.update(id,staff),HttpStatus.OK);
       
	 	}
	      @GetMapping("/hierarchyStaff/{id}")
		 	public ResponseEntity<List<StaffDTO>>returnStaffHierarchy(@PathVariable Integer id){
	    	  return new ResponseEntity<List<StaffDTO>>(staffService.returnAllStaff(id), HttpStatus.OK);
		 		
	      }
	        @PostMapping("/createRole/{idStaff}")
		  	public ResponseEntity<?>createStaffRole(@PathVariable Integer idStaff,@RequestBody Set<Role>roles){
	    	 StaffDTO staffDTO =  staffService.save(idStaff,roles);	
		  		return new ResponseEntity<StaffDTO>(staffDTO,HttpStatus.OK);




	        }


}

	      
	     



	      	

