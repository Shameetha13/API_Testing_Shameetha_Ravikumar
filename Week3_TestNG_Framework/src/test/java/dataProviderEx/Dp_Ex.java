package dataProviderEx;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dp_Ex {
	@Test(dataProvider="dataProvider_BookingTicket",dataProviderClass = DataBank.class)
	public void BookingTest(String src, String dst) {
		System.out.println("Booking Ticket from "+src+" to "+dst);
	}
	
}
class DataBank{
@DataProvider
public static Object[][] dataProvider_BookingTicket(){
	Object[][] objArr = new Object[5][2];
	objArr[0][0]="TN";
	objArr[0][1]="MP";
	objArr[1][0]="UP";
	objArr[1][1]="KERALA";
	objArr[2][0]="KARNATAKA";
	objArr[2][1]="DELHI";
	objArr[3][0]="GOA";
	objArr[3][1]="PONDICHERRY";
	objArr[4][0]="GUJARAT";
	objArr[4][1]="TELANGANA";
	return objArr;
}
}

//package dataProviderEx;
//
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//public class Dp_Ex {
//@DataProvider
//public Object[][] dataProvider_BookingTicket(){
//	Object[][] objArr = new Object[5][2];
//	objArr[0][0]="TN";
//	objArr[0][1]="MP";
//	objArr[1][0]="UP";
//	objArr[1][1]="KERALA";
//	objArr[2][0]="KARNATAKA";
//	objArr[2][1]="DELHI";
//	objArr[3][0]="GOA";
//	objArr[3][1]="PONDICHERRY";
//	objArr[4][0]="GUJARAT";
//	objArr[4][1]="TELANGANA";
//	return objArr;
//}
//@Test(dataProvider="dataProvider_BookingTicket")
//public void BookingTest(String src, String dst) {
//	System.out.println("Booking Ticket from "+src+" to "+dst);
//}
//}