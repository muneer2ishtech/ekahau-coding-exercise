package fi.ishtech.ekahau.codingexcercise.payload;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.ToString;

@Data
public class SigninRequest implements Serializable {

	private static final long serialVersionUID = -3212901867009255835L;

	@NotBlank
	private String username;

	@NotBlank
	@ToString.Exclude
	private String password;

}
