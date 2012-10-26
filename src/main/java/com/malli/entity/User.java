package com.malli.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="sec_user")
public class User extends AbstractBaseEntity<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1884217617582367323L;
	
	@NotNull @Size(min=4, max=128)
    @Column(name="user_name", nullable=false, unique=true)
    private String username;
	
	@NotNull @Size(min=4, max=128)
    @Column(name="password", nullable=false, unique=true)
    private String password;
	
	
	@Enumerated(EnumType.STRING)
    @Column(name="role", nullable=false)
    @NotNull
    private Role role;
	
	
	public static User with(String userName, String password) {
		User user = new User();
		user.username = userName;
		user.password = password;
		return user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    public boolean isAdmin() {
        return (role == Role.ADMIN);
    }

    public boolean isPub() {
        return (role == Role.USER);
    }
    
    public boolean isVisitor() {
        return (role == Role.VISITOR);
    }

}
