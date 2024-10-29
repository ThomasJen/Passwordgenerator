import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class PasswordCracker {

	 public static String hashString(String input) {
	        try {
	            MessageDigest digest = MessageDigest.getInstance("SHA-256");
	            byte[] hashBytes = digest.digest(input.getBytes());
	            StringBuilder hexString = new StringBuilder();
	            for (byte b : hashBytes) {
	                String hex = Integer.toHexString(0xff & b);
	                if (hex.length() == 1) hexString.append('0');
	                hexString.append(hex);
	            }
	            return hexString.toString();
	        } catch (NoSuchAlgorithmException e) {
	            throw new RuntimeException("SHA-256 algorithm not found!", e);
	        }
	    }
	 
	 public static String crackPassword(String targetHash, List<String> dictionary) {
	        for (String password : dictionary) {
	            String hashedPassword = hashString(password);
	            if (hashedPassword.equals(targetHash)) {
	                return password; // Return the matching password
	            }
	        }
	        return null; // Return null if no match found
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  
			Scanner scanner = new Scanner(System.in);

	        // Prompt user for target hash
	        System.out.print("Enter the SHA-256 hash you want to crack: ");
	        String targetHash = scanner.nextLine();

	        // Example dictionary of passwords (you can expand this list)
	        List<String> dictionary = Arrays.asList("123456", "password", "123456789", "qwerty", "abc123");

	        // Attempt to crack the password
	        String result = crackPassword(targetHash, dictionary);

	        if (result != null) {
	            System.out.println("Password found: " + result);
	        } else {
	            System.out.println("Password not found in dictionary.");
	        }

	        scanner.close();
		
	    }

}


