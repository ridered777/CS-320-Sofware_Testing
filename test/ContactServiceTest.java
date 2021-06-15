package test;

//Author: Craig Harrigan, SNHU CS-320

import main.ContactService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
  protected String contactId, firstNameTest, lastNameTest, phoneNumberTest,
      addressTest;
  protected String tooLongContactId, tooLongFirstName, tooLongLastName,
      tooLongPhoneNumber, tooShortPhoneNumber, tooLongAddress;

  private static final String DEFAULT_STRING = "Default";
  private static final String DEFAULT_NUM = "1234556789";
  private String DEFAULT_CONTACT_ID = "ABCDEFGHI";

  @BeforeEach
  void setUp() {
    contactId = "ABCDEFGHIJ";
    firstNameTest = "John";
    lastNameTest = "Smith";
    phoneNumberTest = "5558881234";
    //The max length is set per requirements but consider making longer, this brief test address is at the limit...
    addressTest = "13 Main St, Nashua NH 03031";
    tooLongContactId = "1234567891011";
    tooLongFirstName = "This is a really long name";
    tooLongLastName = "This is a really long name";
    tooLongPhoneNumber = "1234567891011";
    tooShortPhoneNumber = "1";
    tooLongAddress = "This is a really long address, this is a really long address, this is a really long address";
  }

  @Test
  void testNewContact(){
    ContactService service = new ContactService();
    service.newContact();
    Assertions.assertAll(
        "Service Constructor 0",
        ()
            -> Assertions.assertNotNull(service.getContactList().get(0).getContactId()),
        ()
            -> Assertions.assertEquals(DEFAULT_STRING,
                            service.getContactList().get(0).getFirstName()),
        ()
            -> Assertions.assertEquals(DEFAULT_STRING,
                            service.getContactList().get(0).getLastName()),
        ()
            -> Assertions.assertEquals(DEFAULT_NUM,
                            service.getContactList().get(0).getPhoneNumber()),
        ()
            -> Assertions.assertEquals(DEFAULT_STRING,
                            service.getContactList().get(0).getAddress()));
    service.newContact(firstNameTest);
    Assertions.assertAll(
        "Service Constructor 1",
        ()
            -> Assertions.assertNotNull(service.getContactList().get(1).getContactId()),
        ()
            -> Assertions.assertEquals(firstNameTest,
                            service.getContactList().get(1).getFirstName()),
        ()
            -> Assertions.assertEquals(DEFAULT_STRING,
                            service.getContactList().get(1).getLastName()),
        ()
            -> Assertions.assertEquals(DEFAULT_NUM,
                            service.getContactList().get(1).getPhoneNumber()),
        ()
            -> Assertions.assertEquals(DEFAULT_STRING,
                            service.getContactList().get(1).getAddress()));
    service.newContact(firstNameTest, lastNameTest);
    Assertions.assertAll(
        "Service Constructor 2",
        ()
            -> Assertions.assertNotNull(service.getContactList().get(2).getContactId()),
        ()
            -> Assertions.assertEquals(firstNameTest,
                            service.getContactList().get(2).getFirstName()),
        ()
            -> Assertions.assertEquals(lastNameTest,
                            service.getContactList().get(2).getLastName()),
        ()
            -> Assertions.assertEquals(DEFAULT_NUM,
                            service.getContactList().get(2).getPhoneNumber()),
        ()
            -> Assertions.assertEquals(DEFAULT_STRING,
                            service.getContactList().get(2).getAddress()));
    service.newContact(firstNameTest, lastNameTest, phoneNumberTest);
    Assertions.assertAll(
        "Service Constructor 3",
        ()
            -> Assertions.assertNotNull(service.getContactList().get(3).getContactId()),
        ()
            -> Assertions.assertEquals(firstNameTest,
                            service.getContactList().get(3).getFirstName()),
        ()
            -> Assertions.assertEquals(lastNameTest,
                            service.getContactList().get(3).getLastName()),
        ()
            -> Assertions.assertEquals(phoneNumberTest,
                            service.getContactList().get(3).getPhoneNumber()),
        ()
            -> Assertions.assertEquals(DEFAULT_STRING,
                            service.getContactList().get(3).getAddress()));
    service.newContact(firstNameTest, lastNameTest, phoneNumberTest,
                       addressTest);
    Assertions.assertAll(
        "Service Constructor all",
        ()
            -> Assertions.assertNotNull(service.getContactList().get(4).getContactId()),
        ()
            -> Assertions.assertEquals(firstNameTest,
                            service.getContactList().get(4).getFirstName()),
        ()
            -> Assertions.assertEquals(lastNameTest,
                            service.getContactList().get(4).getLastName()),
        ()
            -> Assertions.assertEquals(phoneNumberTest,
                            service.getContactList().get(4).getPhoneNumber()),
        ()
            -> Assertions.assertEquals(addressTest,
                            service.getContactList().get(4).getAddress()));
  }

  @Test
  void deleteContactTest() {
    ContactService service = new ContactService();
    service.newContact();
    Assertions.assertThrows(Exception.class,
            ()
                    -> service.deleteContact(contactId));
    Assertions.assertAll("Service Delete Contact",
            ()
                    -> service.deleteContact(service.getContactList().get(0).getContactId()));
  }

  @Test
  void updateFirstNameTest() throws Exception {
    ContactService service = new ContactService();
    service.newContact();
    service.updateFirstName(service.getContactList().get(0).getContactId(), firstNameTest);
    Assertions.assertEquals(firstNameTest, service.getContactList().get(0).getFirstName());
    Assertions.assertThrows(IllegalArgumentException.class,
                 ()
                         -> service.updateFirstName(service.getContactList().get(0).getContactId(), tooLongFirstName));
    Assertions.assertThrows(IllegalArgumentException.class,
                 ()
                         -> service.updateFirstName(service.getContactList().get(0).getContactId(), null));
    Assertions.assertThrows(Exception.class,
                 ()
                         -> service.updateFirstName(contactId, firstNameTest));
  }

  @Test
  void updateLastNameTest() throws Exception {
    ContactService service = new ContactService();
    service.newContact();
    service.updateLastName(service.getContactList().get(0).getContactId(), lastNameTest);
    Assertions.assertEquals(lastNameTest, service.getContactList().get(0).getLastName());
    Assertions.assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updateLastName(service.getContactList().get(0).getContactId(), tooLongLastName));
    Assertions.assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updateLastName(service.getContactList().get(0).getContactId(), null));
    Assertions.assertThrows(Exception.class,
                 () -> service.updateLastName(contactId, lastNameTest));
  }

  @Test
  void updatePhoneNumberTest() throws Exception {
    ContactService service = new ContactService();
    service.newContact();
    service.updatePhoneNumber(service.getContactList().get(0).getContactId(), phoneNumberTest);
    Assertions.assertEquals(phoneNumberTest, service.getContactList().get(0).getPhoneNumber());
    Assertions.assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updatePhoneNumber(service.getContactList().get(0).getContactId(), tooLongPhoneNumber));
    Assertions.assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updatePhoneNumber(service.getContactList().get(0).getContactId(), tooShortPhoneNumber));
    Assertions.assertThrows(
        IllegalArgumentException.class,
            ()
                    -> service.updatePhoneNumber(service.getContactList().get(0).getContactId(), contactId));
    Assertions.assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updatePhoneNumber(service.getContactList().get(0).getContactId(), null));
    Assertions.assertThrows(Exception.class,
                 () -> service.updatePhoneNumber(contactId, lastNameTest));
  }

  @Test
  void updateAddressTest() throws Exception {
    ContactService service = new ContactService();
    service.newContact();
    service.updateAddress(service.getContactList().get(0).getContactId(),
                          addressTest);
    Assertions.assertEquals(addressTest, service.getContactList().get(0).getAddress());
    Assertions.assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updateAddress(
                         service.getContactList().get(0).getContactId(),
                         tooLongAddress));
    Assertions.assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.updateAddress(
                         service.getContactList().get(0).getContactId(), null));
    Assertions.assertThrows(Exception.class,
                 () -> service.updateAddress(contactId, addressTest));
  }
}
