package utilities;



import com.github.javafaker.Faker;

public class RandomUtility {
	public String createAdminUserName() {
		Faker faker = new Faker();
		String username = faker.name().username();
		return username;
	}
		 
		 public String createPassword() {
			 Faker faker = new Faker();
			 String password = faker.internet().password(4, 6);
			 return password;
		 }
		 public String createSubcategory() {
			 Faker faker = new Faker();
			 String veggieSubcategory =  faker.food().ingredient();
			 return veggieSubcategory;

		 }
		 public String createAddress() {
			 Faker faker = new Faker();
			 String address = faker.address().fullAddress();
			 return address;
		 }
		 public String createPhoneNumber() {
			 Faker faker = new Faker();
			 String phonenumber = faker.phoneNumber().cellPhone();
			 return phonenumber;
		 }
		 public String createEmail() {
			 Faker faker = new Faker();
			 String email = faker.internet().emailAddress();
			 return email;
		 }
		 public String createCompany() {
			 Faker faker = new Faker();
			 String company = faker.company().name();
			 return company;
		 }
		 public String jobTitle() {
			 Faker faker = new Faker();
			 String jobTitle = faker.job().title();
			 return jobTitle;
		 }
		 public String dateOfBirth() {
			 Faker faker = new Faker();
			 String dateOfBirth = faker.date().birthday().toString();
			 return dateOfBirth;
		 }
		 public String website() {
			 Faker faker = new Faker();
			 String website = faker.internet().url();
			 return website;
		 }
		 public String city() {
			 Faker faker = new Faker();
			 String city = faker.address().city();
			 return city;
			 }
		 public String zipcode() {
			 Faker faker = new Faker();
			 String zipcode = faker.address().zipCode();
			 return zipcode;
			 }
}
