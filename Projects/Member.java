public class Member {

    private int memberId;
    private String memberName;
    private int age;
    private String phoneNumber;
    private String membershipPlan;
    private int monthlyFee;

    private int membershipMonths;
    private int totalRenewalAmount;

    private int totalDays;
    private int attendedDays;

    private int totalPaid;
    private int paymentCount;

    public Member(int memberId, String memberName, int age,
                   String phoneNumber, String membershipPlan,
                   int monthlyFee) {

        this.memberId = memberId;
        this.memberName = memberName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.membershipPlan = membershipPlan;
        this.monthlyFee = monthlyFee;

        this.membershipMonths = 0;
        this.totalRenewalAmount = 0;
        this.totalDays = 0;
        this.attendedDays = 0;
        this.totalPaid = 0;
        this.paymentCount = 0;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMembershipPlan() {
        return membershipPlan;
    }

    public int getMonthlyFee() {
        return monthlyFee;
    }

    public int getMembershipMonths() {
        return membershipMonths;
    }

    public int getTotalRenewalAmount() {
        return totalRenewalAmount;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public int getAttendedDays() {
        return attendedDays;
    }

    public int getTotalPaid() {
        return totalPaid;
    }

    public int getPaymentCount() {
        return paymentCount;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setMembershipPlan(String membershipPlan,
                                  int monthlyFee) {

        this.membershipPlan = membershipPlan;
        this.monthlyFee = monthlyFee;
    }

    public void renewMembership(int months) {

        int amount = monthlyFee * months;

        membershipMonths += months;
        totalRenewalAmount += amount;
    }

    public void markAttendance(boolean present) {

        totalDays++;

        if (present) {
            attendedDays++;
        }
    }

    public void makePayment(int amount) {

        totalPaid += amount;
        paymentCount++;
    }

    public double getAttendancePercentage() {

        if (totalDays == 0) {
            return 0;
        }

        return ((double) attendedDays / totalDays) * 100;
    }

    public void displayDetails() {

        System.out.println("----------------------------");
        System.out.println("Member ID: " + memberId);
        System.out.println("Name: " + memberName);
        System.out.println("Age: " + age);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Plan: " + membershipPlan);
        System.out.println("Monthly Fee: ₹" + monthlyFee);
        System.out.println(
                "Membership Duration: "
                        + membershipMonths + " month(s)");
        System.out.println(
                "Total Paid: ₹" + totalPaid);
    }
}