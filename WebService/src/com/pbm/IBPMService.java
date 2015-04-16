package com.pbm;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(serviceName="BPMData",targetNamespace="http://www.sga.com")
public interface IBPMService {

//	@WebResult(name="SysBusinessRel")
//	public List<BusinessSysRel> getSysBusinessRel(@WebParam(name="orgId")String orgId);
	
	@WebResult(name="BusinessSystems")
	public String getBusinessSys(@WebParam(name="orgId")String orgId);
	
}
