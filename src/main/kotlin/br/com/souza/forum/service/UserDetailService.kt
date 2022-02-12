package br.com.souza.forum.service

import br.com.souza.forum.model.Usuario
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails


class UserDetailService(
    private val usuario: Usuario
) : UserDetails {

    override fun getAuthorities() = null

    override fun getPassword() = usuario.password

    override fun getUsername() = usuario.email

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true

}