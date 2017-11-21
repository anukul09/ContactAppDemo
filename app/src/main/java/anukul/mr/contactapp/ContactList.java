package anukul.mr.contactapp;

public class ContactList {

    String name;
    String pno;

    public ContactList() {
    }

    public ContactList(String name, String pno) {
        this.name = name;
        this.pno = pno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPno() {
        return pno;
    }

    public void setPno(String pno) {
        this.pno = pno;
    }
}