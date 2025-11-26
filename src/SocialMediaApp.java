import java.util.Arrays;

public class SocialMediaApp {

    private Account[] accounts;

    /**
     * Build at least 3 accounts and load them into the accounts array.
     * Make up your own information about the accounts, but make each one unique.
     * Make sure each account also has some messages, and use some varying amounts of messages.
     */
    public void loadDemoAccounts() {
        // TODO: Finish this method.

        LoginInfo loginInfo1 = new LoginInfo("alicej", "password123");
        Address address1 = new Address("123 Maple St", "Springfield", StateEnum.Michigan, "62701");
        AccountDetails accountDetails1 = new AccountDetails("Alice Johnson", loginInfo1, address1);

        Message[] messages1 = {new Message(new TimeStamp(MonthEnum.January, 15, 9, 30), "Hello world!"),
                               new Message(new TimeStamp(MonthEnum.February, 20, 14, 45), "Enjoying the sunny weather."),
                               new Message(new TimeStamp(MonthEnum.March, 5, 18, 0), "Just finished a great book.")};

        Account account1 = new Account(accountDetails1, messages1);

        LoginInfo loginInfo2 = new LoginInfo("steve", "password456");
        Address address2 = new Address("456 Oak St", "Greenville", StateEnum.California, "95947");
        AccountDetails details2 = new AccountDetails("Steve Smith", loginInfo2, address2);

        TimeStamp firstMessage2TimeStamp = new TimeStamp(MonthEnum.February, 10, 11, 15);
        Message firstMessage2 = new Message(firstMessage2TimeStamp, "Good morning!");
        TimeStamp secondMessage2TimeStamp = new TimeStamp(MonthEnum.March, 12, 16, 30);
        Message secondMessage2 = new Message(secondMessage2TimeStamp, "Had a great workout today.");
        TimeStamp thirdMessage2TimeStamp = new TimeStamp(MonthEnum.March, 13, 17, 45);
        Message thirdMessage2 = new Message(thirdMessage2TimeStamp, "Cooking a new recipe tonight.");

        Message[] messages2 = {firstMessage2, secondMessage2, thirdMessage2};

        Account account2 = new Account(details2, messages2);

        LoginInfo loginInfo3 = new LoginInfo("emilyr", "password789");
        Address address3 = new Address("789 Pine St", "Fairview", StateEnum.Michigan, "48621");
        AccountDetails details3 = new AccountDetails("Emily Roberts", loginInfo3, address3);

        TimeStamp firstMessage3TimeStamp = new TimeStamp(MonthEnum.January, 25, 13, 0);
        Message firstMessage3 = new Message(firstMessage3TimeStamp, "Excited for the weekend!");
        TimeStamp secondMessage3TimeStamp = new TimeStamp(MonthEnum.February, 28, 19, 30);
        Message secondMessage3 = new Message(secondMessage3TimeStamp, "Watching a new movie tonight.");
        TimeStamp thirdMessage3TimeStamp = new TimeStamp(MonthEnum.March, 3, 8, 15);
        Message thirdMessage3 = new Message(thirdMessage3TimeStamp, "Going for a hike tomorrow.");

        Message[] messages3 = {firstMessage3, secondMessage3, thirdMessage3};

        Account account3 = new Account(details3, messages3);


        accounts = new Account[]{account1, account2, account3};


    }

    /**
     * Simulates an account posting a new message.
     * The account should have an extra message when this method is over.
     * @param account the account which is posting a message
     * @param time the timestamp of when the message occurred
     * @param text the text of the message
     */
    public void postMessage(Account account, TimeStamp time, String text) {
        // TODO: Finish this method.
        Message newMessage = new Message(time, text);
        account.addMessage(newMessage);
    }

    /**
     * Print all the usernames. They should be alphabetized.
     * This should work with any number of accounts.
     */
    public void printUserNames() {
        System.out.println("Usernames:");
        // TODO: Finish this method.
//        for (Account account: accounts) {
//            System.out.println(account.getDetails().getLoginInfo().getUsername());
//        }
//    }
        String[] names = new String[accounts.length];
        for (int i = 0; i < accounts.length; i++) {
            names[i] = accounts[i].getDetails().getLoginInfo().getUsername();
        }
        Arrays.sort(names);
//        for (String name : names) {
//            System.out.println(name);
//        }
        System.out.println(Arrays.toString(names));
    }


    /**
     * Print the number of accounts in each state. Don't print states without accounts.
     * This method should work with any number of accounts.
     * Example result:
     * Alabama: 2
     * Arizona: 5
     * California: 17
     * ...
     */
    public void printStateCounts() {
        System.out.println("Accounts per State:");
        // TODO: Finish this method.
        StateEnum[] stateNames = StateEnum.values();
        int[] tallies = new int[50];
        for (Account account : accounts) {
            StateEnum accountState = account.getDetails().getAddress().getState();
            tallies[accountState.ordinal()]++;
        }

        for (int i = 0; i < tallies.length; i++) {
            if (tallies[i] > 0) {
                System.out.println(stateNames[i] + ": " + tallies[i]);
            }
        }
    }

    public static void main(String[] args) {
        SocialMediaApp app = new SocialMediaApp();

        app.loadDemoAccounts();

        System.out.println("Testing a Message Being Added");
        System.out.println("First Account Before Adding a new Message:");
        System.out.println(app.accounts[0]);
        System.out.println("First Account After Adding a new Message:");
        app.postMessage(app.accounts[0], new TimeStamp(MonthEnum.March, 30, 10, 05), "Going through a guided lecture");
        System.out.println(app.accounts[0]);


        System.out.println();
        app.printUserNames();

        System.out.println();
        app.printStateCounts();
    }

}
