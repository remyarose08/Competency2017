package com.shiftservices.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.shiftservices.datatype.Grade;
import com.shiftservices.datatype.ShiftType;
import com.shiftservices.datatype.TechnologyType;
import com.shiftservices.datatype.TimePeriod;
import com.shiftservices.dto.Comp2017DTO;
import com.shiftservices.dto.ShiftEntryDTO;
import com.shiftservices.entity.Skill;
import com.shiftservices.service.ShiftDataService;
import com.shiftservices.service.impl.ShiftDataServiceImpl;
import com.shiftservices.util.Constants;
import com.shiftservices.util.SysLogger;

@Path("/json/shiftdata")
public class ShiftDataJSONService {

	private ShiftDataService shiftDataService = new ShiftDataServiceImpl();
	
	
	@GET
    @Path("/fetchShiftDataForAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getShiftDataForAllInJSON(
            @QueryParam("timePeriod") String timePeriod) {
        List<ShiftEntryDTO> dtos = shiftDataService.fetchShiftDataForAll();
        GenericEntity<List<ShiftEntryDTO>> genericEntity = new GenericEntity<List<ShiftEntryDTO>>(dtos) {};
        return Response.ok(genericEntity).build();
    }
	
	@GET
    @Path("/fetchBulkData")
    @Produces(MediaType.APPLICATION_JSON)
    public Response fetchBulkData() {
        List<Comp2017DTO> dtos = shiftDataService.fetchBulkData();
        
        GenericEntity<List<Comp2017DTO>> genericEntity = new GenericEntity<List<Comp2017DTO>>(dtos) {};
        return Response.ok(genericEntity).build();
    }
	
	
	   @GET
	    @Path("/fetchBulkData2")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response fetchBulkData2() {
	        List<Comp2017DTO> dtos = shiftDataService.fetchBulkData();
	        
	        GenericEntity<List<Comp2017DTO>> genericEntity = new GenericEntity<List<Comp2017DTO>>(dtos) {};
	        return Response.ok(genericEntity).build();
	    }
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

/*	@GET
	@Path("/fetchAllShifts")
	@Produces(MediaType.APPLICATION_JSON)
	public String getShiftDataInJSON() {
		return shiftDataService.fetchAllShiftTypes();

	}

	@GET
	@Path("/fetchAllGrades")
	@Produces(MediaType.APPLICATION_JSON)
	public Grade[] getGradeInJSON() {
		return shiftDataService.fetchAllGrade();
	}
	
   @GET
    @Path("/fetchAllTechnologyType")
    @Produces(MediaType.APPLICATION_JSON)
    public TechnologyType[] getTechnologyTypeJSON() {
        return shiftDataService.fetchAllTechnologyType();
    }

	@GET
	@Path("/fetchAllTimePeriods")
	@Produces(MediaType.APPLICATION_JSON)
	public TimePeriod[] getTimePeriodInJSON() {
		return shiftDataService.fetchAllTimePeriods();

	}

	@POST
	@Path("/addSkill")
	@Consumes("application/x-www-form-urlencoded")
	public Response submitData(@FormParam("employeeId") String employeeId,
			@FormParam("employeeName") String employeeName,
			@FormParam("grade") String grade,
			@FormParam("qdb") String qdb,
			@FormParam("skill") String skill) {
		
		SysLogger.logMethod("RESFUL Method SubmitData:employeeId", employeeId);
		SysLogger.logMethod("RESFUL Method SubmitData:employeeName", employeeName);
		SysLogger.logMethod("RESFUL Method SubmitData:grade", grade);
		SysLogger.logMethod("RESFUL Method SubmitData:shiftType", shiftType);
		SysLogger.logMethod("RESFUL Method SubmitData:timePeriod", timePeriod);
		SysLogger.logMethod("RESFUL Method SubmitData:noOfShiftDays", String.valueOf(noOfShiftDays));
		SysLogger.logMethod("RESFUL Method SubmitData:noOfOnCallWeekdays", String.valueOf(noOfOnCallWeekdays));
		SysLogger.logMethod("RESFUL Method SubmitData:noOfOnCallWeekends", String.valueOf(noOfOnCallWeekends));
		
		SysLogger.logMethod("RESFUL Method SubmitData", "All values read. employeeId is : " +employeeId+ " employeeName is :" +employeeName+ " grade is :" +grade+ " shiftType is :" +shiftType+ " timePeriod is :" +timePeriod+ " noOfShiftDays is :" +noOfShiftDays+ " noOfOnCallWeekdays is :" +noOfOnCallWeekdays+ " noOfOnCallWeekends is :" +noOfOnCallWeekends);
		
		boolean successfull = shiftDataService.submitShiftData(new ShiftEntryDTO(employeeId, employeeName, Grade.valueOf(grade), ShiftType.valueOf(shiftType), TimePeriod.valueOf(timePeriod), noOfShiftDays, noOfOnCallWeekdays, noOfOnCallWeekends));
		
	if (successfull){
		return Response.status(200).entity("Shift data inserted successfully.").build();
		
	} else {
		return Response.status(403).entity("Failure !!! Shift data could not be inserted").build();
	}
		
		String errorMsg = "The value for employeeId="+employeeId+ " and Time Period="+timePeriod +" already exists!!";
		
	    return Response.status(200).entity("Insert Ok").build();

	}
	
	@GET
	@Path("/fetchShiftDataForTimePeriod")
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getShiftDataForTimePeriodInJSON(
			@QueryParam("timePeriod") String timePeriod) {
		List<ShiftEntryDTO> dtos = shiftDataService.fetchShiftDataForTimePeriod(TimePeriod.valueOf(timePeriod));
		GenericEntity<List<ShiftEntryDTO>> genericEntity = new GenericEntity<List<ShiftEntryDTO>>(dtos) {};
		return Response.ok(genericEntity).build();
	}
	
	
	
	@GET
	@Path("/export2excel")
	@Produces("application/vnd.ms-excel")
	public Response getFile() {
		ResponseBuilder response = Response.ok((Object) shiftDataService.exportShiftData2Excel());
		response.header("Content-Disposition","attachment; filename="+Constants.EXCEL_FILE_NAME);
		return response.build();

	}
	
	
	// http://localhost:8080/shiftservices/rest/json/shiftdata/fetchShiftDataForAll
	

	
	*/

