package test.com.bugong.serializable; 

import com.bugong.serializable.AFile;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* AFile Tester. 
* 
* @author <Authors name> 

* @version 1.0 
*/ 
public class AFileTest {
    static AFile aFile ;


@Before
public void before() throws Exception {

    aFile = new AFile("aaa","bbb");
} 

@After
public void after() throws Exception {
    System.out.println(aFile.getFileSize()+"\n"+ aFile.getRealName());
    System.out.println("*****");
} 

/** 
* 
* Method: getRealName() 
* 
*/ 
@Test
public void testGetRealName() throws Exception { 
//TODO: Test goes here...

} 

/** 
* 
* Method: setRealName(String realName) 
* 
*/ 
@Test
public void testSetRealName() throws Exception { 
//TODO: Test goes here...

    aFile.setRealName("AAA");
} 

/** 
* 
* Method: getFileSize() 
* 
*/ 
@Test
public void testGetFileSize() throws Exception { 
//TODO: Test goes here...
} 

/** 
* 
* Method: setFileSize(String fileSize) 
* 
*/ 
@Test
public void testSetFileSize() throws Exception { 
//TODO: Test goes here...
    aFile.setFileSize("cc");
} 

/** 
* 
* Method: toString() 
* 
*/ 
@Test
public void testToString() throws Exception { 
//TODO: Test goes here... 
} 


} 
