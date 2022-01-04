public class Property {
    //   שדות
    private User user;
    private Address address;
    private int roomsNumber;
    private int cost;
    private String kind;
    private boolean forRent;
    private int houseNumber;
    private int floorNumber;
    private String advertiserName;

    //   בנאי
    public Property(User user, Address address, int roomsNumber, int cost, String kind, boolean forRent, int houseNumber, int floorNumber) {
        this.user = user;
        this.address = address;
        this.roomsNumber = roomsNumber;
        this.cost = cost;
        this.kind = kind;
        this.forRent = forRent;
        this.houseNumber = houseNumber;
        this.floorNumber = floorNumber;
        this.advertiserName = user.getUsername();
    }

    //    get || set
    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getRoomsNumber() {
        return this.roomsNumber;
    }

    public void setRoomsNumber(int roomsNumber) {
        this.roomsNumber = roomsNumber;
    }

    public int getCost() {
        return this.cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getKind() {
        return this.kind;
    }

    public void setKind(int kindCode) {
        if (kindCode == 1) {
            this.kind = "ordinary apartment";
        } else if (kindCode == 2) {
            this.kind = "penthouse apartment";
        } else if (kindCode == 3) {
            this.kind = "private apartment";
        }
    }

    public void setForRent(int forRentCode) {
        if (forRentCode == 1) {
            this.forRent = true;
        } else {
            this.forRent = false;
        }
    }

    public String getForRent() {
        String propertyStatus = "";
        if (forRent) {
            propertyStatus = "for rent";
        } else {
            propertyStatus = "for sale";
        }
        return propertyStatus;
    }

    public int getFloorNumber() {
        return this.floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getAdvertiserName() {
        return this.advertiserName;
    }


    public User getUser() {
        return this.user;
    }


    //     toString
    public String toString(Property property) {
        String output = "kind of property: " + kind + "\n" +
                "property status:" + getForRent() + "\n" + "rooms number: " + roomsNumber;
        if (getKind().equals("ordinary apartment") || getKind().equals("penthouse apartment")) {
            output = output + ("\n" + "floor number: " + floorNumber);
        }
        output = output + ("\n" + "cost: " + cost + "\n" + "advertiser name:  " + advertiserName + "\n" +  "contact phone: " + user.getPhoneNumber());
        if (user.getItIsRegularAccount()) {
            output = output + "\n" + "Regular seller";
        } else {
            output = output + "\n" + "Real estate broker";
        }
        return output;
    }
}
