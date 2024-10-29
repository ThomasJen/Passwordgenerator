import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;

public class HashGenerator {

	public static String hashString(String input) {
		
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
		
			byte[] hashBytes = digest.digest(input.getBytes());
			
			StringBuilder hexString = new StringBuilder();
			for(byte b : hashBytes) {
				String hex = Integer.toHexString(0xff & b);
				if(hex.length() == 1) hexString.append('0');
				hexString.append(hex);
			}
			
			return hexString.toString();
		} catch(NoSuchAlgorithmException e) {
			throw new RuntimeException("SHA-256 algorithm not found!", e);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  // Pop-up dialog to get user input
        String input = JOptionPane.showInputDialog(null, "Enter a string to hash:", 
                                                   "Hash Generator", JOptionPane.PLAIN_MESSAGE);

        // Check if input is not null (user did not click "Cancel")
        if (input != null) {
            // Hash the input
            String hashed = hashString(input);

            // Show the result in another dialog
            JOptionPane.showMessageDialog(null, "SHA-256 Hash:\n" + hashed,
                                          "Hash Result", JOptionPane.INFORMATION_MESSAGE);
        }
		
	}

}
