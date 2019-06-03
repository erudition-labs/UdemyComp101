public class Banking {
    private  static int nUsers = 0;
    private User users[];
    private int loggedInUser;

    public Banking() {
        users = new User[5];
        loggedInUser = -1;
    }

    public void addUser(String name, String address, double money, String pin) {
        if(nUsers >= users.length) {
            increaseArray();
        }

        users[nUsers] = new User(name, address, money, pin);
        nUsers++;
    }

    private void increaseArray() {
        User[] tmp = new User[users.length * 2];

        for(int i=0; i<users.length; i++) {
            tmp[i] = users[i];
        }
        users = tmp;
    }

    public boolean login(String name, String pin) {
        boolean success = false;
        for(int i=0; i<users.length; i++) {
            if(users[i] != null) {
                if(users[i].name.equals(name) && users[i].pin.equals(pin)) {
                    success = true;
                    loggedInUser = i;
                }
            }
        }
        return success;
    }

    public double withdraw(double amount) {
        if(users[loggedInUser].moneyAmount < amount) {
            return -1;
        }

        users[loggedInUser].moneyAmount -= amount;
        return amount;
    }

    public void deposit(double amount) {
        users[loggedInUser].moneyAmount += amount;
    }

    public void logout() {
        loggedInUser = -1;
    }

    private class User {
        String name;
        String address;
        double moneyAmount;
        String pin;

        User(String name, String address, double moneyAmount, String pin) {
            this.name = name;
            this.address = address;
            this.moneyAmount = moneyAmount;
            this.pin = pin;
        }

        User(String name, String address, String pin) {
            this.name = name;
            this.address = address;
            moneyAmount = 0.0;
            this.pin = pin;
        }
    }
}
