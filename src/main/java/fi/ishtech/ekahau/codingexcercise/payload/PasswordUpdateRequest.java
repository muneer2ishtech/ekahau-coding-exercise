package fi.ishtech.ekahau.codingexcercise.payload;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.ToString;

@Data
public class PasswordUpdateRequest implements Serializable {

	private static final long serialVersionUID = -2440397596568638277L;

	@NotBlank
	@ToString.Exclude
	private String password;

	@NotBlank
	@ToString.Exclude
	private String passwordRepeat;

	@AssertTrue(message = "password and passwordRepeat are not matching")
	@JsonIgnore
	public boolean isPasswordAndPasswordRepeatMatch() {
		return password.equals(passwordRepeat);
	}

}
