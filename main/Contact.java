package main;

//Author: Craig Harrigan, SNHU CS-320

public class Contact {

  private static final String DEFAULT_STRING = "Default";
  private static final String DEFAULT_NUM = "1234556789";
  private String DEFAULT_CONTACT_ID = "ABCDEFGHI";
  private String contactId;
  private String firstName;
  private String lastName;
  private String phoneNumber;
  private String address;

  //TO-DO: Lock it down
  public Contact(){
    this.contactId = DEFAULT_CONTACT_ID;
    this.firstName = DEFAULT_STRING;
    this.lastName = DEFAULT_STRING;
    this.phoneNumber = DEFAULT_NUM;
    this.address = DEFAULT_STRING;
  }
  public Contact(String contactId){
    this.contactId = contactId;
    this.firstName = DEFAULT_STRING;
    this.lastName = DEFAULT_STRING;
    this.phoneNumber = DEFAULT_NUM;
    this.address = DEFAULT_STRING;
  }

  public Contact(String contactId, String firstName){
    this.contactId = contactId;
    updateFirstName(firstName);
    this.lastName = DEFAULT_STRING;
    this.phoneNumber = DEFAULT_NUM;
    this.address = DEFAULT_STRING;
  }

  public Contact(String contactId, String firstName, String lastName){
    this.contactId = contactId;
    updateFirstName(firstName);
    updateLastName(lastName);
    this.phoneNumber = DEFAULT_NUM;
    this.address = DEFAULT_STRING;
  }

  public Contact(String contactId, String firstName, String lastName, String phoneNumber){
    this.contactId = contactId;
    updateFirstName(firstName);
    updateLastName(lastName);
    updatePhoneNumber(phoneNumber);
    this.address = DEFAULT_STRING;
  }

  public Contact(String contactId, String firstName, String lastName, String phoneNumber, String address){
    this.contactId = contactId;
    updateFirstName(firstName);
    updateLastName(lastName);
    updatePhoneNumber(phoneNumber);
    updateAddress(address);
  }

  public final String getContactId(){
    return contactId;
  }

  public String getFirstName(){
    return firstName;
  }

  public final String getLastName(){
    return lastName;
  }

  public final String getPhoneNumber(){
    return phoneNumber;
  }

  public final String getAddress(){
    return address;
  }

  public void updateFirstName(String firstName){
    if (firstName == null){
      throw new IllegalArgumentException("First name cannot be null.");
    } else if (firstName.length() > 10){
      throw new IllegalArgumentException("First name cannot be longer than 10 characters");
    } else {
      this.firstName = firstName;
    }
  }

  public void updateLastName(String lastName){
    if (lastName == null){
      throw new IllegalArgumentException("Last name cannot be null.");
    } else if (lastName.length() > 10){
      throw new IllegalArgumentException("Last name cannot be longer than 10 characters");
    } else {
      this.lastName = lastName;
    }
  }

  public void updatePhoneNumber(String phoneNumber){
    String regex = "[0-9]+";
    if (phoneNumber == null){
      throw new IllegalArgumentException("Phone number cannot be null.");
    } else if (phoneNumber.length() != 10){
      throw new IllegalArgumentException(
          "Phone number length invalid. Ensure it is 10 digit format");
    } else if (!phoneNumber.matches(regex)) {
      throw new IllegalArgumentException(
          "Phone number cannot have anything but numbers");
    } else {
      this.phoneNumber = phoneNumber;
    }
  }

  public void updateAddress(String address){
    if (address == null) {
      throw new IllegalArgumentException("Address cannot be null.");
    } else if (address.length() > 30) {
      throw new IllegalArgumentException("Address cannot be longer than 30 characters");
    } else {
      this.address = address;
    }
  }
}
