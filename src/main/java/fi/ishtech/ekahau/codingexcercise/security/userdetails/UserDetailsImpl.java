package fi.ishtech.ekahau.codingexcercise.security.userdetails;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Muneer Ahmed Syed
 */
@NoArgsConstructor
public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 6774079004291687456L;

	@Getter
	@Setter(lombok.AccessLevel.PRIVATE)
	private Long id;

	@Getter
	@Setter(lombok.AccessLevel.PRIVATE)
	private String username;

	@Getter
	@Setter(lombok.AccessLevel.PRIVATE)
	@JsonIgnore
	private String password;

	@Getter
	@Setter(lombok.AccessLevel.PRIVATE)
	private Collection<? extends GrantedAuthority> authorities;

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public static UserDetails of(Long id, String username, String password) {
		UserDetailsImpl userDetails = new UserDetailsImpl();

		userDetails.setId(id);
		userDetails.setUsername(username);
		userDetails.setPassword(password);

		userDetails.setAuthorities(Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));

		return userDetails;
	}

}
