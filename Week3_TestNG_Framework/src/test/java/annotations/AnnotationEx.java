package annotations;

import org.testng.annotations.*;

public class AnnotationEx {

 @BeforeSuite
 public void beforeSuite() {
     System.out.println("BS");
 }

 @BeforeTest
 public void beforeTest() {
     System.out.println("BT");
 }

 @AfterTest
 public void afterTest() {
     System.out.println("AT");
 }

 @AfterSuite
 public void afterSuite() {
     System.out.println("AS");
 }
}

class ClassOne {
 @BeforeClass
 public void beforeClass() {
     System.out.println("BC - Class 1");
 }

 @BeforeMethod
 public void beforeMethod() {
     System.out.println("BM");
 }

 @Test
 public void method1() {
     System.out.println("Test 1");
 }

 @Test
 public void method2() {
     System.out.println("Test 2");
 }

 @AfterMethod
 public void afterMethod() {
     System.out.println("AM");
 }

 @AfterClass
 public void afterClass() {
     System.out.println("AC - Class 1");
 }
}

class ClassTwo {
 @BeforeClass
 public void beforeClass() {
     System.out.println("BC - Class 2");
 }

 @BeforeMethod
 public void beforeMethod() {
     System.out.println("BM");
 }

 @Test
 public void method3() {
     System.out.println("Test 3");
 }

 @Test
 public void method4() {
     System.out.println("Test 4");
 }

 @AfterMethod
 public void afterMethod() {
     System.out.println("AM");
 }

 @AfterClass
 public void afterClass() {
     System.out.println("AC - Class 2");
 }
}

//package annotations;
//
//import org.testng.annotations.*;
//
//public class AnnotationEx {
//
//    @BeforeSuite
//    public void beforeSuite() { System.out.println("BS"); }
//
//    @BeforeTest
//    public void beforeTest() { System.out.println("BT"); }
//
//    @AfterTest
//    public void afterTest() { System.out.println("AT"); }
//
//    @AfterSuite
//    public void afterSuite() { System.out.println("AS"); }
//
// 
//    public static class ClassOne {
//        @BeforeClass
//        public void bc() { System.out.println("BC - 1"); }
//
//        @Test
//        public void method1() { System.out.println("Test 1"); }
//
//        @Test
//        public void method2() { System.out.println("Test 2"); }
//    }
//
//
//    public static class ClassTwo {
//        @BeforeClass
//        public void bc() { System.out.println("BC - 2"); }
//
//        @Test
//        public void method3() { System.out.println("Test 3"); }
//
//        @Test
//        public void method4() { System.out.println("Test 4"); }
//    }
//}

//import org.testng.annotations.*;
//
//public class ProjectModule {
//
//    // --- Suite and Test Level (Run once) ---
//    
//    @BeforeSuite
//    public void beforeSuite() {
//        System.out.println("BS");
//    }
//
//    @BeforeTest
//    public void beforeTest() {
//        System.out.println("BT");
//    }
//
//    // --- Class Level (Run once per class) ---
//
//    @BeforeClass
//    public void beforeClass() {
//        System.out.println("BC");
//    }
//
//    // --- Method Level (Run before/after EVERY @Test) ---
//
//    @BeforeMethod
//    public void beforeMethod() {
//        System.out.println("BM");
//    }
//
//    @Test
//    public void testMethod1() {
//        System.out.println("Test 1 Execution");
//    }
//
//    @Test
//    public void testMethod2() {
//        System.out.println("Test 2 Execution");
//    }
//
//    @AfterMethod
//    public void afterMethod() {
//        System.out.println("AM");
//    }
//
//    @AfterClass
//    public void afterClass() {
//        System.out.println("AC");
//    }
//
//    @AfterTest
//    public void afterTest() {
//        System.out.println("AT");
//    }
//
//    @AfterSuite
//    public void afterSuite() {
//        System.out.println("AS");
//    }
//}