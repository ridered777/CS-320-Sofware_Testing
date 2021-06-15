package test;

//Author: Craig Harrigan, SNHU CS-320

import main.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest{

  protected String contactId, firstNameTest, lastNameTest, phoneNumberTest,
          addressTest;

  protected String tooLongContactId, tooLongFirstName, tooLongLastName,
          tooLongPhoneNumber, tooShortPhoneNumber, tooLongAddress;

  @BeforeEach
  void initialize() {
    contactId = "ABCDEFGHI";
    firstNameTest = "Jim";
    lastNameTest = "Belushi";
    phoneNumberTest = "6031234567";
    //The max length is set per requirements but consider making longer, this brief test address is at the limit...
    addressTest = "1 Main St, Nashua NH 03031";
    tooLongContactId = "1234567891011121314151617181920";
    tooLongFirstName = "This is a really really long name";
    tooLongLastName = "This is a really really long name";
    tooLongPhoneNumber = "1234567891011";
    tooShortPhoneNumber = "1";
    tooLongAddress = "This is a long address, This is a long address, this is a long address";
  }

  @Test
  void testContactBaseConstructor() {
    Contact contact = new Contact();
    Assertions.assertAll("Contact Constructor 0",
            ()
                    -> Assertions.assertEquals(contactId, contact.getContactId()),
            ()
                    -> Assertions.assertNotNull(contact.getFirstName()),
            ()
                    -> Assertions.assertNotNull(contact.getLastName()),
            ()
                    -> Assertions.assertNotNull(contact.getPhoneNumber()),
            () -> Assertions.assertNotNull(contact.getAddress()));
  }
  @Test
  void testContactIDConstructor() {
    Contact contact = new Contact(contactId);
    Assertions.assertAll("Contact Constructor 1",
            ()
                    -> Assertions.assertEquals(contactId, contact.getContactId()),
            ()
                    -> Assertions.assertNotNull(contact.getFirstName()),
            ()
                    -> Assertions.assertNotNull(contact.getLastName()),
            ()
                    -> Assertions.assertNotNull(contact.getPhoneNumber()),
            () -> Assertions.assertNotNull(contact.getAddress()));
  }

  @Test
  void testContactIdAndFirstNameConstructor() {
    Contact contact = new Contact(contactId, firstNameTest);
    Assertions.assertAll("Contact Constructor 3",
            ()
                    -> Assertions.assertEquals(contactId, contact.getContactId()),
            ()
                    -> Assertions.assertEquals(firstNameTest, contact.getFirstName()),
            ()
                    -> Assertions.assertNotNull(contact.getLastName()),
            ()
                    -> Assertions.assertNotNull(contact.getPhoneNumber()),
            () -> Assertions.assertNotNull(contact.getAddress()));
  }

  @Test
  void testContactIdAndFullNameConstructor() {
    Contact contact = new Contact(contactId, firstNameTest, lastNameTest);
    Assertions.assertAll("Contact Constructor 3",
            ()
                    -> Assertions.assertEquals(contactId, contact.getContactId()),
            ()
                    -> Assertions.assertEquals(firstNameTest, contact.getFirstName()),
            ()
                    -> Assertions.assertEquals(lastNameTest, contact.getLastName()),
            ()
                    -> Assertions.assertNotNull(contact.getPhoneNumber()),
            () -> Assertions.assertNotNull(contact.getAddress()));
  }

  @Test
  void testContactIdFullNamePhoneNumberConstructor() {
    Contact contact =
            new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest);
    Assertions.assertAll("Contact Constructor 4",
            ()
                    -> Assertions.assertEquals(contactId, contact.getContactId()),
            ()
                    -> Assertions.assertEquals(firstNameTest, contact.getFirstName()),
            ()
                    -> Assertions.assertEquals(lastNameTest, contact.getLastName()),
            ()
                    -> Assertions.assertEquals(phoneNumberTest, contact.getPhoneNumber()),
            () -> Assertions.assertNotNull(contact.getAddress()));
  }

  @Test
  void testAllConstructor() {
    Contact contact = new Contact(contactId, firstNameTest, lastNameTest,
            phoneNumberTest, addressTest);
    Assertions.assertAll("Contact Constructor all",
            ()
                    -> Assertions.assertEquals(contactId, contact.getContactId()),
            ()
                    -> Assertions.assertEquals(firstNameTest, contact.getFirstName()),
            ()
                    -> Assertions.assertEquals(lastNameTest, contact.getLastName()),
            ()
                    -> Assertions.assertEquals(phoneNumberTest, contact.getPhoneNumber()),
            () -> Assertions.assertEquals(addressTest, contact.getAddress()));
  }

  @Test
  void testUpdateFirstName() {
    Contact contact = new Contact(contactId,"");
    contact.updateFirstName(firstNameTest);
    Assertions.assertAll(
            "Contact Update First Name",
            ()
                    -> Assertions.assertEquals(firstNameTest, contact.getFirstName()),
            ()
                    -> Assertions.assertThrows(IllegalArgumentException.class,
                    () -> contact.updateFirstName(null)),
            ()
                    -> Assertions.assertThrows(IllegalArgumentException.class,
                    () -> contact.updateFirstName(tooLongFirstName)));
  }

  @Test
  void testUpdateLastName() {
    Contact contact = new Contact(contactId,firstNameTest,"");
    contact.updateLastName(lastNameTest);
    Assertions.assertAll(
            "Contact Update Last Name",
            ()
                    -> Assertions.assertEquals(lastNameTest, contact.getLastName()),
            ()
                    -> Assertions.assertThrows(IllegalArgumentException.class,
                    () -> contact.updateLastName(null)),
            ()
                    -> Assertions.assertThrows(IllegalArgumentException.class,
                    () -> contact.updateLastName(tooLongFirstName)));
  }

  @Test
  void testUpdatePhoneNumber() {
    Contact contact = new Contact(contactId,firstNameTest,lastNameTest);
    contact.updatePhoneNumber(phoneNumberTest);
    Assertions.assertAll("Contact Update Phone #",
            ()
                    -> Assertions.assertEquals(phoneNumberTest, contact.getPhoneNumber()),
            ()
                    -> Assertions.assertThrows(IllegalArgumentException.class,
                    () -> contact.updatePhoneNumber(null)),
            ()
                    -> Assertions.assertThrows(
                    IllegalArgumentException.class,
                    () -> contact.updatePhoneNumber(tooLongPhoneNumber)),
            ()
                    -> Assertions.assertThrows(
                    IllegalArgumentException.class,
                    () -> contact.updatePhoneNumber(tooShortPhoneNumber)),
            ()
                    -> Assertions.assertThrows(IllegalArgumentException.class,
                    () -> contact.updatePhoneNumber(contactId)));
  }

  @Test
  void testUpdateAddress() {
    Contact contact = new Contact(contactId,firstNameTest,lastNameTest,phoneNumberTest,"");
    contact.updateAddress(addressTest);
    Assertions.assertAll("Contact Update Address",
            ()
                    -> Assertions.assertEquals(addressTest, contact.getAddress()),
            ()
                    -> Assertions.assertThrows(IllegalArgumentException.class,
                    () -> contact.updateAddress(null)),
            ()
                    -> Assertions.assertThrows(IllegalArgumentException.class,
                    () -> contact.updateAddress(tooLongAddress)));
  }
}
