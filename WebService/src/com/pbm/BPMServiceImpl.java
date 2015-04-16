package com.pbm;

import java.io.StringWriter;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

@WebService(endpointInterface="com.pbm.IBPMService")
public class BPMServiceImpl implements IBPMService {

//	@Override
//	@WebResult(name = "SysBusinessRel")
//	public List<BusinessSysRel> getSysBusinessRel(
//			@WebParam(name = "orgId") String orgId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	@WebResult(name = "BusinessSystems")
	public String getBusinessSys(
			@WebParam(name = "orgId") String orgId) {
		//BusinessSystems bss = new BusinessSystems();
		//List<BusinessSystem> list = new ArrayList<BusinessSystem>();
		int i = 0;
		//for(int i = 0;i < 3;i++){
			BusinessSystem bs = new BusinessSystem();
			bs.setId("01_"+i);
			bs.setCode("aa01_"+i);
			bs.setName("获取aa_"+i);
			bs.setDescription("描述aa_"+i);
			bs.setRemark1("");
			bs.setRemark2("");
			//list.add(bs);
		//}
		JAXBContext jaxb;
		StringWriter sw = new StringWriter();
		try {
			jaxb = JAXBContext.newInstance(BusinessSystem.class);
			Marshaller mar = jaxb.createMarshaller();
			mar.setProperty(Marshaller.JAXB_FRAGMENT, true);
			
			mar.marshal(bs, sw);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//bss.setBusinessSystems(list);
		
		return "<aa>11</aa>";	
	}
	
	public static void main(String[] args) {
		int i = 0;
		//for(int i = 0;i < 3;i++){
			BusinessSystem bs = new BusinessSystem();
			bs.setId("01_"+i);
			bs.setCode("aa01_"+i);
			bs.setName("获取aa_"+i);
			bs.setDescription("描述aa_"+i);
			bs.setRemark1("");
			bs.setRemark2("");
			//list.add(bs);
		//}
		JAXBContext jaxb;
		try {
			jaxb = JAXBContext.newInstance(BusinessSystem.class);
			Marshaller mar = jaxb.createMarshaller();
			mar.setProperty(Marshaller.JAXB_FRAGMENT, true);
			mar.marshal(bs, System.out);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
