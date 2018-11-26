/**
 * 
 */
package com.metacube.tms.modal;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Yash Sharma<yash.sharma@metacube.com>
 * @since 21-Sep-2018
 */
@Data @NoArgsConstructor @AllArgsConstructor
@ApiModel(description = "Class representing a person tracked by the application.")
public class EmployeeModal extends BaseModel implements Serializable {

	    
	@ApiModelProperty(notes = "Name of the employee.", example = "Yash Sharma", required = true, position = 1)
    private String name;
	
	private Long orgId;
	
	private Long managerUid;
	
	private Long normalizerUid;
	
	private String email;
	
	// To be removed

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
		
		
	    
}
