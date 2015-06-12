package test;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


public class TestDriver {

    private static String projectPath = "./app/src/main/java/";
    private static String testPackage = "test.model";
    private static boolean fullTrace = false;
    private static int testsRun = 0;
    private static int testsFailed = 0;

    public static void main(String[] args)
    {

        /*
            == HERE'S HOW THIS WORKS ==
            1) Add all unit tests and test packages in the main.java.test folder
            2) Instead of the @setup annotation placed above the setup function,
                    do all the setup inside a constructor with no params
            3) Instead of the @test annotation placed above the test functions,
                    do all tests in functions with the following signature:
                        public void <testname>() throws Exception {}
                    The test should throw the abstract Exception, not only a specific
                    exception. Non-public, functions will no be run by this TestDriver
            4) Import: static org.junit.Assert.assertTrue
            5) Use assertions like: assertTrue(<expression>)
            6) When you're ready to run your tests,
                    set the testPackage global variable (which is in this class)
                    to the package that you want to test
            7) Run this function, which will run the tests
            8) The TestDriver will recursively scan the package for classes, then execute
                    all the public methods on each function.
            9) The TestDriver catches any exception thrown by a test--it will consider a test
                    passed unless an uncaught exception was thrown inside a test function.
            10) The TestDriver will make a new instance of the test class for every test
                    method within that test class, so you use the test class's constructor
                    for any pre-test setup that all methods need.
            11) The tests results will be output to the console/terminal. Failed tests
                    will print out a short error message by default, but if you wish
                    to see more result you can set fullTrace = true at the top of this class

            Enjoy!!

        */
        System.out.println("\n == BEGINNING TESTS == ");

        TestDriver driver = new TestDriver();
        driver.scanClasses(projectPath + testPackage.replace('.', '/'), testPackage);

        if(testsFailed == 0)
            System.out.println("\n ==== SUCCESS!! ==== ");
        else System.out.println("\n ==== FAILURE... ==== ");
        System.out.println("Tests Run: " + testsRun);
        System.out.println("Tests Failed: " + testsFailed);
    }

    private void scanClasses(String currentPath, String currentPackage) {

        try {

            File currentDir = new File(currentPath);
            File[] contents = currentDir.listFiles();

            for (File file : contents) {
                String newPath = currentPath + "/" + file.getName();
                String newPackage = currentPackage + "." + file.getName().replaceFirst("[.][^.]+$", "");
                if (file.isDirectory())
                    scanClasses(newPath, newPackage);
                else if (file.isFile()) {
                    if (file.getName().replaceFirst("[.][^.]+$", "").equalsIgnoreCase("TestDriver"))
                        continue;
                    executeMethods(Class.forName(newPackage));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void executeMethods(Class aClass) {
        System.out.println("\n---- " + aClass.getSimpleName().toUpperCase() + " ----");
        for (Method method : aClass.getDeclaredMethods()) {
            try {
                if(!Modifier.isPublic(method.getModifiers()))
                    continue;
                testsRun++;
                System.out.println("-- " + method.getName());
                method.invoke(aClass.newInstance());
                System.out.println("Passed");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                Throwable te = e.getTargetException();
                System.out.println(te.toString());
                if(fullTrace)
                    System.out.println(getTestTrace(
                            te.getStackTrace()));
                else {
                    System.out.println(getTestException(
                            te.getStackTrace(),
                            method.getName()));
                }
                testsFailed++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String getTestException(StackTraceElement[] stackTrace, String methodName) {

        for (StackTraceElement element : stackTrace) {
            if (element.toString().contains(methodName))
                return element.toString();
        }
        return stackTrace[0].toString();
    }

    private String getTestTrace(StackTraceElement[] stackTrace) {

        StringBuilder builder = new StringBuilder();
        for (StackTraceElement element : stackTrace) {
            if (element.toString().contains("reflect"))
                break;
            builder.insert(0, element.toString() + "\n");
        }
        String toReturn = builder.toString();
        return toReturn.substring(0, toReturn.length() - 1);
    }

}

