import java.util.Scanner;

public class RealEstate {
    Scanner scanner = new Scanner(System.in);
    // שדות
    private User[] users;
    private Property[] properties;
    private Address[] startAddress;
    public static final int MIN_PHONE_NUMBER = 10;

    // בנאי
    public RealEstate() {
        this.users = new User[0];
        this.properties = new Property[0];
        this.startAddress = new Address[10];
        Address address0 = new Address("Jerusalem","Basel");
        this.startAddress[0] = address0;
        Address address1 = new Address("Jerusalem","Jaffa");
        this.startAddress[1] = address1;
        Address address2 = new Address("Jerusalem","Hillel");
        this.startAddress[2] = address2;
        Address address3 = new Address("Yavne","Armon");
        this.startAddress[3] = address3;
        Address address4 = new Address("Yavne","Nurit");
        this.startAddress[4] = address4;
        Address address5 = new Address("Tel-Aviv","Maze");
        this.startAddress[5] = address5;
        Address address6 = new Address("Rishon-Letzion","Tommy Lapid");
        this.startAddress[6] = address6;
        Address address7 = new Address("Rishon-Letzion","Smadar");
        this.startAddress[7] = address7;
        Address address8 = new Address("Tel-Aviv","Dizengof");
        this.startAddress[8] = address8;
        Address address9 = new Address("Tel-Aviv","Gordon");
        this.startAddress[9] = address9;
    }


    //    getter | setter
    public User[] getUsers() {
        return users;
    }

    public boolean isUserNameLaegal(String username){
        boolean userNameLaegal=false;
        int counter = 0;
        for (int i = 0; i < username.length(); i++) {
            if (!Character.isDigit(username.charAt(i))) {
                counter++;
            } else {
                System.out.println("Username must contain only letters!");
                break;
            }
        }
        if (counter == username.length()) {
            userNameLaegal=true;
        }
        return userNameLaegal;
    }

    public boolean itUsernameExist(String username) {
        boolean itIsExist = false;
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUsername().equals(username)) {
                itIsExist = true;
                System.out.println("This username is already taken");
                break;
            }
        }
        return itIsExist;
    }

    public boolean itIsStrong(String password) {
        boolean itIsStrongPassword = false;
        char[] specificDigit = {'$', '%', '_'};
        boolean hasSpecificDigit = false;
        boolean hasNumber = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                hasNumber = true;
            } else {
                for (int j = 0; j < specificDigit.length; j++) {
                    if (password.charAt(i) == specificDigit[j]) {
                        hasSpecificDigit = true;
                        break;
                    }
                }
            }
        }
        if (hasNumber && hasSpecificDigit) {
            itIsStrongPassword = true;
        }
        return itIsStrongPassword;
    }

    public boolean validPhoneNumber(String phoneNumber) {
        boolean itIsValidPhoneNumber = false;
        boolean isOnlyDigit = false;
        int counter = 0;
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (Character.isDigit(phoneNumber.charAt(i))) {
                counter++;
            } else {
                break;
            }
        }
        if (counter == phoneNumber.length()) {
            isOnlyDigit = true;
        }
        if (phoneNumber.length() == MIN_PHONE_NUMBER && isOnlyDigit && phoneNumber.charAt(0) == '0' && phoneNumber.charAt(1) == '5') {
            itIsValidPhoneNumber = true;
        }
        return itIsValidPhoneNumber;
    }

    public void addUserToArray(String username, String password, String phoneNumber, boolean itIsRegularAccount) {
        User[] newArray = new User[this.users.length + 1];
        for (int i = 0; i < this.users.length; i++) {
            newArray[i] = this.users[i];
        }
        User newUser = new User(username, password, phoneNumber, itIsRegularAccount);
        newArray[users.length] = newUser;
        this.users = newArray;
    }


    public void addUser() {
        String username = null;
        do {
            do {
                System.out.println("enter your username: ");
                username = new Scanner(System.in).nextLine();
            } while (!isUserNameLaegal(username));
        } while (itUsernameExist(username));
        String password = null;
        do {
            System.out.println("enter your password: ");
            password = new Scanner(System.in).nextLine();
        } while (!itIsStrong(password));
        String phoneNumber = null;
        do {
            System.out.println("enter your phone number: ");
            phoneNumber = new Scanner(System.in).nextLine();
        } while (!validPhoneNumber(phoneNumber));
        boolean itIsRegularAccount = false;
        int a = 0;
        do {
            System.out.println("enter your user code." + "\n" + "if you are a regular user enter:1" + "\n" + "if you are a broker enter:2");
            a = scanner.nextInt();
            if (a == 1) {
                itIsRegularAccount = true;
            }
        } while (a != 1 && a != 2);

        addUserToArray(username, password, phoneNumber, itIsRegularAccount);
        System.out.println("New user successfully entered!");
    }

    public User userLogin() {
        System.out.println("To connect to an existing account:\n" +
                "Enter username: ");
        String username = new Scanner(System.in).nextLine();
        System.out.println("Enter password: ");
        String password = new Scanner(System.in).nextLine();
        User userDetails = null;
        for (int i = 0; i < this.users.length; i++) {
            if (username.equals(users[i].getUsername()) && password.equals(users[i].getPassword())) {
                userDetails = users[i];
                break;
            }
        }
        return userDetails;
    }

    public String startAddressCity(Address address){
        return address.getCityName();
    }

public String startAddressCityFromArray(){  // מתודה שמדפיסה את כל שמות הערים מהמערך address ללא כפילויות
        StringBuilder output=new StringBuilder();
        output.append(startAddress);
    System.out.println("choose one city from the list:");
        for (int i=0;i<startAddress.length;i++) {
            int counter=0;
            for (int j = i + 1; j < startAddress.length; j++) {
                if (startAddress[i].getCityName().equals(startAddress[j].getCityName())) {
                    counter++;
                    break;
                }
            }
            if (counter ==0) {
                output.append("\n").append(startAddressCity(startAddress[i])).append("\n");
            }
        }
    System.out.println(output);
       return output.toString();
}
public String getStreetName(Address address){
        return address.getStreetName();
}

public String streetsNameFromArray(String cityName){  //   המתודה לא מדפיסה!!
        int counterCityInArray=0;
        for (int i=0;i<startAddress.length;i++){
            if (startAddress[i].getCityName().equals(cityName)){
                counterCityInArray++;
            }
        }
    StringBuilder streets=new StringBuilder();
    streets.append(startAddress);
        for (int i=0;i<startAddress.length;i++) {
            if (startAddress[i].getCityName().equals(cityName)) {
                streets.append("\n").append(getStreetName(startAddress[i])).append("\n");
            }
        }
        return streets.toString();
}



    //  מתודות הקשורות בproperty
    public void addProperty(User user,Address address,int roomsNumber,int cost,String kind,boolean forRent,int houseNumber,int floorNumber) {
            Property [] newArray = new Property[this.properties.length + 1];
            for (int i = 0; i < this.properties.length; i++) {
                newArray[i] = this.properties[i];
            }
            Property newProperty = new Property(user,address, roomsNumber, cost, kind,forRent, houseNumber, floorNumber);
            newArray[properties.length] = newProperty;
            this.properties = newArray;
        }




//       מתודה ל2 בתפריט הראשי
    public boolean postNewProperty(User user) {
        Property newProperty;
        String advertiserName=user.getUsername();
        String kindOfProperty=null;
        boolean propertyForRent;
        int cost;
        int roomsNumber;
        int propertyStreetNumber;
        int floor=0;


        boolean canPostNewProperty = true;
        int maximumNumberOfGuesses = 0;
        int counter = 0;
        if (user.getItIsRegularAccount()) {
            maximumNumberOfGuesses = 3;
        } else {
            maximumNumberOfGuesses = 10;
        }
        for (int i = 0; i < properties.length; i++) {
            if (properties[i].getAdvertiserName().equals(user.getUsername())) {
                counter++;
            }
        }
        if (counter >= maximumNumberOfGuesses) {
            System.out.println("You have posted the maximum number of posts your account can post.");
            return false;
        } else {
            Address address=new Address(null,null);
            startAddressCityFromArray();
            System.out.println("wort your city choose here: ");
            String cityNameChoose = new Scanner(System.in).nextLine();
            String leagalCityChoose =null;
            for (int i = 0; i < this.startAddress.length; i++) {
                if (cityNameChoose.equals(startAddressCity(startAddress[i]))){
                    leagalCityChoose=cityNameChoose;
                    address.setCityName(cityNameChoose);
                    break;
                }
            }
            if (leagalCityChoose==(null)){
                System.out.println("Your selection does not match the options from the list.");
                return false;
            }
            else {
                System.out.println(streetsNameFromArray(leagalCityChoose));  //  הדפסת כל הרחובות של העיר.. המשך בחירה של המשתמש וכו והזנה למערך כתובות גדל דינמית לפי ההוראות
                System.out.println("choose one street form the list: ");
                String streetNameChoose=new Scanner(System.in).nextLine();
                String leagalStreetChoose=null;
                for (int i = 0; i < this.startAddress.length; i++) {
                    if (streetNameChoose.equals(getStreetName(startAddress[i]))){
                        leagalStreetChoose=streetNameChoose;
                        address.setStreetName(streetNameChoose);
                        break;
                    }
                }
                if (leagalStreetChoose==(null)){
                    System.out.println("Your selection does not match the options from the list.");
                    return false;
                }
                else {
                    int kindOfApartment;
                    do {
                        System.out.println("choose a kind of apartment: " + "\n" + "for a ordinary apartment,press: 1" + "\n" + "for a penthouse apartment, press: 2" + "\n" + "for a private apartment, press: 3");
                        kindOfApartment = scanner.nextInt();
                    } while (kindOfApartment<1 || kindOfApartment>3);
                    if (kindOfApartment==1){
                        kindOfProperty="ordinary apartment";
                        do {
                            System.out.println("enter your floor number: ");
                            floor = scanner.nextInt();
                        } while (floor<0);
                    }
                    else if (kindOfApartment==2){
                        kindOfProperty="penthouse apartment";
                        do {
                            System.out.println("enter your floor number: ");
                            floor = scanner.nextInt();
                        }while (floor<0);
                    }
                    else if (kindOfApartment==3){
                        kindOfProperty="private apartment";
                    }

                }
                do {
                    System.out.println("enter the rooms number in the property: ");
                    roomsNumber=scanner.nextInt();
                } while (roomsNumber<1);
                do {
                    System.out.println("enter the property street number: ");
                    propertyStreetNumber=scanner.nextInt();
                } while (propertyStreetNumber<1);
                int propertyForRentCode;
                do {
                    System.out.println("Is the property for rent or for sale?\n" +
                            "For rent press: 1\n" +
                            "For sale press: 2");
                    propertyForRentCode = scanner.nextInt();
                } while (propertyForRentCode<1 || propertyForRentCode>2);
                if (propertyForRentCode==1){
                    propertyForRent=true;
                }
                else {
                    propertyForRent=false;
                }
                do {
                    System.out.println("enter your cost: ");
                    cost=scanner.nextInt();
                } while (cost <=0);
            }
            addProperty(user,address,roomsNumber,cost,kindOfProperty,propertyForRent,propertyStreetNumber,floor);
        }
        System.out.println("The property was successfully added!");
        return canPostNewProperty;
    }

    public void printAllProperties(){ // מתודה שמדפיסה את כל הנכסים במערך
        for (int i=0;i<properties.length;i++){
            System.out.println(properties[i].toString(properties[i]));
            System.out.println();
        }
    }
    public void printAllUserProperties(User user){  //  מדפיסה נכסים לפי שם משתמש
       int propertyCounter=1;
        for (int i=0;i<properties.length;i++) {
            if (properties[i].getAdvertiserName().equals(user.getUsername())) {
                System.out.println("property num "+propertyCounter+":");
                System.out.println(properties[i].toString(properties[i]));
                System.out.println();
                propertyCounter++;
            }
        }
    }

   public void removeProperty(User user){  // מחיקת נכס
        int propertiesCounter=0;
       int propertyIndexToDeliate;
       for (int i=0;i<properties.length;i++) {
           if (properties[i].getAdvertiserName().equals(user.getUsername())) {
               propertiesCounter++;
           }
       }
       System.out.println("counter "+propertiesCounter);
       if (propertiesCounter==0){
           System.out.println("You can not delete a property, because no properties are published yet ..");
       }
       else {
           do {
               System.out.println("Select the number you want to delete from the following list:"+"\n");
               printAllUserProperties(user);
               propertyIndexToDeliate = scanner.nextInt();
           } while (propertyIndexToDeliate<1 || propertyIndexToDeliate>propertiesCounter);
           Property [] newArrayProperties=new Property[this.properties.length-1];
           this.properties[propertyIndexToDeliate-1]=this.properties[properties.length-1];
           this.properties[properties.length-1]=null;
           for (int i=0;i<newArrayProperties.length;i++){
               newArrayProperties[i]=this.properties[i];
           }
           this.properties=newArrayProperties;
           System.out.println("Property successfully deleted!");
       }
   }

   public  Property [] search(){
       System.out.println("Here are the parameters to filter, follow the instructions.\n" +
               "If you do not want to filter according to the parameter in front of you, press: -999");
        String kindOfProperty=null;
       int kindOfApartment;
       do {
           System.out.println("choose a kind of apartment: " + "\n" + "for a ordinary apartment,press: 1" + "\n" + "for a penthouse apartment, press: 2" + "\n" + "for a private apartment, press: 3");
           kindOfApartment = scanner.nextInt();
       } while (kindOfApartment<1 && kindOfApartment!= -999 || kindOfApartment>3 );
       if (kindOfApartment==1) {
           kindOfProperty = "ordinary apartment";
       }
       else if (kindOfApartment==2) {
           kindOfProperty = "penthouse apartment";
       }
       else if (kindOfApartment==3){
           kindOfProperty="private apartment";
       }

        String propertyForRent;
       int propertyForRentCode;
       do {
           System.out.println("Is the property for rent or for sale?\n" +
                   "For rent press: 1\n" +
                   "For sale press: 2");
           propertyForRentCode = scanner.nextInt();
       } while (propertyForRentCode<1  && propertyForRentCode!= -999 || propertyForRentCode>2);
       if (propertyForRentCode==1){
           propertyForRent="for rent";
       }
       else {
           propertyForRent="for sale";
       }

       int minCost;
       do {
           System.out.println("Enter the minimum amount to pay: ");
           minCost=scanner.nextInt();
       } while (minCost<0 && minCost!=-999);

       int maxCost;
       do {
           System.out.println("Enter the maximum amount to pay: ");
           maxCost=scanner.nextInt();
       } while (maxCost<minCost && maxCost!= -999);

       int counter=0;
       int indexToArray=0;
       int [] propertiesIndex=new int[properties.length];
   for (int i=0;i<this.properties.length;i++){
    if (this.properties[i].getForRent().equals(propertyForRent) || propertyForRentCode == -999){
        if (this.properties[i].getKind().equals(kindOfProperty) || kindOfApartment == -999){
            if (this.properties[i].getCost()>=minCost || minCost==-999){
                if (this.properties[i].getCost()<=maxCost || maxCost==-999){
                    counter++;
                    propertiesIndex[indexToArray]=i;
                    indexToArray++;
                }
            }
        }
    }
   }
   Property [] propertiesSearch = new Property [counter];
   for (int i=0;i<propertiesSearch.length;i++){
       propertiesSearch[i]=properties[propertiesIndex[i]];
   }
      //  הדפסת מערך החיפוש:
       for (int i=0;i<propertiesSearch.length;i++){
           System.out.println();
           System.out.println(propertiesSearch[i].toString(propertiesSearch[i]));
       }
       return propertiesSearch;
    }
}


