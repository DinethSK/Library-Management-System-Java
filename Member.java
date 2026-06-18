public class Member {
    private String memberId;
    private String name;

    // Constructor to create a library user
    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    // Getters to fetch member data
    public String getMemberId() { return memberId; }
    public String getName() { return name; }
}