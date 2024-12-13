package practice_testNG;



public class CaptureTimeStamp {

	public static void main(String[] args) {
String time=new java.util.Date().toString().replace(" ", "_").replace(":", "_");
System.out.println(time);

	}

}
