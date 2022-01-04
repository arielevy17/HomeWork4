public class Address {
     //   שדות
    private String cityName;
    private String streetName;
    //   בנאי
    public Address(String cityName,String streetName){
        this.cityName=cityName;
        this.streetName=streetName;
    }
    //   get||set
    public String  getCityName(){
        return cityName;
    }
    public void setCityName(String cityName){
        this.cityName=cityName;
    }

    public String  getStreetName(){
        return streetName;
    }
    public void setStreetName(String streetName){
        this.streetName=streetName;
    }
    //    toString
  public String toString(Address address){
        String output="city name: "+this.cityName+"\n"+"street name: "+this.streetName;
        return output;
  }
}
