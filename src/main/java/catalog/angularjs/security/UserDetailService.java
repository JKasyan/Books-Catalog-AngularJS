package catalog.angularjs.security;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

public class UserDetailService implements UserDetailsService{

    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_USER = "USER";

    List<UserDetails> details = Arrays.<UserDetails>asList(new SimpleUserDetails("user", "user", ROLE_USER),
            new SimpleUserDetails("admin", "admin", ROLE_USER, ROLE_ADMIN));

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        for(UserDetails detail: this.details){
            if(detail.getUsername().equalsIgnoreCase(userName)){
                return detail;
            }
        }
        return null;
    }

    static class SimpleUserDetails implements UserDetails{

        private String username;
        private String password;
        private boolean enabled = true;
        private Set<GrantedAuthority> authorities = new HashSet<>();

        public SimpleUserDetails(String username, String pw, String... extraRoles) {
            this.username = username;
            this.password = pw;

            // setup roles
            Set<String> roles = new HashSet<>();
            roles.addAll(Arrays.asList(null == extraRoles ? new String[0] : extraRoles));

            // export them as part of authorities

            authorities.addAll(
                    roles
                            .stream()
                            .map(r -> new SimpleGrantedAuthority(role(r)))
                            .collect(Collectors.toList()));

        }

        private String role(String i) {
            return "ROLE_" + i;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return this.authorities;
        }

        @Override
        public String getPassword() {
            return this.password;
        }

        @Override
        public String getUsername() {
            return this.username;
        }

        @Override
        public boolean isAccountNonExpired() {
            return this.enabled;
        }

        @Override
        public boolean isAccountNonLocked() {
            return this.enabled;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return this.enabled;
        }

        @Override
        public boolean isEnabled() {
            return this.enabled;
        }
    }

}
