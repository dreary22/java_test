package com.ds.test;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

import com.ds.vo.Student;


public class TestJAXB {

	@Test
	public void test01(){
		try {
			JAXBContext jaxb = JAXBContext.newInstance(Student.class);
			Marshaller mar = jaxb.createMarshaller();
			Student stu = new Student();
			stu.setName("¶­Ë§");
			stu.setAge("10");
			//mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			mar.setProperty(Marshaller.JAXB_ENCODING, "GBK");
			mar.setProperty(Marshaller.JAXB_FRAGMENT, true);
			mar.marshal(stu, System.out);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test02(){
		try {
			JAXBContext jaxb = JAXBContext.newInstance(Student.class);
			Unmarshaller unmar = jaxb.createUnmarshaller();
			Student stu = (Student)unmar.unmarshal(new StringReader("<student><age>10</age><name>¶­Ë§</name></student>"));
			System.out.println(stu.getName());
			System.out.println(stu.getAge());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
