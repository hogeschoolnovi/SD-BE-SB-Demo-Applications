# Https ****************************************************

* port 8443

# Users ****************************************************

* admin - password
* user - password

# Endpoints ****************************************************

* GET       base endpoint or home

* GET       admin

* GET       authenticated

* GET       info

* GET       users
* POST      users
* GET       users/{username}
* PUT       users/{username}
* PATCH     users/{username}
* DELETE    users/{username}
* GET       users/{username}/authorities
* POST      users/{username}/authorities
* DELETE    users/{username}/authorities/{authority}

* GET       v1/books
* POST      v1/books
* GET       v1/books/{id}
* PUT       v1/books/{id}
* PATCH     v1/books/{id}
* DELETE    v1/books/{id}


# Opbouw stappen

1. model User
2. model Authority
3. AuthorityKey met @IdClass(AuthorityKey.class) in Authorty
4. @OneToMany van User naar Authority
5. In application.properties MySql configuren
6. In data.sql users en authorities toevoegen in DB
7. UserRepository extends JpaRepository
8. UserService en UserServiceImpl
9. UsersController for de endpoints
10. CustomUserDetailsService implements UserDetailsService
11. Definieer loadUserByUsername
12. Implementeer exception UsernameNotFoundException
13. In pom.xml spring-boot-starter-security toevoegen. Vergeet niet maven te updaten.
14. SpringSecurityConfig extends WebSecurityConfigurerAdapter
15. In configGlobal method auth.userDetailsService(customUserDetailsService)
16. Implementeer Bean PasswordEncoder
17. authorizeRequests met antMatchers en hasRole
18. httpBasic aan zetten
