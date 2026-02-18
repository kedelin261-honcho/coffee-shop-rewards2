public class Customer {
    private String name;
    private String phoneNumber;
    private int points;


    public Customer() {
        this.name = "";
        this.phoneNumber = "";
        this.points = 0;
    }


    public Customer(String name, String phoneNumber, int points) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.points = points;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPoints() {
        return points;

    }

    public void setPoints(int points) {
        if (points < 0) points = 0;

        this.points = points;
    }


    public void addPoints(int amount) {
        if (amount > 0) {
            this.points += amount;


        }
    }


    public String getTier() {
        if (points >= 200) return "Gold";

        if (points >= 100) return "Silver";

        return "Bronze";
    }


    public boolean redeemFreeDrink() {
        if (points >= 100) {
            points -= 100;

            return true;
        }
        return false;
    }
}
