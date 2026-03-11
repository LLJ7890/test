public class ERyder {
   private String bikeId;
   private int batterer;
   private boolean isAvailable;
   private double kmDriven;
   private String company_Name="hello eRyder";
   private double base_Fare=1.0;
   private double per_Minute_Fare=0.5;
   private final String linked_Account;
   private final String linked_PhoneNumber;
   private double total_Fare;
   private int totalUsageINMinutes;
   public ERyder(int batterylevel, String bikeId, boolean isAvailable, double kmDriven) {
      this.batterer = batterylevel;
      this.bikeId = bikeId;
      this.isAvailable = isAvailable;
      this.kmDriven = kmDriven;
      this.linked_Account = String.valueOf((int)(Math.random()*100000));
      this.linked_PhoneNumber = "666"+ (int) (Math.random() * 10000000);
   }

   public ERyder(int batterylevel, String bikeId, boolean isAvailable, double kmDriven,String linked_Account, String linked_PhoneNumber) {
      this.batterer = batterylevel;
      this.linked_Account = linked_Account;
      this.linked_PhoneNumber = linked_PhoneNumber;
      this.bikeId = bikeId;
      this.kmDriven = kmDriven;
      this.isAvailable = isAvailable;
   }

   public int getBatterylevel() {
      return batterer;
   }

   public void setBatterylevel(int batterylevel) {
      if(batterylevel < 0||batterylevel > 100){
         System.out.println("Baterylevel must be between 0 and 100");
         return;
      }
      this.batterer = batterylevel;
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
   public void ride(){
      if(isAvailable&& batterer >0&& batterer <100){
         System.out.println("ID:"+bikeId+" this bike is available");
      }else{
         System.out.println("ID:"+bikeId+" this bike is not available");
      }
   }
   public void printBikeDetails(){
      System.out.println("ID:"+bikeId+"\nbatterer:"+ batterer +"\nisavailable:"+isAvailable+"\nkmDriven:"+kmDriven+"km"+"\ncompany:"+company_Name);
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