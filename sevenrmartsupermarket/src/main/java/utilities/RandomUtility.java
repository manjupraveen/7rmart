package utilities;

import org.openqa.selenium.WebElement;

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
		 
}
