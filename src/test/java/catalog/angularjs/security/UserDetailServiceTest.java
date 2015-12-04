package catalog.angularjs.security;

import org.junit.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
/**
 * Created by evgen on 31.08.15.
 */
public class UserDetailServiceTest {

    @Test
    public void newUserDetailServiceTest(){
        UserDetailService.SimpleUserDetails userDetails =
                new UserDetailService.SimpleUserDetails("user", "user", "USER");
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        assertEquals(authorities, userDetails.getAuthorities());
    }

    @Test
    public void severalRolesTest(){
        UserDetailService.SimpleUserDetails userDetails =
                new UserDetailService.SimpleUserDetails("user", "user", "USER", "ADMIN", "SUPPORT");
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        authorities.add(new SimpleGrantedAuthority("ROLE_SUPPORT"));
        assertEquals(authorities, userDetails.getAuthorities());
    }
}
