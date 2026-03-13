package homework;

public class ERyder {
   private String bikeId;
   private int batteryLevel;
   private boolean isAvailable;
   private double kmDriven;
   private String company_Name="hello eRyder";
   private double base_Fare=1.0;
   private double per_Minute_Fare=0.5;
   private final String linked_Account;
   private final String linked_PhoneNumber;
   private double total_Fare;
   private int totalUsageINMinutes;

   //有构造函数
   public ERyder(int batterylevel, String bikeId, boolean isAvailable, double kmDriven) {
      this.batteryLevel = batterylevel;
      this.bikeId = bikeId;
      this.isAvailable = isAvailable;
      this.kmDriven = kmDriven;
      this.linked_Account = null;
      this.linked_PhoneNumber = null;
   }
   //空构造函数
   public ERyder() {
      this(5, "bike_1", true, 50.0);
   }

   public ERyder(int batterylevel, String bikeId, boolean isAvailable, double kmDriven,String linked_Account, String linked_PhoneNumber) {
      this.batteryLevel = batterylevel;
      this.linked_Account = linked_Account;
      this.linked_PhoneNumber = linked_PhoneNumber;
      this.bikeId = bikeId;
      this.kmDriven = kmDriven;
      this.isAvailable = isAvailable;
   }

   public ERyder(String bikeId) {
      this(80, bikeId, true, 50.0);
   }

   public int getBatterylevel() {
      return batteryLevel;
   }

   public void setBatterylevel(int batterylevel) {
      if(batterylevel < 0||batterylevel > 100){
         System.out.println("Baterylevel must be between 0 and 100");
         return;
      }
      this.batteryLevel = batterylevel;
   }

   public String getBikeId() {
      return bikeId;
   }

   public void setBikeId(String bikeId) {

      this.bikeId = bikeId;
   }

   public boolean isAvailable() {

      return isAvailable;
   }

   public void setAvailable(boolean available) {

      isAvailable = available;
   }

   public double getKmDriven() {

      return kmDriven;
   }

   public void setKmDriven(double kmDriven) {

      this.kmDriven = kmDriven;
   }
   //方法
   public void ride(){
      if(isAvailable&& batteryLevel >0&& batteryLevel<100){
         System.out.println("ID:"+bikeId+" this bike is available");
      }else{
         System.out.println("ID:"+bikeId+" this bike is not available");
      }
   }
   public void printBikeDetails(){
      System.out.println("ID:"+bikeId+"\nbatterer:"+ batteryLevel +"\nisavailable:"+isAvailable+"\nkmDriven:"+kmDriven+"km"+"\ncompany:"+company_Name);
   }
   public void printRideDetails(int usageInMinutes){
      System.out.println("account:"+linked_Account+"\nphone number:"+linked_PhoneNumber+"\nID:"+bikeId
            +"\ntotal Fare:"+calculateFare(usageInMinutes)+"￥\ntotalUsageINMinutes:"+usageInMinutes+" minutes"
      );
   }
   private double calculateFare(int usageInMinutes){

      return total_Fare=base_Fare+per_Minute_Fare*usageInMinutes;
   }
}