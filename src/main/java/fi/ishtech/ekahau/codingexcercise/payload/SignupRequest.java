package fi.ishtech.ekahau.codingexcercise.payload;

import java.io.Serializable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.ToString;

@Data
public class SignupRequest implements Serializable {

	private static final long serialVersionUID = -6136907747364968585L;

	@NotBlank
	@Email
	private String username;

	@NotBlank
	@ToString.Exclude
	private String password;

	@NotBlank
	@ToString.Exclude
	private String passwordRepeat;

	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	/*
	 * @AssertTrue(message = "password and passwordRepeat are not matching")
	 * 
	 * @JsonIgnore public boolean isPasswordRepeat() { return
	 * password.equals(passwordRepeat); }
	 */
}
